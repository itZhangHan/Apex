package com.els.WebSockerServer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import com.els.bean.JhddGameInfo;
import com.els.bean.JhddPositionimg;
import com.els.bean.JhddUsers;
import com.els.common.SpringContextUtil;
import com.els.serviceinterface.GameInfoService;
import com.els.serviceinterface.PositionImgService;
import com.els.socket.GameMessage;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class MutualGame implements InterfaceType {
	@Override
	public String onMessage(SocketMessage message) {
		// 查询数据库位置信息接口
		PositionImgService positionImgService = (PositionImgService) SpringContextUtil.getBean("positionImgService");
		// 调用玩家道具详细接口
		GameInfoService gameInfoService = (GameInfoService) SpringContextUtil.getBean("gameInfoService");
		// 房间座位信息
		JhddPositionimg jhddPositionimg = positionImgService.selectByRoomId(Integer.parseInt(message.getRoomId()));

		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		// 获取前端传来的数据
		List<GameMessage> gameMessages = message.getGameMessages();
		// 设置初始数据，插入数据库
		JhddGameInfo gameInfo = new JhddGameInfo();
		Date createTime = new Date();
		// 创建时间
		gameInfo.setCreatetime(createTime);
		// 房间id
		gameInfo.setRoomid(Integer.parseInt(message.getRoomId()));
		// 玩家一信息
		GameMessage playerInfoOne = new GameMessage();
		// 玩家二信息
		GameMessage playerInfoTwo = new GameMessage();
		// 玩家三信息
		GameMessage playerInfoThree = new GameMessage();
		// 万家四信息
		GameMessage playerInfoFour = new GameMessage();
		// 玩家集合
		// 返回集合
		List<GameMessage> gamesInfo = new ArrayList<>();
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					if (jhddPositionimg.getImgone().equals(object.getSocketUser().getUserportrait())) {
						JhddUsers playerOne = gameInfoService.selectByHeadImg(jhddPositionimg.getImgone());
						gameInfo.setPlayeroneid(playerOne.getUserid());
						gameInfo.setPlayeronename(playerOne.getUsername());
						gameInfo.setPlayeroneimg(playerOne.getUserportrait());
						gameInfo.setPlayeronelines(message.getGameMessage().getLines() + "");
						gameInfo.setPlayeronescore(message.getGameMessage().getScore() + "");

					}
					if (jhddPositionimg.getImgtwo().equals(object.getSocketUser().getUserportrait())) {
						JhddUsers playerTwo = gameInfoService.selectByHeadImg(jhddPositionimg.getImgtwo());
						if(playerTwo != null){
							gameInfo.setPlayertwoid(playerTwo.getUserid());
							gameInfo.setPlayertwoimg(playerTwo.getUserportrait());
							gameInfo.setPlayertwoname(playerTwo.getUsername());
							gameInfo.setPlayertwolines(message.getGameMessage().getLines() + "");
							gameInfo.setPlayertwoscore(message.getGameMessage().getScore() + "");
						}
						
					}
					if (jhddPositionimg.getImgthree().equals(object.getSocketUser().getUserportrait())) {
						JhddUsers playerThree = gameInfoService.selectByHeadImg(jhddPositionimg.getImgthree());
						if(playerThree != null){
							gameInfo.setPlayerthreeid(playerThree.getUserid());
							gameInfo.setPlayerthreeimg(playerThree.getUserportrait());
							gameInfo.setPlayerthreename(playerThree.getUsername());
							gameInfo.setPlayerthreelines(message.getGameMessage().getLines() + "");
							gameInfo.setPlayerthreescore(message.getGameMessage().getScore() + "");
						}
						
					}
					if (jhddPositionimg.getImgfour().equals(object.getSocketUser().getUserportrait())) {
						JhddUsers playerFour = gameInfoService.selectByHeadImg(jhddPositionimg.getImgfour());
						if(playerFour != null){
							gameInfo.setPlayerfourid(playerFour.getUserid());
							gameInfo.setPlayerfourimg(playerFour.getUserportrait());
							gameInfo.setPlayerfourname(playerFour.getUsername());
							gameInfo.setPlayerfourlines(message.getGameMessage().getLines() + "");
							gameInfo.setPlayerfourscore(message.getGameMessage().getScore() + "");
						}
					}
					message.setRoomState("1");
					// message.setType("actionGame");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//删除之前存在的数据
			gameInfoService.deleteByRoomId(message.getRoomId());
			// 插入数据库
			gameInfoService.addGamesInfo(gameInfo);
		}
		try {
			JhddGameInfo findGameInfo = gameInfoService.selectByRoomId(Integer.parseInt(message.getRoomId()));
			if (findGameInfo.getPlayeroneid() != null) {
				playerInfoOne.setLines(Integer.parseInt(findGameInfo.getPlayeronelines()));
				playerInfoOne.setScore(Integer.parseInt(findGameInfo.getPlayeronescore()));
				playerInfoOne.setPlayerId(findGameInfo.getPlayeroneid());
				playerInfoOne.setPlayerImg(findGameInfo.getPlayeroneimg());
				playerInfoOne.setPlayerName(findGameInfo.getPlayeronename());
				gamesInfo.add(playerInfoOne);
			}
			if (findGameInfo.getPlayertwoid() != null) {
				playerInfoTwo.setLines(Integer.parseInt(findGameInfo.getPlayertwolines()));
				playerInfoTwo.setScore(Integer.parseInt(findGameInfo.getPlayertwoscore()));
				playerInfoTwo.setPlayerId(findGameInfo.getPlayertwoid());
				playerInfoTwo.setPlayerImg(findGameInfo.getPlayertwoimg());
				playerInfoTwo.setPlayerName(findGameInfo.getPlayertwoname());
				gamesInfo.add(playerInfoTwo);
			}
			if (findGameInfo.getPlayerthreeid() != null) {
				playerInfoThree.setLines(Integer.parseInt(findGameInfo.getPlayerthreelines()));
				playerInfoThree.setScore(Integer.parseInt(findGameInfo.getPlayerthreescore()));
				playerInfoThree.setPlayerId(findGameInfo.getPlayerthreeid());
				playerInfoThree.setPlayerImg(findGameInfo.getPlayerthreeimg());
				playerInfoThree.setPlayerName(findGameInfo.getPlayerthreename());
				gamesInfo.add(playerInfoThree);
			}
			if (findGameInfo.getPlayerfourid() != null) {
				playerInfoFour.setLines(Integer.parseInt(findGameInfo.getPlayerfourlines()));
				playerInfoFour.setScore(Integer.parseInt(findGameInfo.getPlayerfourscore()));
				playerInfoFour.setPlayerId(findGameInfo.getPlayerfourid());
				playerInfoFour.setPlayerImg(findGameInfo.getPlayerfourimg());
				playerInfoFour.setPlayerName(findGameInfo.getPlayerfourname());
				gamesInfo.add(playerInfoFour);
			}

			for (GameMessage gameMessage : gamesInfo) {
				System.out.println(gameMessage.getLines().toString());
			}
			
			// 赋值给集合
			message.setGameMessages(gamesInfo);
			// 设置返回类型
			message.setType("gamesInfo");
			for (WebSocketServer object : arrayset) {
				// 分发
				object.getSession().getBasicRemote().sendObject(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
