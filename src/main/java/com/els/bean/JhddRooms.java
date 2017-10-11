package com.els.bean;

public class JhddRooms {
    private Integer roomid;

    private String roomname;

    private Byte roomstate;

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