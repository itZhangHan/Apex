package com.els.bean;

import java.util.List;

public class JhddRooms {
    private Integer roomid;

    private String roomname;

    private Byte roomstate;
    
    private List<JhddUsers> users;
    
    

    public List<JhddUsers> getUsers() {
		return users;
	}

	public void setUsers(List<JhddUsers> users) {
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

    public Byte getRoomstate() {
        return roomstate;
    }

    public void setRoomstate(Byte roomstate) {
        this.roomstate = roomstate;
    }
}