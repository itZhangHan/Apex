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
					String aa = "http://wx.qlogo.cn/mmopen/vi_32/mVtGLzdgB7qeAaBXicXCj9K31mbTibgVicbdkytrSibN5KohzTxvfPBIdiaYU3ByAAS1GEI56kHiaic27eWCgJZpso5ibA/0";
					String bb = "http://wx.qlogo.cn/mmopen/vi_32/mVtGLzdgB7qeAaBXicXCj9K31mbTibgVicbdkytrSibN5KohzTxvfPBIdiaYU3ByAAS1GEI56kHiaic27eWCgJZpso5ibA/0";
					//当头像等于第一个头像时候 给玩家一拼接头像 以此类推
					if(object.getSocketUser().getUserportrait().equals(message.getImgOne())){
						playerInfoOne.setCount(message.getGameMessage().getCount());
						playerInfoOne.setFromPlayer(message.getGameMessage().getFromPlayer());
						playerInfoOne.setLines(message.getGameMessage().getLines());
						playerInfoOne.setPlayerId(object.getSocketUser().getUserid());
						playerInfoOne.setPlayerImg(object.getSocketUser().getUserportrait());
						playerInfoOne.setPlayerName(object.getSocketUser().getUsername());
						playerInfoOne.setPropsName(message.getGameMessage().getPropsName());
						playerInfoOne.setPropsStatus(message.getGameMessage().getPropsStatus());
						playerInfoOne.setScore(message.getGameMessage().getScore());
						playerInfoOne.setToPlayer(message.getGameMessage().getToPlayer());
					}
					if(object.getSocketUser().getUserportrait().equals(message.getImgTwo())){
						playerInfoTwo.setCount(message.getGameMessage().getCount());
						playerInfoTwo.setFromPlayer(message.getGameMessage().getFromPlayer());
						playerInfoTwo.setLines(message.getGameMessage().getLines());
						playerInfoTwo.setPlayerId(object.getSocketUser().getUserid());
						playerInfoTwo.setPlayerImg(object.getSocketUser().getUserportrait());
						playerInfoTwo.setPlayerName(object.getSocketUser().getUsername());
						playerInfoTwo.setPropsName(message.getGameMessage().getPropsName());
						playerInfoTwo.setPropsStatus(message.getGameMessage().getPropsStatus());
						playerInfoTwo.setScore(message.getGameMessage().getScore());
						playerInfoTwo.setToPlayer(message.getGameMessage().getToPlayer());
					}
					if(object.getSocketUser().getUserportrait().equals(message.getImgThree())){
						playerInfoThree.setCount(message.getGameMessage().getCount());
						playerInfoThree.setFromPlayer(message.getGameMessage().getFromPlayer());
						playerInfoThree.setLines(message.getGameMessage().getLines());
						playerInfoThree.setPlayerId(object.getSocketUser().getUserid());
						playerInfoThree.setPlayerImg(object.getSocketUser().getUserportrait());
						playerInfoThree.setPlayerName(object.getSocketUser().getUsername());
						playerInfoThree.setPropsName(message.getGameMessage().getPropsName());
						playerInfoThree.setPropsStatus(message.getGameMessage().getPropsStatus());
						playerInfoThree.setScore(message.getGameMessage().getScore());
						playerInfoThree.setToPlayer(message.getGameMessage().getToPlayer());
					}
					if(object.getSocketUser().getUserportrait().equals(message.getImgFour())){
						playerInfoFour.setCount(message.getGameMessage().getCount());
						playerInfoFour.setFromPlayer(message.getGameMessage().getFromPlayer());
						playerInfoFour.setLines(message.getGameMessage().getLines());
						playerInfoFour.setPlayerId(object.getSocketUser().getUserid());
						playerInfoFour.setPlayerImg(object.getSocketUser().getUserportrait());
						playerInfoFour.setPlayerName(object.getSocketUser().getUsername());
						playerInfoFour.setPropsName(message.getGameMessage().getPropsName());
						playerInfoFour.setPropsStatus(message.getGameMessage().getPropsStatus());
						playerInfoFour.setScore(message.getGameMessage().getScore());
						playerInfoFour.setToPlayer(message.getGameMessage().getToPlayer());
					}
					message.setMsgStr("触发消行方法！！！！！！！！！");
					message.setRoomState("1");
					//message.setType("actionGame");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			//将各个排行放入集合
			if(playerInfoOne.getLines() == null){
				playerInfoOne.setLines(0);
			}
			if(playerInfoTwo.getLines() == null){
				playerInfoTwo.setLines(0);
			}
			if(playerInfoThree.getLines() == null){
				playerInfoThree.setLines(0);
			}
			if(playerInfoFour.getLines() == null){
				playerInfoFour.setLines(0);
			}
			linesSort.add(playerInfoOne.getLines());
			linesSort.add(playerInfoTwo.getLines());
			linesSort.add(playerInfoThree.getLines());
			linesSort.add(playerInfoFour.getLines());
			//调用工具类排行
			Collections.sort(linesSort);
			for (Integer aa : linesSort) {
				System.out.println("排序之后的行数："+aa);
			}
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
