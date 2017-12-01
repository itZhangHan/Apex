package com.els.WebSockerServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.common.SocketUsers;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class UsersMessage extends BaseType {

	public String onMessage(SocketMessage message) {
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		List<SocketUsers> list = new ArrayList<SocketUsers>();
	//	List<PositionMessage> positionMessage = new ArrayList<PositionMessage>();
		for (WebSocketServer object : arrayset) {
			try {
				List<PositionMessage> listImgs = new ArrayList<>();
				message.setListImgs(listImgs);
				//positionMessage.add(object.getPositionMessage());
				if (message != null) {
					if (message.getSocketUser() != null) {
						list.add(object.getSocketUser());
					}
					if(object != null){
						if(object.getSocketUser().getStatus() == 0){
							//设置房主图片
							//message.setHeadimgurl(object.getSocketUser().getUserportrait());
							//设置房主姓名
							message.setRoomName(object.getSocketUser().getUsername()+"的房间");
							listImgs.add(object.getPositionMessage());
							message.setListImgs(listImgs);
							System.out.println("创建页面之后listImgs信息为："+listImgs.size());
							for (PositionMessage positionMessage : listImgs) {
								System.out.println("初始化页面中的再坐头像="+positionMessage.getNowImg());
								
							}
						}
						
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			if (message != null)
				// 返回当前在线人数
//				System.out.println("*********");
//				System.out.println("获取到当前的在线人数=" + WebSocketServer.getOnlineCount());
//				System.out.println("*********");
//				int onlint = WebSocketServer.getOnlineCount();
//				message.setSetOnclient(onlint);
				message.setListUsers(list);
				//message.setListImgs(positionMessage);
			for (WebSocketServer object : arrayset) {
				
//				System.out.println(message.getListUsers());
//				List<SocketUsers> lists = message.getListUsers();
//				for (SocketUsers socketUsers : lists) {
//					if(socketUsers.getStatus() != 0){
//						message.setMsgStr("房主已退出");
//						System.out.println("房主已退出！！！！！！！！！！");
//					}else{
//						message.setMsgStr("房主还在");
//					}
//				}
				object.getSession().getBasicRemote().sendObject(message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
