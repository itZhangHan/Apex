package com.els.WebSockerServer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.socket.ReadUsersInfo;
import com.els.socket.Readers;
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
						// 座位头像
						List<String> playerImg = message.getPlayerImg();
						if(playerImg.get(0) == null){
							//如果房主位置为空的情况下让位置二的人头像成为房主
							playerImg.set(0, playerImg.get(1));
							message.setType("down");
						}
						if (playerImg.get(1) == null) {
							playerImg.set(1, message.getHeadimgurl());
							message.setType("down");
						} else if (playerImg.get(2) == null) {
							playerImg.set(2, message.getHeadimgurl());
							message.setType("down");
						} else if (playerImg.get(3) == null) {
							playerImg.set(3, message.getHeadimgurl());
							message.setType("down");
						} else {
							//如果当前用户等于当前用户
							if (object.getSocketUser().getUserid() == userId) {
								//如果当前位置是几
								if(Integer.parseInt(message.getPosition())==0){
									playerImg.set(0, message.getHeadimgurl());
									message.setType("up");
								}
								if(Integer.parseInt(message.getPosition())==1){
									playerImg.set(1, "");
									message.setType("up");
								}
								if(Integer.parseInt(message.getPosition())==2){
									playerImg.set(2, "");
									message.setType("up");
								}
								if(Integer.parseInt(message.getPosition())==3){
									playerImg.set(3, "");
									message.setType("up");
								}
							}
						}
						// 设置当前传入的头像值为一号位置
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
