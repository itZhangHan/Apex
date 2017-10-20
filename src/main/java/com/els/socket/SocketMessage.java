package com.els.socket;

import java.io.Serializable;
/*
 * 数据属性bean
 */
@SuppressWarnings("serial")
public class SocketMessage implements Serializable{
	
	
	private String type;
	private String roomId;
	private String toUserName;
	private String fromUserName;
	private String msgStr;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
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
	public String getMsgStr() {
		return msgStr;
	}
	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}



}
