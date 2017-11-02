package com.els.WebSockerServer;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class ScoreType implements InterfaceType {

	@Override
	public String onMessage(SocketMessage message) {
		System.out.println("进入分发实时分数方法");
		// TODO Auto-generated method stub
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					try {
						System.out.println("sendScoretype...");
						object.getSession().getBasicRemote().sendObject(message);
					} catch (EncodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// object.session.getAsyncRemote()).sendMessage(message.getMsgStr());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}