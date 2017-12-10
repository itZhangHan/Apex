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
		InputStream in = MutualProps.class.getClassLoader().getResourceAsStream(
                "props/props.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 道具交互接口
		MutualPropsService mutualPropsService = (MutualPropsService) SpringContextUtil.getBean("mutualPropsService");
		// 查询数据库位置信息
		PositionImgService positionImgService = (PositionImgService) SpringContextUtil.getBean("positionImgService");
		// 调用玩家道具详细接口
		GameInfoService gameInfoService = (GameInfoService) SpringContextUtil.getBean("gameInfoService");
		// 房间座位信息
		JhddPositionimg jhddPositionimg = positionImgService.selectByRoomId(Integer.parseInt(message.getRoomId()));
		JhddPropsRecords propsRecords = mutualPropsService.selectPropsRecords(Integer.parseInt(message.getRoomId()));
		propsRecords.setRoomid(Integer.parseInt(message.getRoomId()));
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				//一号玩家的详细信息
				JhddUsers playerOne = gameInfoService.selectByHeadImg(jhddPositionimg.getImgone());
				// 如果是一号玩家
				if (message.getUserId().equals(playerOne.getUserid())) {
					propsRecords.setUserecordid(playerOne.getUserid());
					propsRecords.setUserfrom(playerOne.getUsername());
					propsRecords.setUserto(message.getToUserName());
					Integer propsName =message.getProps();
					//道具名称存入
					MutualProps.getProps(propsRecords, propsName);
				}
				//二号玩家的详细信息
				JhddUsers playerTwo = gameInfoService.selectByHeadImg(jhddPositionimg.getImgtwo());
				if (message.getUserId().equals(playerTwo.getUserid())) {
					propsRecords.setUserecordid(playerTwo.getUserid());
					propsRecords.setUserfrom(playerTwo.getUsername());
					propsRecords.setUserto(message.getToUserName());
					Integer propsName = message.getProps();
					MutualProps.getProps(propsRecords, propsName);
				}
				//仨号玩家的详细信息
				JhddUsers playerThree = gameInfoService.selectByHeadImg(jhddPositionimg.getImgthree());
				if (message.getUserId().equals(playerThree.getUserid())) {
					propsRecords.setUserecordid(playerThree.getUserid());
					propsRecords.setUserfrom(playerThree.getUsername());
					propsRecords.setUserto(message.getToUserName());
					Integer propsName = message.getProps();
					MutualProps.getProps(propsRecords, propsName);
				}
				//四号玩家的详细信息
				JhddUsers playerFour = gameInfoService.selectByHeadImg(jhddPositionimg.getImgfour());
				if (message.getUserId().equals(playerFour.getUserid())) {
					propsRecords.setUserecordid(playerFour.getUserid());
					propsRecords.setUserfrom(playerFour.getUsername());
					propsRecords.setUserto(message.getToUserName());
					Integer propsName = message.getProps();
					MutualProps.getProps(propsRecords, propsName);
				}
			}
		}
		JhddPropsRecords findPropsRecords = mutualPropsService.selectPropsRecords(Integer.parseInt(message.getRoomId()));
		if(findPropsRecords == null){
			
		}
		//插入数据库
		mutualPropsService.updatePropsRecords(propsRecords);
		JhddPropsRecords selectPropsRecords = mutualPropsService.selectPropsRecords(Integer.parseInt(message.getRoomId()));
		for (WebSocketServer object : arrayset) {
			String userfrom = selectPropsRecords.getUserfrom();
			String userto = selectPropsRecords.getUserto();
			String gamepropsname = selectPropsRecords.getGamepropsname();
			message.setMsgStr(userfrom+"对"+userto+"使用了"+gamepropsname+"!");
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

	@Test
	public static void getProps(JhddPropsRecords propsRecords,Integer propsName){
		Properties prop = new Properties();
		InputStream in = MutualProps.class.getClassLoader().getResourceAsStream(
                "props/props.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(4 == propsName){
			propsRecords.setGamepropsname(prop.getProperty("4"));
		}else if(5 == propsName){
			propsRecords.setGamepropsname(prop.getProperty("5"));
		}else if(6 == propsName){
			propsRecords.setGamepropsname(prop.getProperty("6"));
		}else if(7 == propsName){
			propsRecords.setGamepropsname(prop.getProperty("7"));
		}else if(8 == propsName){
			propsRecords.setGamepropsname(prop.getProperty("8"));
		}else if(9 == propsName){
			propsRecords.setGamepropsname(prop.getProperty("9"));
		}else if(10 == propsName){
			propsRecords.setGamepropsname(prop.getProperty("10"));
		}else if(11 == propsName){
			propsRecords.setGamepropsname(prop.getProperty("11"));
		}
		 
	}
//			//4
//			Integer dingshen = Integer.parseInt(prop.getProperty("定身"));
//			//5
//			Integer jiasu = Integer.parseInt(prop.getProperty("加速"));
//			//6
//			Integer jiansu = Integer.parseInt(prop.getProperty("减速"));
//			//7
//			Integer chongsheng = Integer.parseInt(prop.getProperty("重生"));
//			//8
//			Integer fenjie = Integer.parseInt(prop.getProperty("分解"));
//			//9
//			Integer xiaorong = Integer.parseInt(prop.getProperty("消融"));
//			//10
//			Integer bianyi = Integer.parseInt(prop.getProperty("变异"));
//			//11
//			Integer shenggen = Integer.parseInt(prop.getProperty("生根"));
}
