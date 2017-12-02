package com.els.WebSockerServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.bean.JhddPositionimg;
import com.els.common.SocketUsers;
import com.els.common.SpringContextUtil;
import com.els.controller.DBController;
import com.els.serviceinterface.PositionImgService;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class UsersMessage extends BaseType {
	// 工具类调用service去操作数据库
	PositionImgService positionImgService = (PositionImgService) SpringContextUtil.getBean("positionImgService");

	public String onMessage(SocketMessage message) {
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		List<SocketUsers> list = new ArrayList<SocketUsers>();
		// 查询数据库中的值
		JhddPositionimg positionImg = positionImgService.selectImg();
		for (WebSocketServer object : arrayset) {
			try {
				// 查询数据库中的值
				if (positionImg != null) {
					if (object != null) {
						if ((object.getSocketUser().getStatus() == 0) == true) {
							// 将用户状态为0的玩家（房主）的头像与赋给数据库中imgOne字段
							positionImg.setImgone(object.getSocketUser().getUserportrait());
							// 将此头像设置给message
							message.setImgOne(object.getSocketUser().getUserportrait());

						}
					}
					// 赋值剩下的字段
					message.setImgTwo(positionImg.getImgtwo());
					message.setImgThree(positionImg.getImgthree());
					message.setImgFour(positionImg.getImgfour());
					// 去更新数据库
					positionImgService.updateImg(positionImg);
				}
				// playerImgs[0] = "img0";
				// playerImgs[1] = "img1";
				// playerImgs[2] = "img2";
				// playerImgs[3] = "img3";
				// message.setPlayerImgs(playerImgs);
				List<PositionMessage> listImgs = new ArrayList<>();
				message.setListImgs(listImgs);
				// positionMessage.add(object.getPositionMessage());

				if (message.getSocketUser() != null) {
					list.add(object.getSocketUser());
				}
				if (object != null) {
					if (object.getSocketUser().getStatus() == 0) {
						// 设置房主图片
						message.setOwnerImg(object.getSocketUser().getUserportrait());
						// 设置房主姓名
						message.setRoomName(object.getSocketUser().getUsername() + "的房间");
					}
				}
				/*
				 * if (message != null) {
				 * 
				 * 
				 * if(object != null){ if(object.getSocketUser().getStatus() ==
				 * 0){ //设置房主图片
				 * message.setOwnerImg(object.getSocketUser().getUserportrait())
				 * ; //设置房主姓名
				 * message.setRoomName(object.getSocketUser().getUsername()+
				 * "的房间"); listImgs.add(object.getPositionMessage());
				 * message.setListImgs(listImgs);
				 * System.out.println("创建页面之后listImgs信息为："+listImgs.size()); for
				 * (PositionMessage positionMessage : listImgs) {
				 * System.out.println("初始化页面中的再坐头像="+positionMessage.getNowImg()
				 * );
				 * 
				 * } }
				 * 
				 * } }
				 */
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			if (message != null)
				// 返回当前在线人数
				// System.out.println("*********");
				// System.out.println("获取到当前的在线人数=" +
				// WebSocketServer.getOnlineCount());
				// System.out.println("*********");
				// int onlint = WebSocketServer.getOnlineCount();
				// message.setSetOnclient(onlint);
				message.setListUsers(list);
			// message.setListImgs(positionMessage);
			for (WebSocketServer object : arrayset) {

				// System.out.println(message.getListUsers());
				// List<SocketUsers> lists = message.getListUsers();
				// for (SocketUsers socketUsers : lists) {
				// if(socketUsers.getStatus() != 0){
				// message.setMsgStr("房主已退出");
				// System.out.println("房主已退出！！！！！！！！！！");
				// }else{
				// message.setMsgStr("房主还在");
				// }
				// }
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
