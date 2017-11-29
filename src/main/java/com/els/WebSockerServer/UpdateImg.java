package com.els.WebSockerServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.common.SocketUsers;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class UpdateImg implements InterfaceType {

	@Override
	public String onMessage(SocketMessage message) {
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		List<PositionMessage> positionMessage = new ArrayList<PositionMessage>();
		for (WebSocketServer object : arrayset) {
			try {
				if (message != null) {
					if (message.getPositionMessage()!=null) {
						System.out.println(message.getPositionMessage()+"sssssssssssssssssssssssssssssssssssssssssssssssssssssss");
						System.out.println(message.getPositionMessage().getNowImg()+"=img;position="+message.getPositionMessage().getPosition());
						positionMessage.add(object.getPositionMessage());
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			if (message != null)
				// 返回当前在线人数
				message.setListImgs(positionMessage);
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
