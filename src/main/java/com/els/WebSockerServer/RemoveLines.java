package com.els.WebSockerServer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import com.els.bean.JhddGameInfo;
import com.els.common.ListSort;
import com.els.common.SpringContextUtil;
import com.els.serviceinterface.GameInfoService;
import com.els.socket.GameMessage;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class RemoveLines implements InterfaceType {
	// 工具类调用service去操作数据库

	@Override
	public synchronized String onMessage(SocketMessage message) {
		GameInfoService gameInfoService = (GameInfoService) SpringContextUtil.getBean("gameInfoService");
		// 根据房间Id查询房间内玩家详细信息
		JhddGameInfo gameInfo = gameInfoService.selectByRoomId(Integer.parseInt(message.getRoomId()));
		// 玩家一信息
		GameMessage playerInfoOne = new GameMessage();
		// 玩家二信息
		GameMessage playerInfoTwo = new GameMessage();
		// 玩家三信息
		GameMessage playerInfoThree = new GameMessage();
		// 万家四信息
		GameMessage playerInfoFour = new GameMessage();
		// 玩家集合
		List<GameMessage> gamesInfo = new ArrayList<>();
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());

		// 玩家1id匹配
		if (Integer.parseInt(message.getUserId()) == gameInfo.getPlayeroneid()) {
			gameInfo.setPlayeronelines(message.getGameMessage().getLines() + "");
			gameInfo.setPlayeronescore(message.getGameMessage().getScore() + "");
		} else if (Integer.parseInt(message.getUserId()) == gameInfo.getPlayertwoid()) {
			gameInfo.setPlayertwolines(message.getGameMessage().getLines() + "");
			gameInfo.setPlayertwoscore(message.getGameMessage().getScore() + "");
		} else if (Integer.parseInt(message.getUserId()) == gameInfo.getPlayerthreeid()) {
			gameInfo.setPlayerthreelines(message.getGameMessage().getLines() + "");
			gameInfo.setPlayerthreescore(message.getGameMessage().getScore() + "");
		} else if (Integer.parseInt(message.getUserId()) == gameInfo.getPlayerfourid()) {
			gameInfo.setPlayerfourlines(message.getGameMessage().getLines() + "");
			gameInfo.setPlayerfourscore(message.getGameMessage().getScore() + "");
		}

		gameInfoService.updataByGamesInfo(gameInfo);
		JhddGameInfo findGameInfo = gameInfoService.selectByRoomId(Integer.parseInt(message.getRoomId()));

		if (message.getUserId().equals(findGameInfo.getPlayeroneid())) {
			playerInfoOne.setLines(Integer.parseInt(findGameInfo.getPlayeronelines()));
			playerInfoOne.setScore(Integer.parseInt(findGameInfo.getPlayeronescore()));
			playerInfoOne.setPlayerId(findGameInfo.getPlayeroneid());
			playerInfoOne.setPlayerImg(findGameInfo.getPlayeroneimg());
			playerInfoOne.setPlayerName(findGameInfo.getPlayeronename());

			gamesInfo.add(playerInfoOne);
		} else if (message.getUserId().equals(findGameInfo.getPlayertwoid())) {
			playerInfoTwo.setLines(Integer.parseInt(findGameInfo.getPlayertwolines()));
			playerInfoTwo.setScore(Integer.parseInt(findGameInfo.getPlayertwoscore()));
			playerInfoTwo.setPlayerId(findGameInfo.getPlayertwoid());
			playerInfoTwo.setPlayerImg(findGameInfo.getPlayertwoimg());
			playerInfoTwo.setPlayerName(findGameInfo.getPlayertwoname());
			gamesInfo.add(playerInfoTwo);
		} else if (message.getUserId().equals(findGameInfo.getPlayerthreeid())) {
			playerInfoThree.setLines(Integer.parseInt(findGameInfo.getPlayerthreelines()));
			playerInfoThree.setScore(Integer.parseInt(findGameInfo.getPlayerthreescore()));
			playerInfoThree.setPlayerId(findGameInfo.getPlayerthreeid());
			playerInfoThree.setPlayerImg(findGameInfo.getPlayerthreeimg());
			playerInfoThree.setPlayerName(findGameInfo.getPlayerthreename());
			gamesInfo.add(playerInfoThree);
		} else if (message.getUserId().equals(findGameInfo.getPlayerfourid())) {

			playerInfoFour.setLines(Integer.parseInt(findGameInfo.getPlayerfourlines()));
			playerInfoFour.setScore(Integer.parseInt(findGameInfo.getPlayerfourscore()));
			playerInfoFour.setPlayerId(findGameInfo.getPlayerfourid());
			playerInfoFour.setPlayerImg(findGameInfo.getPlayerfourimg());
			playerInfoFour.setPlayerName(findGameInfo.getPlayerfourname());
			gamesInfo.add(playerInfoFour);
		}

		// 集合排序 降序
		ListSort<GameMessage> listSort = new ListSort<GameMessage>();
		listSort.Sort(gamesInfo, "getLines", "desc");
		// 设置消行返回集合
		message.setGameMessages(gamesInfo);
		message.setType("removeLines");
		for (WebSocketServer object : arrayset) {
			// 分发
			try {
				object.getSession().getBasicRemote().sendObject(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
