package com.els.WebSockerServer;

import java.util.HashMap;

import java.util.Map;


public class MessageManger {

	private static Map<String, InterfaceType> messType = new HashMap();

	static {
		messType.put("message", new MessageType());
		messType.put("up", new UpDownType());
		messType.put("down", new DownUpType());
		messType.put("roomStatus", new RoomType());
		messType.put("score", new ScoreType());
		messType.put("props", new PropsType());
		messType.put("usmesage", new UsersMessage());
		messType.put("gameUsmessage", new GamesMessage());
		messType.put("readyToDownUp", new ReadyToDownUp());
		messType.put("changeSeat", new ChangeSeat());
	}

	public static InterfaceType getType(String key) {
		if (messType.containsKey(key)) {
			return messType.get(key);
		}
		return null;
	}
}
