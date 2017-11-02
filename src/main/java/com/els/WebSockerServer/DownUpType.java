package com.els.WebSockerServer;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class DownUpType implements InterfaceType {

	@Override
	public String onMessage(SocketMessage message) {
		// TODO Auto-generated method stub
		System.out.println("进入分发起立坐下消息方法");
		// 上座下座
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					try {
						// 0:房主，1:玩家,2:旁观者
						if ("2".equals(message.getUserStatus())) {
							System.out.println("将当前状态2(旁观者)改为1(玩家)");
							message.setUserStatus("1");
							object.getSession().getBasicRemote().sendObject(message);
						} else if ("0".equals(message.getUserStatus())) {
							System.out.println("进入玩家状态等于房主");
							object.getSession().getBasicRemote().sendObject(message);
						}

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
