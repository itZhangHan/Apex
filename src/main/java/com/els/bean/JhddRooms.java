package com.els.bean;

import java.util.List;

public class JhddRooms {
	private Integer roomid;

	private String roomname;

	private Integer roomstate;

	private JhddUsers users;

	public JhddUsers getUsers() {
		return users;
	}

	public void setUsers(JhddUsers users) {
		this.users = users;
	}

	public Integer getRoomid() {
		return roomid;
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname == null ? null : roomname.trim();
	}

	public Integer getRoomstate() {
		return roomstate;
	}

	public void setRoomstate(Integer roomstate) {
		this.roomstate = roomstate;
	}
}