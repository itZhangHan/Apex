package com.els.socket;

import javax.websocket.Session;

public class SocketMessage {
	
	private int roomId;
	private int userId;
	private String msgStr;

	public int getRoomId() { 
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMsgStr() {
		return msgStr;
	}
	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

}
