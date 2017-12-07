package com.els.WebSockerServer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import com.els.socket.GameMessage;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class MutualGame implements InterfaceType {

	@Override
	public String onMessage(SocketMessage message) {
		 
		// TODO Auto-generated method stub
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		//获取前端传来的数据
		GameMessage gameMessage = message.getGameMessage();
		//排行榜
		List<Integer> linesSort = new ArrayList<>();
		//玩家一信息
		GameMessage playerInfoOne = new GameMessage();
		//玩家二信息
		GameMessage playerInfoTwo = new GameMessage();
		//玩家三信息
		GameMessage playerInfoThree = new GameMessage();
		//万家四信息
		GameMessage playerInfoFour = new GameMessage();
		//返回集合
		List<GameMessage> gamesInfo = new ArrayList<>();
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					
					//当头像等于第一个头像时候 给玩家一拼接头像 以此类推
					if(gameMessage.getPlayerImg() == message.getImgOne()){
						playerInfoOne.setCount(message.getGameMessage().getCount());
						playerInfoOne.setFromPlayer(message.getGameMessage().getFromPlayer());
						playerInfoOne.setLines(message.getGameMessage().getLines());
						playerInfoOne.setPlayerId(message.getGameMessage().getPlayerId());
						playerInfoOne.setPlayerImg(message.getGameMessage().getPlayerImg());
						playerInfoOne.setPlayerName(message.getGameMessage().getPlayerName());
						playerInfoOne.setPropsName(message.getGameMessage().getPlayerName());
						playerInfoOne.setPropsStatus(message.getGameMessage().getPropsStatus());
						playerInfoOne.setScore(message.getGameMessage().getScore());
						playerInfoOne.setToPlayer(message.getGameMessage().getToPlayer());
					}
					if(gameMessage.getPlayerImg() == message.getImgTwo()){
						playerInfoTwo.setCount(message.getGameMessage().getCount());
						playerInfoTwo.setFromPlayer(message.getGameMessage().getFromPlayer());
						playerInfoTwo.setLines(message.getGameMessage().getLines());
						playerInfoTwo.setPlayerId(message.getGameMessage().getPlayerId());
						playerInfoTwo.setPlayerImg(message.getGameMessage().getPlayerImg());
						playerInfoTwo.setPlayerName(message.getGameMessage().getPlayerName());
						playerInfoTwo.setPropsName(message.getGameMessage().getPlayerName());
						playerInfoTwo.setPropsStatus(message.getGameMessage().getPropsStatus());
						playerInfoTwo.setScore(message.getGameMessage().getScore());
						playerInfoTwo.setToPlayer(message.getGameMessage().getToPlayer());
					}
					if(gameMessage.getPlayerImg() == message.getImgThree()){
						playerInfoThree.setCount(message.getGameMessage().getCount());
						playerInfoThree.setFromPlayer(message.getGameMessage().getFromPlayer());
						playerInfoThree.setLines(message.getGameMessage().getLines());
						playerInfoThree.setPlayerId(message.getGameMessage().getPlayerId());
						playerInfoThree.setPlayerImg(message.getGameMessage().getPlayerImg());
						playerInfoThree.setPlayerName(message.getGameMessage().getPlayerName());
						playerInfoThree.setPropsName(message.getGameMessage().getPlayerName());
						playerInfoThree.setPropsStatus(message.getGameMessage().getPropsStatus());
						playerInfoThree.setScore(message.getGameMessage().getScore());
						playerInfoThree.setToPlayer(message.getGameMessage().getToPlayer());
					}
					if(gameMessage.getPlayerImg() == message.getImgFour()){
						playerInfoFour.setCount(message.getGameMessage().getCount());
						playerInfoFour.setFromPlayer(message.getGameMessage().getFromPlayer());
						playerInfoFour.setLines(message.getGameMessage().getLines());
						playerInfoFour.setPlayerId(message.getGameMessage().getPlayerId());
						playerInfoFour.setPlayerImg(message.getGameMessage().getPlayerImg());
						playerInfoFour.setPlayerName(message.getGameMessage().getPlayerName());
						playerInfoFour.setPropsName(message.getGameMessage().getPlayerName());
						playerInfoFour.setPropsStatus(message.getGameMessage().getPropsStatus());
						playerInfoFour.setScore(message.getGameMessage().getScore());
						playerInfoFour.setToPlayer(message.getGameMessage().getToPlayer());
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			//将各个排行放入集合
			linesSort.add(playerInfoOne.getLines());
			linesSort.add(playerInfoTwo.getLines());
			linesSort.add(playerInfoThree.getLines());
			linesSort.add(playerInfoFour.getLines());
			//调用工具类排行
			Collections.sort(linesSort);
			playerInfoOne.setRunkIng(linesSort.get(0));
			playerInfoTwo.setRunkIng(linesSort.get(1));
			playerInfoThree.setRunkIng(linesSort.get(2));
			playerInfoFour.setRunkIng(linesSort.get(3));
			//将存好的数据放入集合
			gamesInfo.add(playerInfoOne);
			gamesInfo.add(playerInfoTwo);
			gamesInfo.add(playerInfoThree);
			gamesInfo.add(playerInfoFour);
			//赋值给对象
			message.setGameMessages(gamesInfo);
			//设置返回类型
			message.setType("gamesInfo");
			for (WebSocketServer object : arrayset) {
				//分发
				object.getSession().getBasicRemote().sendObject(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
