package com.els.WebSockerServer;

import java.util.concurrent.CopyOnWriteArraySet;

import com.els.bean.JhddPositionimg;
import com.els.common.SpringContextUtil;
import com.els.serviceinterface.PositionImgService;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class DownUpType implements InterfaceType {
	PositionImgService positionImgService = (PositionImgService) SpringContextUtil.getBean("positionImgService");

	@Override
	public synchronized String onMessage(SocketMessage message) {
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		// List<PositionMessage> positionMessage = new
		// ArrayList<PositionMessage>();
		// List<PositionMessage> listImgs = new ArrayList<>();
		// 查询数据库当前属性
		JhddPositionimg positionImg = positionImgService.selectByRoomId(Integer.parseInt(message.getRoomId()));
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					if (object != null) {
						Integer status = object.getSocketUser().getStatus();
						System.out.println("object中的status=" + status);
	
						if (message != null) {
		
							message.setOwnerImg(object.getSocketUser().getUserportrait());
							message.setImgOne(object.getSocketUser().getUserportrait());
							String position = message.getPosition();
							//如果位置二的不等于null 那么就给位置二null
							if(positionImg.getImgtwo() != null && !"".equals(positionImg.getImgtwo())){
								message.setImgTwo(positionImg.getImgtwo());
							}
							if(positionImg.getImgthree() != null && !"".equals(positionImg.getImgthree())){
								message.setImgThree(positionImg.getImgthree());
							}
							if(positionImg.getImgfour() != null && !"".equals(positionImg.getImgfour())){
								message.setImgFour(positionImg.getImgfour());
							}
							if (position == "2" || "2".equals(position)) {
								message.setImgTwo(message.getHeadimgurl());
								if (!"".equals(message.getHeadimgurl()) && message.getHeadimgurl() != null) {
									if (positionImg.getImgthree().equals(message.getHeadimgurl())) {
										// 设置之前存在的图片为空
										positionImg.setImgthree("");
									}
									if (positionImg.getImgfour().equals(message.getHeadimgurl())) {
										// 设置之前存在的图片为空
										positionImg.setImgfour("");
									}
								}
								positionImg.setImgtwo(message.getHeadimgurl());

							}
							if (position == "3" || "3".equals(position)) {
								message.setImgThree(message.getHeadimgurl());
								if (!"".equals(message.getHeadimgurl()) && message.getHeadimgurl() != null) {
									if (positionImg.getImgtwo().equals(message.getHeadimgurl())) {
										// 设置之前存在的图片为空
										positionImg.setImgtwo("");
									}
									if (positionImg.getImgfour().equals(message.getHeadimgurl())) {
										// 设置之前存在的图片为空
										positionImg.setImgfour("");
									}
								}
								positionImg.setImgthree(message.getHeadimgurl());
							}
							if (position == "4" || "4".equals(position)) {
								message.setImgFour(message.getHeadimgurl());
								if (!"".equals(message.getHeadimgurl()) && message.getHeadimgurl() != null) {
									if (positionImg.getImgtwo().equals(message.getHeadimgurl())) {
										// 设置之前存在的图片为空
										positionImg.setImgtwo("");
									}
									if (positionImg.getImgthree().equals(message.getHeadimgurl())) {
										// 设置之前存在的图片为空
										positionImg.setImgthree("");
									}
								}
								positionImg.setImgfour(message.getHeadimgurl());
							}
							System.out.println("数据库中的头像信息为：");
							System.out.println(positionImg.getImgone() + ",头像二：" + positionImg.getImgtwo() + ",头像三："
									+ positionImg.getImgthree() + ",头像四：" + positionImg.getImgfour());
							System.out.println("message中的头像信息为：");
							System.out.println(message.getImgOne() + ",头像二：" + message.getImgTwo() + ",头像三："
									+ message.getImgThree() + ",头像四：" + message.getImgFour());
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
			positionImgService.updateImg(positionImg);
			JhddPositionimg newPositionImg = positionImgService.selectByRoomId(Integer.parseInt(message.getRoomId()));
			message.setImgOne(newPositionImg.getImgone());
			message.setImgTwo(newPositionImg.getImgtwo());
			message.setImgThree(newPositionImg.getImgthree());
			message.setImgFour(newPositionImg.getImgfour());
			/*
			 * listImgs.addAll(positionMessage); System.out.println("在座的人的长度为："
			 * + listImgs.size()); for (PositionMessage positionMessage2 :
			 * listImgs) { System.out.println("集合中的图片：" +
			 * positionMessage2.getNowImg()); }
			 */
		}
		try {
			// if (message != null)
			// 返回当前在线人数
			// message.setListImgs(positionMessage);
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
