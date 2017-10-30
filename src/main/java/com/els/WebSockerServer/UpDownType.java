package com.els.WebSockerServer;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

/**
 * 坐下起立消息闭塞处理
 * 
 * @author Administrator
 *
 */
public class UpDownType extends BaseType {

	@Override
	public String onMessage(SocketMessage message) {
		// TODO Auto-generated method stub
		// 上座下座
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					try {
						// 0:房主，1:玩家,2:旁观者
						if (message.getUserStatus().equals("2")) {
							System.out.println("进入玩家状态等于2");
							message.setUserStatus("1");
							object.getSession().getBasicRemote().sendObject(message);
						} else if (message.getUserStatus().equals("2")) {
							System.out.println("进入玩家状态等于1");
							message.setUserStatus("2");
							object.getSession().getBasicRemote().sendObject(message);
						} else if (message.getUserStatus().equals("0")) {
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
