package com.els.WebSockerServer;

import java.util.concurrent.CopyOnWriteArraySet;

import com.els.bean.JhddPositionimg;
import com.els.common.SpringContextUtil;
import com.els.serviceinterface.PositionImgService;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

/**
 * 坐下起立消息闭塞处理
 * 
 * @author Administrator
 *
 */
public class UpDownType extends BaseType {
	PositionImgService positionImgService=(PositionImgService)SpringContextUtil.getBean("positionImgService");
	@Override
	public synchronized String onMessage(SocketMessage message) {
		// TODO Auto-generated method stub
		System.out.println("进入分发起立");
		//Integer userId = Integer.parseInt(message.getUserId());
		//List<PositionMessage> positionMessage = new ArrayList<PositionMessage>();
	//	List<PositionMessage> listImgs = new ArrayList<>();
		JhddPositionimg positionImgs = positionImgService.selectByRoomId(Integer.parseInt(message.getRoomId()));
		// 上座下座
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {

					Integer status = object.getSocketUser().getStatus();
					System.out.println("原有状态：" + status);
				
					message.setUserStatus("2");
					message.setType("up");
			
					if (message != null) {
						if (object.getSocketUser().getStatus() == 0) {
							message.setImgOne(object.getSocketUser().getUserportrait());
							//將值存入数据库
							positionImgs.setImgone(object.getSocketUser().getUserportrait());
						}
						String position = message.getPosition();
						if (position == "2" || "2".equals(position)) {
							message.setImgTwo("");
							positionImgs.setImgtwo("");
						}
						if (position == "3" || "3".equals(position)) {
							message.setImgThree("");
							positionImgs.setImgthree("");
						}
						if (position == "4" || "4".equals(position)) {
							message.setImgFour("");
							positionImgs.setImgfour("");
						}
						System.out.println("数据库中的头像信息为：");
						System.out.println(positionImgs.getImgone() + ",头像二：" + positionImgs.getImgtwo() + ",头像三："
								+ positionImgs.getImgthree() + ",头像四：" + positionImgs.getImgfour());
						System.out.println("message中的头像信息为：");
						System.out.println(message.getImgOne() + ",头像二：" + message.getImgTwo() + ",头像三："
								+ message.getImgThree() + ",头像四：" + message.getImgFour());
						positionImgService.updateImg(positionImgs);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		try {
			if (message != null)
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
