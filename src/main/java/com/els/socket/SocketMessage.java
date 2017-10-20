package com.els.socket;

import java.io.Serializable;

import javax.websocket.Session;

public class SocketMessage implements Serializable{
	
	
	private String type;
	private int roomId;
	private String toUserName;
	private String fromUserName;
	private String msgStr;

	public int getRoomId() { 
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getMsgStr() {
		return msgStr;
	}
	
	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

}
