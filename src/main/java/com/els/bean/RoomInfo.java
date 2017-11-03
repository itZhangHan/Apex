package com.els.bean;

import java.util.List;

public class RoomInfo {

	private Integer roomid;
	// 0未开始 1：游戏中 2:游戏结束
	private Integer roomStatus;
	// 0房主 1：玩家 2:旁观者
	private Integer userStatus;
	private List<JhddUsers> userList;

	public Integer getRoomid() {
		return roomid;
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}

	public Integer getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(Integer roomstate) {
		this.roomStatus = roomstate;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public List<JhddUsers> getUserList() {
		return userList;
	}

	public void setUserList(List<JhddUsers> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "RoomInfo [roomid=" + roomid + ", roomStatus=" + roomStatus + ", userStatus=" + userStatus
				+ ", userList=" + userList + "]";
	}

}
