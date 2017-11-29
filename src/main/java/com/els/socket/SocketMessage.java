package com.els.socket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.els.common.SocketUsers;

/*
 * 数据属性bean
 */
public class SocketMessage implements Serializable {

	private String type;
	private String userId;
	private String nickName;
	private String city;
	private String sex;
	private String roomId;
	private String toUserName;
	private String fromUserName;
	private String msgStr;
	private String userStatus;
	private String roomState;
	private String roomName;
	private String position;
	private String headimgurl;
	private String props;
	private String isSelf;//
	private String getOnclient;
	private SocketUsers socketUser;
	private List<String> playerImg;
	private List<SocketUsers> listUsers = new ArrayList();

	
	
	public String getGetOnclient() {
		return getOnclient;
	}

	public void setGetOnclient(String getOnclient) {
		this.getOnclient = getOnclient;
	}

	public List<String> getPlayerImg() {
		return playerImg;
	}

	public void setPlayerImg(List<String> playerImg) {
		this.playerImg = playerImg;
	}

	public String getIsSelf() {
		return isSelf;
	}

	public void setIsSelf(String isSelf) {
		this.isSelf = isSelf;
	}

	public String getProps() {
		return props;
	}

	public void setProps(String props) {
		this.props = props;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<SocketUsers> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<SocketUsers> listUsers) {
		this.listUsers = listUsers;
	}

	public void addUser(SocketUsers socketUser) {
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

	public void setGetOnclient(int onlineCount) {
		// TODO Auto-generated method stub
		
	}

}
