package com.els.bean;

import java.util.List;

public class JhddSidelines {
	private Integer sidelinesid;

	private Integer roomid;

	private Integer userid;

	private Byte sidelinestate;

	private JhddRooms rooms;
	
	private List<JhddUsers> users;
	
	private JhddUsers jhdduser;

	public JhddRooms getRooms() {
		return rooms;
	}

	public void setRooms(JhddRooms rooms) {
		this.rooms = rooms;
	}

	public JhddUsers getJhdduser() {
		return jhdduser;
	}

	public void setJhdduser(JhddUsers jhdduser) {
		this.jhdduser = jhdduser;
	}

	public List<JhddUsers> getUsers() {
		return users;
	}

	public void setUsers(List<JhddUsers> users) {
		this.users = users;
	}

	public Integer getSidelinesid() {
		return sidelinesid;
	}

	public void setSidelinesid(Integer sidelinesid) {
		this.sidelinesid = sidelinesid;
	}

	public Integer getRoomid() {
		return roomid;
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Byte getSidelinestate() {
		return sidelinestate;
	}

	public void setSidelinestate(Byte sidelinestate) {
		this.sidelinestate = sidelinestate;
	}
}