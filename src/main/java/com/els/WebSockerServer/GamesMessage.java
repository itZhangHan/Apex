package com.els.WebSockerServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;

import com.els.socket.GameMessage;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class GamesMessage implements InterfaceType {

	@Override
	public String onMessage(SocketMessage message) {
		System.out.println("进入分发准备玩家信息正式页面");
		List<GameMessage> listGames = new ArrayList<>();

		// 如果返回信息包含roomid
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		
		if (arrayset != null) {
			for (WebSocketServer object : arrayset) {
				try {
					// 如果房间内所有玩家有和座位上玩家1匹配的话。
					String img1 = "http://wx.qlogo.cn/mmhead/Q3auHgzwzM6fGibNYJEUdvIHMibSMAoiaQiag6ZmHIiav2E861F52pQgl4A/0http://wx.qlogo.cn/mmhead/Q3auHgzwzM6fGibNYJEUdvIHMibSMAoiaQiag6ZmHIiav2E861F52pQgl4A/0http://wx.qlogo.cn/mmhead/Q3auHgzwzM6fGibNYJEUdvIHMibSMAoiaQiag6ZmHIiav2E861F52pQgl4A/0http://wx.qlogo.cn/mmhead/Q3auHgzwzM6fGibNYJEUdvIHMibSMAoiaQiag6ZmHIiav2E861F52pQgl4A/0";
					
					if (object.getSocketUser().getUserportrait().equals(message.getImgOne())) {
						GameMessage playerOne = new GameMessage();
						playerOne.setPlayerId(object.getSocketUser().getUserid());
						// 设置道具使用次数
						playerOne.setCount(0);
						playerOne.setFromPlayer(message.getFromUserName());
						// 设置行数
						playerOne.setLines(0);
						playerOne.setPlayerImg(message.getImgOne());
						playerOne.setPlayerName(object.getSocketUser().getUsername());
						// 道具名称
						playerOne.setPropsName(null);
						// 道具状态 0 无状态 1增益道具 2减益道具
						playerOne.setPropsStatus(0);
						playerOne.setScore(0);
						playerOne.setToPlayer(message.getToUserName());
						listGames.add(playerOne);
					}
					if (object.getSocketUser().getUserportrait().equals(message.getImgTwo())) {
						GameMessage playerTwo = new GameMessage();
						playerTwo.setPlayerId(object.getSocketUser().getUserid());
						// 设置道具使用次数
						playerTwo.setCount(message.getGameMessage().getCount());
						playerTwo.setFromPlayer(message.getFromUserName());
						// 设置行数
						playerTwo.setLines(message.getGameMessage().getLines());
						playerTwo.setPlayerImg(message.getImgOne());
						playerTwo.setPlayerName(object.getSocketUser().getUsername());
						// 道具名称
						playerTwo.setPropsName(message.getGameMessage().getPropsName());
						// 道具状态 0 无状态 1增益道具 2减益道具
						playerTwo.setPropsStatus(message.getGameMessage().getPropsStatus());
						playerTwo.setScore(message.getGameMessage().getScore());
						playerTwo.setToPlayer(message.getToUserName());
						listGames.add(playerTwo);

					}
					if (object.getSocketUser().getUserportrait().equals(message.getImgThree())) {
						GameMessage playerThree = new GameMessage();
						playerThree.setPlayerId(object.getSocketUser().getUserid());
						// 设置道具使用次数
						playerThree.setCount(message.getGameMessage().getCount());
						playerThree.setFromPlayer(message.getFromUserName());
						// 设置行数
						playerThree.setLines(message.getGameMessage().getLines());
						playerThree.setPlayerImg(message.getImgOne());
						playerThree.setPlayerName(object.getSocketUser().getUsername());
						// 道具名称
						playerThree.setPropsName(message.getGameMessage().getPropsName());
						// 道具状态 0 无状态 1增益道具 2减益道具
						playerThree.setPropsStatus(message.getGameMessage().getPropsStatus());
						playerThree.setScore(message.getGameMessage().getScore());
						playerThree.setToPlayer(message.getToUserName());
						listGames.add(playerThree);

					}
					if (object.getSocketUser().getUserportrait().equals(message.getImgFour())) {
						GameMessage playerFour = new GameMessage();
						playerFour.setPlayerId(object.getSocketUser().getUserid());
						// 设置道具使用次数
						playerFour.setCount(message.getGameMessage().getCount());
						playerFour.setFromPlayer(message.getFromUserName());
						// 设置行数
						playerFour.setLines(message.getGameMessage().getLines());
						playerFour.setPlayerImg(message.getImgOne());
						playerFour.setPlayerName(object.getSocketUser().getUsername());
						// 道具名称
						playerFour.setPropsName(message.getGameMessage().getPropsName());
						// 道具状态 0 无状态 1增益道具 2减益道具
						playerFour.setPropsStatus(message.getGameMessage().getPropsStatus());
						playerFour.setScore(message.getGameMessage().getScore());
						playerFour.setToPlayer(message.getToUserName());
						listGames.add(playerFour);
					}

					// 获取游戏玩家数据
					// GameMessage gameMessage = message.getGameMessage();
					System.out.println("sendmessage...gamesUsers");
					message.setMsgStr("游戏开始了!!!!!!!!!!!!!!");
					message.setRoomState("1");
					message.setType("actionGame");
					// if(message.getGameMessage() != null){
					// listGames.add(gameMessage);
					// }s
					message.setGameMessages(listGames);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

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
