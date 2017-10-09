package com.els.bean;

import java.io.Serializable;
import java.util.Date;

public class Gamehome implements Serializable{
    private Integer hid;

    private String hname;

    private Integer personNum;

    private Integer homeStatus;

    @Override
	public String toString() {
		return "Gamehome [hid=" + hid + ", hname=" + hname + ", personNum=" + personNum + ", homeStatus=" + homeStatus
				+ ", createDate=" + createDate + "]";
	}

	private Date createDate;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname == null ? null : hname.trim();
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public Integer getHomeStatus() {
        return homeStatus;
    }

    public void setHomeStatus(Integer homeStatus) {
        this.homeStatus = homeStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}