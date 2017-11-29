package com.els.WebSockerServer;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class GetOnclient implements InterfaceType {

	@Override
	public String onMessage(SocketMessage message) {
		// TODO Auto-generated method stub
		System.out.println("进入分发在线人数消息方法");
		// 上座下座
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					try {
						//设置坐下状态为玩家
						message.setSetOnclient(WebSocketServer.getOnlineCount());
						object.getSession().getBasicRemote().sendObject(message);
					} catch (EncodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}

}
