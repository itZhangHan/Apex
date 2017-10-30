package com.els.WebSockerServer;

import java.util.HashMap;
import java.util.Map;

public class MessageManger {

	private static Map<String, InterfaceType> messType = new HashMap();

	static {
		System.out.println("aaa");
		messType.put("message", new MessageType());
		messType.put("upDown", new UpDownType());
		messType.put("roomStatus", new RoomType());
	}

	public static InterfaceType getType(String key) {
		if (messType.containsKey(key)) {
			return messType.get(key);
		}
		return null;
	}
}
