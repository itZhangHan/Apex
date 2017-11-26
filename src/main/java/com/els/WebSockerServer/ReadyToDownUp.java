package com.els.WebSockerServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class ReadyToDownUp implements InterfaceType {

	@Override
	public String onMessage(SocketMessage message) {
		// TODO Auto-generated method stub
		System.out.println("进入分发起立");
		List<String> playerImg = new ArrayList<>();
		playerImg.add(0, "");
		playerImg.add(1, "");
		playerImg.add(2, "");
		playerImg.add(3, "");
		Integer userId = Integer.parseInt(message.getUserId());
		// 上座下座
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					try {
						System.out.println(message.getHeadimgurl()+"头像传输");
						System.out.println(message.getPosition()+"位置传输");
						// 座位头像
						for(int i = 0 ; i < playerImg.size() ; i++) {
							  
						}
						String string = playerImg.get(0);
						System.out.println(string+"====aaaaaaaaaaaaaaaaaaa");
						if(playerImg.get(0) == null && "".equals(playerImg.get(0))){
							//如果房主位置为空的情况下让位置二的人头像成为房主
							playerImg.set(0, playerImg.get(1));
							message.setType("down");
							message.setPlayerImg(playerImg);
						}
						if (playerImg.get(1) == null) {
							playerImg.set(1, message.getHeadimgurl());
							message.setType("down");
							message.setPlayerImg(playerImg);
						} else if (playerImg.get(2) == null) {
							playerImg.set(2, message.getHeadimgurl());
							message.setType("down");
							message.setPlayerImg(playerImg);
						} else if (playerImg.get(3) == null) {
							playerImg.set(3, message.getHeadimgurl());
							message.setType("down");
							message.setPlayerImg(playerImg);
						} else {
							//如果当前用户等于当前用户
							if (object.getSocketUser().getUserid() == userId) {
								//如果当前位置是几
								if(Integer.parseInt(message.getPosition())==0){
									playerImg.set(0,String.valueOf(message.getHeadimgurl()));
									message.setType("up");
									message.setPlayerImg(playerImg);
								}
								if(Integer.parseInt(message.getPosition())==1){
									playerImg.set(1,String.valueOf(message.getHeadimgurl()));
									message.setType("up");
									message.setPlayerImg(playerImg);
								}
								if(Integer.parseInt(message.getPosition())==2){
									playerImg.set(2,String.valueOf(message.getHeadimgurl()));
									message.setType("up");
									message.setPlayerImg(playerImg);
								}
								if(Integer.parseInt(message.getPosition())==3){
									playerImg.set(3,String.valueOf(message.getHeadimgurl()));
									message.setType("up");
									message.setPlayerImg(playerImg);
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
