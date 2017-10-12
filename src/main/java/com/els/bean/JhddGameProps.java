package com.els.bean;

public class JhddGameProps {
    private Integer gamepropsid;

    private String gamepropsname;

    private Integer userid;

    private Integer roomid;

    private Byte gamepropstate;

    public Integer getGamepropsid() {
        return gamepropsid;
    }

    public void setGamepropsid(Integer gamepropsid) {
        this.gamepropsid = gamepropsid;
    }

    public String getGamepropsname() {
        return gamepropsname;
    }

    public void setGamepropsname(String gamepropsname) {
        this.gamepropsname = gamepropsname == null ? null : gamepropsname.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Byte getGamepropstate() {
        return gamepropstate;
    }

    public void setGamepropstate(Byte gamepropstate) {
        this.gamepropstate = gamepropstate;
    }
}