package com.els.WebSockerServer;

import java.util.HashMap;

import java.util.Map;
/*
 * 进入页面根据type跳转响应页面。
 */

public class MessageManger {

	private static Map<String, InterfaceType> messType = new HashMap();

	static {
		//聊天模块
		messType.put("message", new MessageType());
		//起立模块
		messType.put("up", new UpDownType());
		//坐下模块
		messType.put("down", new DownUpType());
		//修改房间状态
		messType.put("roomStatus", new RoomType());
		//第一次进入页面获取数据
		messType.put("usmesage", new UsersMessage());
		//开始游戏返回数据
		messType.put("gameUsmessage", new GamesMessage());
		//获取在线人数
		messType.put("getOnclient", new GetOnclient());
		//游戏中数据交互模块
		messType.put("mutualGame", new MutualGame());
		//messType.put("updateImg", new UpdateImg());
	}

	public static InterfaceType getType(String key) {
		if (messType.containsKey(key)) {
			return messType.get(key);
		}
		return null;
	}
}
