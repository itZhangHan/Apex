package com.els.WebSockerServer;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

/**
 * 房间状态 0未开始 1：游戏中 2:游戏结束
 * 
 * @author Administrator
 *
 */
public class RoomType implements InterfaceType {

	@Override
	public String onMessage(SocketMessage message) {
		System.out.println("进入分发游戏是否开始消息方法");
		// 如果返回信息包含roomid
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					try {
						System.out.println("sendmessage...roomStatus");
						if ("0".equals(message.getRoomState())) {
							message.setRoomState("1");
							message.setMsgStr("游戏开始了");
							object.getSession().getBasicRemote().sendObject(message);
						}
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
