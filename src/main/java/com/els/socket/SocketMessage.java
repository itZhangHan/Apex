package com.els.socket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.els.common.SocketUsers;
/*
 * 数据属性bean
 */
public class SocketMessage implements Serializable{
	
	
	private String type;
	private String roomId;
	private String toUserName;
	private String fromUserName;
	private String msgStr;
	private String userStatus;
	private String roomState;
	private String roomName;
	private String position;
	private String headimgurl;
    private SocketUsers socketUser;
    private List<SocketUsers> listUsers=new ArrayList();
	
	
	public List<SocketUsers> getListUsers() {
		return listUsers;
	}
	public void setListUsers(List<SocketUsers> listUsers) {
		this.listUsers = listUsers;
	}
	
    public void addUser(SocketUsers socketUser){
    	listUsers.add(socketUser);
    }
	public SocketUsers getSocketUser() {
		return socketUser;
	}
	public void setSocketUser(SocketUsers socketUser) {
		this.socketUser = socketUser;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getRoomState() {
		return roomState;
	}
	public void setRoomState(String roomState) {
		this.roomState = roomState;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
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
