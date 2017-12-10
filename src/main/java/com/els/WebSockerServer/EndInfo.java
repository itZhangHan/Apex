package com.els.WebSockerServer;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class EndInfo implements InterfaceType {

	@Override
	public synchronized String onMessage(SocketMessage message) {
		// TODO Auto-generated method stub
		CopyOnWriteArraySet<WebSocketServer> arraySet = SocketManger.getRoomArray(message.getRoomId());
		if(arraySet != null){
			for (WebSocketServer obj : arraySet) {
				try {
					TimeUnit.SECONDS.sleep(10);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

}
