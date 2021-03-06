package com.els.socket;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.els.WebSockerServer.PositionMessage;
import com.els.common.SocketUsers;

import net.sf.json.JSONObject;

public class MessageDecoder implements Decoder.Text<SocketMessage> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public SocketMessage decode(String jsonMessage) throws DecodeException {
		// 获取数据
		// TODO Auto-generated method stub
		System.out.println("MessageDecoder == decode" + jsonMessage);
		JSONObject object = JSONObject.fromObject(jsonMessage);
		SocketMessage message = new SocketMessage();

		message.setType(object.getString("type"));
		message.setRoomId(object.getString("roomId"));
		message.setToUserName(object.getString("toUserName"));
		message.setFromUserName(object.getString("fromUserName"));
		message.setMsgStr(object.getString("msgStr"));
		message.setUserStatus(object.getString("userStatus"));
		message.setRoomState(object.getString("roomState"));
		message.setPosition(object.getString("position"));
		message.setHeadimgurl(object.getString("headimgurl"));
		message.setNickName(object.getString("nicakname"));
		message.setCity(object.getString("city"));
		message.setSex(object.getString("sex"));
		message.setProps(object.getString("propsName"));
		message.setUserId(object.getString("userId"));
		message.setIsSelf(object.getString("isSelf"));
		message.setIsSelf(object.getString("getOnclient"));
		message.setOwnerImg(object.getString("ownerImg"));
		message.setImgOne(object.getString("imgOne"));
		message.setImgTwo(object.getString("imgTwo"));
		message.setImgThree(object.getString("imgThree"));
		message.setImgFour(object.getString("imgFour"));
	//	message.setProps(object.getInt("props"));
		//message.setPlayerImgs(object.get("playerImgs"));
		//message.setPlayerImg((List<String>) object.get("readyToDownUp"));
		//游戏中玩家信息
		GameMessage gameMessage = new GameMessage();
		gameMessage.setPlayerId(object.getInt("userId"));
		gameMessage.setCount(object.getInt("count"));
		gameMessage.setFromPlayer(object.getString("fromUserName"));
		gameMessage.setLines(object.getInt("lines"));
		gameMessage.setPlayerImg(object.getString("headimgurl"));
		gameMessage.setPlayerName(object.getString("nicakname"));
		gameMessage.setPropsName(object.getString("propsName"));
		gameMessage.setPropsStatus(object.getInt("propsStatus"));
		gameMessage.setScore(object.getInt("score"));
		gameMessage.setToPlayer(object.getString("toUserName"));
		message.setGameMessage(gameMessage);
		List<GameMessage> listGames = new ArrayList<>();
		listGames.add(gameMessage);
		//用户信息
		SocketUsers socketUser = new SocketUsers();
		socketUser.setCity(object.getString("city"));
		socketUser.setStatus(Integer.parseInt(object.getString("userStatus")));
		socketUser.setUserid(Integer.parseInt(object.getString("userId")));
		socketUser.setUsername(object.getString("nicakname"));
		socketUser.setUsersex(Integer.parseInt(object.getString("sex")));
		socketUser.setUserportrait(object.getString("headimgurl"));
		message.setSocketUser(socketUser);
		//设置图片以及位置
		PositionMessage positionMessage = new PositionMessage();
		positionMessage.setPosition(object.getString("position"));
		positionMessage.setNowImg(object.getString("headimgurl"));
		message.setPositionMessage(positionMessage);
		List<PositionMessage> listImgs = new ArrayList();
		listImgs.add(positionMessage);
		message.setListImgs(listImgs);
		System.out.println("获取到信息:" + message);
		return message;

	}

	@Override
	public boolean willDecode(String jsonMessage) {
		// 接收前端json数据 解析
		try {
			System.out.println("接收前端数据");
			JSONObject.fromObject(jsonMessage);
			return true;
		} catch (Exception e) {
			System.out.println("MessageDecoder == Exception");
			return false;
		}
	}

}
