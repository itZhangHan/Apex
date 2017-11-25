package com.els.WebSockerServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.socket.ReadUsersInfo;
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
		System.out.println("进入分发起立");
		Integer userId = Integer.parseInt(message.getUserId());
		// 上座下座
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					try {
						/*List<String> positions = new ArrayList<>();
						positions.add("1");
						positions.add("2");
						positions.add("3");
						positions.add("4");
						ReadUsersInfo readers = message.getReaders();
						readers.setPositions(positions);
						readers.getIsReady();*/
						if (object.getSocketUser().getUserid() == userId) {
							System.out.println("ID相同");
							object.getSocketUser().setHeadPostion(Integer.parseInt(message.getPosition()));
						}
						message.setUserStatus("2");
						message.setType("up");
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
