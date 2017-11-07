package com.els.socket;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import com.els.WebSockerServer.WebSocketServer;
@SuppressWarnings("all")
public class SocketManger {

	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;
	//根据房间id存取session
	private static HashMap<String, CopyOnWriteArraySet> totalRoomMap = new HashMap();

	/****
	 * 增加创建房间
	 * 
	 * @param roomId
	 * @param socketServer
	 */
	public static void addRoom(String roomId, WebSocketServer socketServer) {
		System.out.println("进入addRoom方法");
		CopyOnWriteArraySet arraySet;
		if (!totalRoomMap.containsKey(roomId)) {
			arraySet = new CopyOnWriteArraySet<WebSocketServer>();
			totalRoomMap.put(roomId, arraySet);
			addSocketRoom(arraySet, socketServer);
		} else {
			arraySet = totalRoomMap.get(roomId);
			addSocketRoom(arraySet, socketServer);
		}
	}

	/**
	 * 增加房间的socketServer
	 * 
	 * @param arraySet
	 * @param socketServer
	 */
	public static void addSocketRoom(CopyOnWriteArraySet arraySet, WebSocketServer socketServer) {
		System.out.println("进入addSocketRoom方法");
		if (arraySet != null && socketServer != null) {
			if (!arraySet.contains(socketServer)) {
				arraySet.add(socketServer);
				System.out.println(arraySet);
			}
		}
	}

	/**
	 * 删除房间里一个session
	 * 
	 * @param roomId
	 * @param socketServer
	 */
	public static void delSession(String roomId, WebSocketServer socketServer) {
		System.out.println("进入删除session方法");
		if (totalRoomMap.containsKey(roomId)) {
			delSocketMessage(totalRoomMap.get(roomId), socketServer);
		}
	}
	//当session结束后删除此session
	public static void delSocketMessage(CopyOnWriteArraySet copySet, WebSocketServer socketMessage) {
		if (copySet != null) {
			if (copySet.contains(socketMessage)) {
				copySet.remove(socketMessage);
			}
		}
	}

	/***
	 * 
	 * 获取一个房间里所有的session
	 * 
	 * @param roomId
	 * @return
	 */
	
	public static CopyOnWriteArraySet getRoomArray(String roomId) {
		System.out.println("进入获取房间session方法");
		//如果集合中有次rooid包含的session则返回
		if (totalRoomMap.containsKey(roomId)) {
			return totalRoomMap.get(roomId);
		}
		return null;
	}
	
//	public static CopyOnWriteArraySet getUserStatus(String userStatus) {
//		System.out.println("进入获取房间session方法22222");
//		//如果集合中有次rooid包含的session则返回
//		if (totalRoomMap.containsKey(userStatus)) {
//			System.out.println("获取到用户状态:"+userStatus);
//			return totalRoomMap.get(userStatus);
//		}
//		return null;
//	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		onlineCount--;
	}
 
 

}
