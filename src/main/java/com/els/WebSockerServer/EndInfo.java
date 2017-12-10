package com.els.WebSockerServer;

import java.util.concurrent.CopyOnWriteArraySet;

import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class EndInfo implements InterfaceType {

	@Override
	public String onMessage(SocketMessage message) {
		// TODO Auto-generated method stub
		CopyOnWriteArraySet<WebSocketServer> arraySet = SocketManger.getRoomArray(message.getRoomId());
		
		return null;
	}

}
