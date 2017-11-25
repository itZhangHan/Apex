package com.els.WebSockerServer;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

/**
 * 聊天信息处理
 * 
 * @author Administrator
 *
 */
public class MessageType extends BaseType {

	@Override
	public String onMessage(SocketMessage message) {
		System.out.println("进入分发消息方法");
		// 如果返回信息包含roomid
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					try {
						System.out.println("sendmessage...");
						if(object.getSocketUser().getUserid()==Integer.parseInt(message.getUserId())){
							message.setIsSelf("1");//1是本人 b.isSelf == 1
							object.getSession().getBasicRemote().sendObject(message);
						}else{
							message.setIsSelf("2");//2为其他人
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

		// TODO Auto-generated method stub
		return null;
	}

}
