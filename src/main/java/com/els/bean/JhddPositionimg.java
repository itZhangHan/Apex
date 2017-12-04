package com.els.bean;

public class JhddPositionimg {
    private Integer positionid;

    private String imgone;

    private String imgtwo;

    private String imgthree;

    private String imgfour;

    private Integer roomid;

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public String getImgone() {
        return imgone;
    }

    public void setImgone(String imgone) {
        this.imgone = imgone == null ? null : imgone.trim();
    }

    public String getImgtwo() {
        return imgtwo;
    }

    public void setImgtwo(String imgtwo) {
        this.imgtwo = imgtwo == null ? null : imgtwo.trim();
    }

    public String getImgthree() {
        return imgthree;
    }

    public void setImgthree(String imgthree) {
        this.imgthree = imgthree == null ? null : imgthree.trim();
    }

    public String getImgfour() {
        return imgfour;
    }

    public void setImgfour(String imgfour) {
        this.imgfour = imgfour == null ? null : imgfour.trim();
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }
}