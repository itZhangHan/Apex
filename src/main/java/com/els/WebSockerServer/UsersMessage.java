package com.els.WebSockerServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.common.SocketUsers;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class UsersMessage extends BaseType {

	public String onMessage(SocketMessage message) {
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		List<SocketUsers> list = new ArrayList<SocketUsers>();
		for (WebSocketServer object : arrayset) {
			try {
				if (message != null) {
					if (message.getSocketUser() != null) {
						list.add(object.getSocketUser());
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
				System.out.println("*********");
				System.out.println("获取到当前的在线人数=" + WebSocketServer.getOnlineCount());
				System.out.println("*********");
				message.setGetOnclient(WebSocketServer.getOnlineCount());
				message.setListUsers(list);
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
