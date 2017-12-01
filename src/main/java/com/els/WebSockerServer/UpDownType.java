package com.els.WebSockerServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.socket.ReadUsersInfo;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

/**
 * 坐下起立消息闭塞处理
 * 
 * @author Administrator
 *
 */
public class UpDownType extends BaseType {

	@Override
	public synchronized String onMessage(SocketMessage message) {
		// TODO Auto-generated method stub
		System.out.println("进入分发起立");
		Integer userId = Integer.parseInt(message.getUserId());
		List<PositionMessage> positionMessage = new ArrayList<PositionMessage>();
		List<PositionMessage> listImgs = new ArrayList<>();
		// 上座下座
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {

					Integer status = object.getSocketUser().getStatus();
					System.out.println("原有状态：" + status);
					if (status == 0) {
						// 设置头像
						message.setOwnerImg(object.getSocketUser().getUserportrait());
						positionMessage.add(object.getPositionMessage());
						System.out.println("加进去房主");
					}
					if (status == 1) {
						positionMessage.add(object.getPositionMessage());
						System.out.println("加进去第二个");
					}
					message.setUserStatus("2");
					message.setType("up");
					if (object != null) {
						if (message.getUserStatus() == "2") {
							positionMessage.remove(message.getPositionMessage());
							System.out.println("删除第二个。。。");
						}
					}
					if (object.getPositionMessage().getNowImg() == message.getPositionMessage().getNowImg()) {
						positionMessage.remove(message.getPositionMessage());
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			listImgs.addAll(positionMessage);
			System.out.println("取消坐下之后再坐的人的大小为：" + listImgs.size());
			for (PositionMessage positionMessage2 : listImgs) {
				System.out.println("集合中的图片：" + positionMessage2.getNowImg());
			}
		}
		try {
			if (message != null)
				// 返回当前在线人数
				message.setListImgs(positionMessage);
			for (WebSocketServer object : arrayset) {
				object.getSession().getBasicRemote().sendObject(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
