package com.els.bean;

public class JhddUseReords {
    private Integer userecordid;

    private Integer roomid;

    private String userfrom;

    private String userto;

    private String gamepropsname;

    private Byte gamepropstate;

    public Integer getUserecordid() {
        return userecordid;
    }

    public void setUserecordid(Integer userecordid) {
        this.userecordid = userecordid;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getUserfrom() {
        return userfrom;
    }

    public void setUserfrom(String userfrom) {
        this.userfrom = userfrom == null ? null : userfrom.trim();
    }

    public String getUserto() {
        return userto;
    }

    public void setUserto(String userto) {
        this.userto = userto == null ? null : userto.trim();
    }

    public String getGamepropsname() {
        return gamepropsname;
    }

    public void setGamepropsname(String gamepropsname) {
        this.gamepropsname = gamepropsname == null ? null : gamepropsname.trim();
    }

    public Byte getGamepropstate() {
        return gamepropstate;
    }

    public void setGamepropstate(Byte gamepropstate) {
        this.gamepropstate = gamepropstate;
    }
}