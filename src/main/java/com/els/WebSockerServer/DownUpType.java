package com.els.WebSockerServer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;

import com.els.bean.JhddPositionimg;
import com.els.common.SpringContextUtil;
import com.els.controller.DBController;
import com.els.serviceinterface.PositionImgService;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class DownUpType implements InterfaceType {
	PositionImgService positionImgService = (PositionImgService) SpringContextUtil.getBean("positionImgService");

	@Override
	public synchronized String onMessage(SocketMessage message) {
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		List<PositionMessage> positionMessage = new ArrayList<PositionMessage>();
		List<PositionMessage> listImgs = new ArrayList<>();
		// 查询数据库当前属性
		JhddPositionimg positionImg = positionImgService.selectImg();
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					if (object != null) {
						Integer status = object.getSocketUser().getStatus();
						System.out.println("object中的status=" + status);
						/*
						 * if (object.getSocketUser().getStatus() == 0) { //
						 * 设置房主图片 message.setOwnerImg(object.getSocketUser().
						 * getUserportrait());
						 * positionMessage.add(object.getPositionMessage());
						 * System.out.println("第一次＋图片为0的图片 "); }
						 * 
						 * if (object.getSocketUser().getStatus() == 1) {
						 * positionMessage.add(object.getPositionMessage());
						 * System.out.println("第一次＋图片为1的图片 ");
						 * 
						 * }
						 */
						if (message != null) {
							if (object.getSocketUser().getStatus() == 0) {
								message.setImgOne(object.getSocketUser().getUserportrait());
								// 將值存入数据库
								positionImg.setImgone(object.getSocketUser().getUserportrait());
							}
							String position = message.getPosition();
							if (position == "2" || "2".equals(position)) {
								message.setImgTwo(message.getHeadimgurl());
								positionImg.setImgtwo(message.getHeadimgurl());
							}
							if (position == "3" || "3".equals(position)) {
								message.setImgThree(message.getHeadimgurl());
								positionImg.setImgthree(message.getHeadimgurl());
							}
							if (position == "4" || "4".equals(position)) {
								message.setImgFour(message.getHeadimgurl());
								positionImg.setImgfour(message.getHeadimgurl());
							}
							System.out.println("数据库中的头像信息为：");
							System.out.println(positionImg.getImgone() + ",头像二：" + positionImg.getImgtwo() + ",头像三："
									+ positionImg.getImgthree() + ",头像四：" + positionImg.getImgfour());
							System.out.println("message中的头像信息为：");
							System.out.println(message.getImgOne() + ",头像二：" + message.getImgTwo() + ",头像三："
									+ message.getImgThree() + ",头像四：" + message.getImgFour());
							positionImgService.updateImg(positionImg);
						}

						/*
						 * if (object.getSocketUser().getStatus() == 1) {
						 * positionMessage.add(object.getPositionMessage()); }
						 */
					}

					/*
					 * if (message != null) { if
					 * (!positionMessage.contains(message.getPositionMessage()))
					 * { positionMessage.add(message.getPositionMessage());
					 * 
					 * 
					 * System.out.println("第2次＋图片"); } }
					 */
					message.setUserStatus("1");
					message.setType("down");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*
			 * listImgs.addAll(positionMessage); System.out.println("在座的人的长度为："
			 * + listImgs.size()); for (PositionMessage positionMessage2 :
			 * listImgs) { System.out.println("集合中的图片：" +
			 * positionMessage2.getNowImg()); }
			 */
		}
		try {
			//if (message != null)
				// 返回当前在线人数
				//message.setListImgs(positionMessage);
			for (WebSocketServer object : arrayset) {
				object.getSession().getBasicRemote().sendObject(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
