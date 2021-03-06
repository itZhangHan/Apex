package com.els.WebSockerServer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import org.junit.Test;

import com.els.bean.JhddPositionimg;
import com.els.bean.JhddPropsRecords;
import com.els.bean.JhddUsers;
import com.els.common.SpringContextUtil;
import com.els.serviceinterface.GameInfoService;
import com.els.serviceinterface.MutualPropsService;
import com.els.serviceinterface.PositionImgService;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class MutualProps implements InterfaceType {

	@Override
	public String onMessage(SocketMessage message) {
		Properties prop = new Properties();
		InputStream in = MutualProps.class.getClassLoader().getResourceAsStream("props/props.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String toUserName = message.getToUserName();
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		// 道具交互接口
		MutualPropsService mutualPropsService = (MutualPropsService) SpringContextUtil.getBean("mutualPropsService");

		// 查询数据库位置信息
		PositionImgService positionImgService = (PositionImgService) SpringContextUtil.getBean("positionImgService");

		// 调用玩家道具详细接口
		GameInfoService gameInfoService = (GameInfoService) SpringContextUtil.getBean("gameInfoService");

		// 房间座位信息
		JhddPositionimg jhddPositionimg = positionImgService.selectByRoomId(Integer.parseInt(message.getRoomId()));
		JhddPropsRecords propsRecords = mutualPropsService.selectPropsRecords(Integer.parseInt(message.getRoomId()));
		if (propsRecords == null) {
			MutualProps.newPropsRecords(message, arrayset, gameInfoService, jhddPositionimg, mutualPropsService,
					toUserName);
		} else {
			propsRecords.setRoomid(Integer.parseInt(message.getRoomId()));
			if (arrayset != null) {
				for (WebSocketServer object : arrayset) {
					// 一号玩家的详细信息
					JhddUsers playerOne = gameInfoService.selectByHeadImg(jhddPositionimg.getImgone());

					// 如果是一号玩家
					if (message.getUserId().equals(playerOne.getUserid() + "")) {
						propsRecords.setUserfrom(playerOne.getUsername());
						if (playerOne.getUserid() == Integer.parseInt(toUserName)) {
							String toWho = playerOne.getUsername();
							propsRecords.setUserto(toWho);
						}
						String propsName = message.getProps();
						// 道具名称存入
						MutualProps.getProps(propsRecords, propsName);
					}
					// 二号玩家的详细信息
					JhddUsers playerTwo = gameInfoService.selectByHeadImg(jhddPositionimg.getImgtwo());
					if (playerTwo != null) {
						if (message.getUserId().equals(playerTwo.getUserid() + "")) {
							propsRecords.setUserfrom(playerTwo.getUsername());
							if (playerTwo.getUserid() == Integer.parseInt(toUserName)) {
								String toWho = playerTwo.getUsername();
								propsRecords.setUserto(toWho);
							}
							propsRecords.setUserto(message.getToUserName());
							String propsName = message.getProps();
							MutualProps.getProps(propsRecords, propsName);
						}
					}

					// 仨号玩家的详细信息
					JhddUsers playerThree = gameInfoService.selectByHeadImg(jhddPositionimg.getImgthree());
					if (playerThree != null) {
						if (message.getUserId().equals(playerThree.getUserid() + "")) {
							propsRecords.setUserfrom(playerThree.getUsername());
							if (playerThree.getUserid() == Integer.parseInt(toUserName)) {
								String toWho = playerThree.getUsername();
								propsRecords.setUserto(toWho);
							}
							String propsName = message.getProps();
							MutualProps.getProps(propsRecords, propsName);
						}
					}

					// 四号玩家的详细信息
					JhddUsers playerFour = gameInfoService.selectByHeadImg(jhddPositionimg.getImgfour());
					if (playerFour != null) {
						if (message.getUserId().equals(playerFour.getUserid() + "")) {
							propsRecords.setUserfrom(playerFour.getUsername());
							if (playerFour.getUserid() == Integer.parseInt(toUserName)) {
								String toWho = playerFour.getUsername();
								propsRecords.setUserto(toWho);
							}
							String propsName = message.getProps();
							MutualProps.getProps(propsRecords, propsName);
						}
					}

				}
			}

			// 插入数据库
			propsRecords.setGamepropstate((byte) 1);
			mutualPropsService.addPropsRecords(propsRecords);
			JhddPropsRecords selectPropsRecords = mutualPropsService
					.selectPropsRecords(Integer.parseInt(message.getRoomId()));
			for (WebSocketServer object : arrayset) {
				String userfrom = selectPropsRecords.getUserfrom();
				String userto = selectPropsRecords.getUserto();
				String gamepropsname = selectPropsRecords.getGamepropsname();
				message.setMsgStr(userfrom + "对" + userto + "使用了" + gamepropsname + "!");
				// 攻击人
				message.setToUserName(message.getToUserName());
				// 道具名称
				message.setProps(message.getProps());
				// 本人
				message.setFromUserName(message.getUserId());
				message.setType("MutualProps");
				// 分发
				try {
					object.getSession().getBasicRemote().sendObject(message);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}
		return null;
	}

	private static void newPropsRecords(SocketMessage message, CopyOnWriteArraySet<WebSocketServer> arrayset,
			GameInfoService gameInfoService, JhddPositionimg jhddPositionimg, MutualPropsService mutualPropsService,
			String toUserName) {
		// TODO Auto-generated method stub
		JhddPropsRecords newPropsRecords = new JhddPropsRecords();
		newPropsRecords.setRoomid(Integer.parseInt(message.getRoomId()));
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				// 一号玩家的详细信息
				JhddUsers playerOne = gameInfoService.selectByHeadImg(jhddPositionimg.getImgone());
				JhddUsers playerTwo = gameInfoService.selectByHeadImg(jhddPositionimg.getImgtwo());
				JhddUsers playerThree = gameInfoService.selectByHeadImg(jhddPositionimg.getImgthree());
				JhddUsers playerFour = gameInfoService.selectByHeadImg(jhddPositionimg.getImgfour());
				// 如果是一号玩家
				if (message.getUserId().equals(playerOne.getUserid() + "")) {
					//来自玩家
					newPropsRecords.setUserfrom(playerOne.getUsername());
					if (playerOne.getUserid() == Integer.parseInt(toUserName)) {
						String toWho = playerOne.getUsername();
						newPropsRecords.setUserto(toWho);
					}else if(playerTwo.getUserid() == Integer.parseInt(toUserName)){
						String toWho = playerOne.getUsername();
						newPropsRecords.setUserto(toWho);
					}else if(playerThree.getUserid() == Integer.parseInt(toUserName)){
						String toWho = playerOne.getUsername();
						newPropsRecords.setUserto(toWho);
					}else if(playerFour.getUserid() == Integer.parseInt(toUserName)){
						String toWho = playerOne.getUsername();
						newPropsRecords.setUserto(toWho);
					}
					String propsName = message.getProps();
					// 道具名称存入
					MutualProps.getProps(newPropsRecords, propsName);
				}
				// 二号玩家的详细信息
				if (playerTwo != null) {
					if (message.getUserId().equals(playerTwo.getUserid() + "")) {
						newPropsRecords.setUserfrom(playerTwo.getUsername());
						if (playerOne.getUserid() == Integer.parseInt(toUserName)) {
							String toWho = playerOne.getUsername();
							newPropsRecords.setUserto(toWho);
						}else if(playerTwo.getUserid() == Integer.parseInt(toUserName)){
							String toWho = playerOne.getUsername();
							newPropsRecords.setUserto(toWho);
						}else if(playerThree.getUserid() == Integer.parseInt(toUserName)){
							String toWho = playerOne.getUsername();
							newPropsRecords.setUserto(toWho);
						}else if(playerFour.getUserid() == Integer.parseInt(toUserName)){
							String toWho = playerOne.getUsername();
							newPropsRecords.setUserto(toWho);
						}
						String propsName = message.getProps();
						MutualProps.getProps(newPropsRecords, propsName);
					}
				}

				// 仨号玩家的详细信息
				if (playerThree != null) {
					if (message.getUserId().equals(playerThree.getUserid() + "")) {
						newPropsRecords.setUserfrom(playerThree.getUsername());
						if (playerOne.getUserid() == Integer.parseInt(toUserName)) {
							String toWho = playerOne.getUsername();
							newPropsRecords.setUserto(toWho);
						}else if(playerTwo.getUserid() == Integer.parseInt(toUserName)){
							String toWho = playerOne.getUsername();
							newPropsRecords.setUserto(toWho);
						}else if(playerThree.getUserid() == Integer.parseInt(toUserName)){
							String toWho = playerOne.getUsername();
							newPropsRecords.setUserto(toWho);
						}else if(playerFour.getUserid() == Integer.parseInt(toUserName)){
							String toWho = playerOne.getUsername();
							newPropsRecords.setUserto(toWho);
						}
						String propsName = message.getProps();
						MutualProps.getProps(newPropsRecords, propsName);
					}
				}

				// 四号玩家的详细信息
				if (playerFour != null) {
					if (message.getUserId().equals(playerFour.getUserid() + "")) {
						newPropsRecords.setUserfrom(playerFour.getUsername());
						if (playerOne.getUserid() == Integer.parseInt(toUserName)) {
							String toWho = playerOne.getUsername();
							newPropsRecords.setUserto(toWho);
						}else if(playerTwo.getUserid() == Integer.parseInt(toUserName)){
							String toWho = playerTwo.getUsername();
							newPropsRecords.setUserto(toWho);
						}else if(playerThree.getUserid() == Integer.parseInt(toUserName)){
							String toWho = playerThree.getUsername();
							newPropsRecords.setUserto(toWho);
						}else if(playerFour.getUserid() == Integer.parseInt(toUserName)){
							String toWho = playerFour.getUsername();
							newPropsRecords.setUserto(toWho);
						}
						String propsName = message.getProps();
						MutualProps.getProps(newPropsRecords, propsName);
					}
				}

			}
			newPropsRecords.setGamepropstate((byte) 1);
			mutualPropsService.addPropsRecords(newPropsRecords);
			// mutualPropsService.updatePropsRecords(newPropsRecords);
		}
		// 插入数据库
		// mutualPropsService.updatePropsRecords(newPropsRecords);
		JhddPropsRecords selectPropsRecords = mutualPropsService
				.selectPropsRecords(Integer.parseInt(message.getRoomId()));
		for (WebSocketServer object : arrayset) {
			String userfrom = selectPropsRecords.getUserfrom();
			String userto = selectPropsRecords.getUserto();
			String gamepropsname = selectPropsRecords.getGamepropsname();
			message.setMsgStr(userfrom + "对" + userto + "使用了" + gamepropsname + "!");
			// 道具名称
			// 攻击人
			message.setToUserName(message.getToUserName());
			// 道具名称
			message.setProps(message.getProps());
			// 本人
			message.setFromUserName(message.getUserId());
			message.setType("MutualProps");
			// 分发
			try {
				object.getSession().getBasicRemote().sendObject(message);
			} catch (IOException | EncodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public static void getProps(JhddPropsRecords propsRecords, String propsName) {
		Properties prop = new Properties();
		InputStream in = MutualProps.class.getClassLoader().getResourceAsStream("props/props.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ("4".equals(propsName)) {
			propsRecords.setGamepropsname("定身");
		} else if ("5".equals(propsName)) {
			propsRecords.setGamepropsname("加速");
		} else if ("6".equals(propsName)) {
			propsRecords.setGamepropsname("减速");
		} else if ("7".equals(propsName)) {
			propsRecords.setGamepropsname("重生");
		} else if ("8".equals(propsName)) {
			propsRecords.setGamepropsname("分解");
		} else if ("9".equals(propsName)) {
			propsRecords.setGamepropsname("消融");
		} else if ("10".equals(propsName)) {
			propsRecords.setGamepropsname("变异");
		} else if ("11".equals(propsName)) {
			propsRecords.setGamepropsname("生根");
		}

	}
	// //4
	// Integer dingshen = Integer.parseInt(prop.getProperty("定身"));
	// //5
	// Integer jiasu = Integer.parseInt(prop.getProperty("加速"));
	// //6
	// Integer jiansu = Integer.parseInt(prop.getProperty("减速"));
	// //7
	// Integer chongsheng = Integer.parseInt(prop.getProperty("重生"));
	// //8
	// Integer fenjie = Integer.parseInt(prop.getProperty("分解"));
	// //9
	// Integer xiaorong = Integer.parseInt(prop.getProperty("消融"));
	// //10
	// Integer bianyi = Integer.parseInt(prop.getProperty("变异"));
	// //11
	// Integer shenggen = Integer.parseInt(prop.getProperty("生根"));
}
