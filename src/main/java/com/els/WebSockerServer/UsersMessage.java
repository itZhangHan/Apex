package com.els.WebSockerServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.bean.JhddPositionimg;
import com.els.common.SocketUsers;
import com.els.common.SpringContextUtil;
import com.els.serviceinterface.PositionImgService;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class UsersMessage extends BaseType {
	// 工具类调用service去操作数据库
	PositionImgService positionImgService = (PositionImgService) SpringContextUtil.getBean("positionImgService");

	public String onMessage(SocketMessage message) {
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		List<SocketUsers> list = new ArrayList<SocketUsers>();
		// 查询数据库中的值
		JhddPositionimg positionImg = positionImgService.selectByRoomId(Integer.parseInt(message.getRoomId()));
		for (WebSocketServer object : arrayset) {
			try {
				// 查询数据库中的值
				if (positionImg != null) {
					if (object != null) {
						if ((object.getSocketUser().getStatus() == 0) == true) {
							// 将用户状态为0的玩家（房主）的头像与赋给数据库中imgOne字段
							// if(positionImg == null){
							positionImg.setImgone(object.getSocketUser().getUserportrait());
							// }
							// 将此头像设置给message
							message.setImgOne(positionImg.getImgone());
							message.setRoomName(object.getSocketUser().getUsername() + "的房间");
						}
					}
					// 赋值剩下的字段
					message.setImgTwo(positionImg.getImgtwo());
					message.setImgThree(positionImg.getImgthree());
					message.setImgFour(positionImg.getImgfour());
					// 去更新数据库
					
				} else {

					JhddPositionimg newPositionImg = new JhddPositionimg();
					if (object != null) {
						if ((object.getSocketUser().getStatus() == 0) == true) {
							// 将用户状态为0的玩家（房主）的头像与赋给数据库中imgOne字段
							newPositionImg.setImgone(object.getSocketUser().getUserportrait());
							// 将此头像设置给message
							message.setImgOne(newPositionImg.getImgone());
							message.setRoomName(object.getSocketUser().getUsername() + "的房间");
						}
					}
					// 赋值剩下的字段
					newPositionImg.setImgtwo("");
					newPositionImg.setImgthree("");
					newPositionImg.setImgfour("");
					newPositionImg.setRoomid(Integer.parseInt(message.getRoomId()));
					positionImgService.addImg(newPositionImg);
					message.setImgTwo(newPositionImg.getImgtwo());
					message.setImgThree(newPositionImg.getImgthree());
					message.setImgFour(newPositionImg.getImgfour());
				}
				List<PositionMessage> listImgs = new ArrayList<>();
				message.setListImgs(listImgs);
				// 向集合中添加玩家信息
				if (message.getSocketUser() != null) {
					list.add(object.getSocketUser());
				}
				positionImgService.updateImg(positionImg);
				message.setImgOne(positionImg.getImgone());
				message.setImgTwo(positionImg.getImgtwo());
				message.setImgThree(positionImg.getImgthree());
				message.setImgFour(positionImg.getImgfour());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			if (message != null)
				message.setListUsers(list);
			// message.setListImgs(positionMessage);
			for (WebSocketServer object : arrayset) {
				object.getSession().getBasicRemote().sendObject(message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
