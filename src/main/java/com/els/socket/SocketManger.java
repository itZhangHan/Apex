package com.els.socket;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import com.els.WebSockerServer.WebSocketServer;

public class SocketManger {
	
	

	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;
	
    
	private static HashMap<String,CopyOnWriteArraySet> totalRoomMap=new HashMap();
	
	
	/**
	 * 增加创建房间
	 * @param roomId
	 * @param socketServer
	 */
	public static void addRoom(String roomId,WebSocketServer socketServer){
		CopyOnWriteArraySet arraySet;
		if(!totalRoomMap.containsKey(roomId)){
			 arraySet= new CopyOnWriteArraySet<WebSocketServer>();
			totalRoomMap.put(roomId, arraySet);
			addSocketRoom(arraySet,socketServer);
		}else{
			 arraySet =totalRoomMap.get(roomId);
			 addSocketRoom(arraySet,socketServer);
		}
	}
	
    /**
     * 增加房间的socketServer
     * @param arraySet
     * @param socketServer
     */
	public static void addSocketRoom(CopyOnWriteArraySet arraySet,WebSocketServer socketServer){
		if(arraySet!=null && socketServer!=null ){
			arraySet.add(socketServer);
		}
	}
	
	/**
	 * 删除房间里一个session
	 * @param roomId
	 * @param socketServer
	 */
	public static void delSession(String roomId,WebSocketServer socketServer){
		if(totalRoomMap.containsKey(roomId)){
			delSocketMessage(totalRoomMap.get(roomId),socketServer);
		}
		
	}
	
	public static  void delSocketMessage(CopyOnWriteArraySet copySet,WebSocketServer socketMessage){
		if(copySet!=null){
			if(copySet.contains(socketMessage)){
				copySet.remove(socketMessage);
			}
		}
	}

	
	/***
	 * 获取一个房间里所有的session
	 * @param roomId
	 * @return
	 */
	public static CopyOnWriteArraySet getRoomArray(String roomId){
		if(totalRoomMap.containsKey(roomId)){
			return totalRoomMap.get(roomId);
		}
		return null;
		
	}
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
