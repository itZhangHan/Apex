package com.els.WebSockerServer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;

import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class DownUpType implements InterfaceType {

	@Override
	public synchronized String onMessage(SocketMessage message) {
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		List<PositionMessage> positionMessage = new ArrayList<PositionMessage>();
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					if (object != null) {
						if (object.getSocketUser().getStatus() == 0) {
							//设置房主图片
							//message.setHeadimgurl(object.getSocketUser().getUserportrait());
							positionMessage.add(object.getPositionMessage());
							System.out.println("第一次＋图片");
						}
						/*
						 * if (object.getSocketUser().getStatus() == 1) {
						 * positionMessage.add(object.getPositionMessage()); }
						 */
					}

					message.setUserStatus("1");
					message.setType("down");
					List<PositionMessage> listImgs = new ArrayList<>();
					if (message != null) {
						if (object.getPositionMessage() != message.getPositionMessage()) {
							positionMessage.add(message.getPositionMessage());
							System.out.println("第2次＋图片");
						}
					}
					listImgs.addAll(positionMessage);
					System.out.println("在座的人的长度为：" + listImgs.size());
					for (PositionMessage positionMessage2 : listImgs) {
						System.out.println("集合中的图片：" + positionMessage2.getNowImg());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
