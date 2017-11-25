package com.els.WebSockerServer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.socket.ReadUsersInfo;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class ReadyToDownUp implements InterfaceType {

	@Override
	public String onMessage(SocketMessage message) {
		// TODO Auto-generated method stub
		System.out.println("进入分发起立");
		Integer userId = Integer.parseInt(message.getUserId());
		// 上座下座
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					try {
						String roomId = message.getRoomId();
						ReadUsersInfo readers = message.getReaders();
						Map<String,String> map = new HashMap<>();
							
//						map.put("1", value);
//						map.put("2", value);
//						map.put("3", value);
//						map.put("4", value);
					//	readers.setPositions();
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
