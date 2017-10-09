package com.els.bean;

import java.io.Serializable;

public class User implements Serializable{
    private Integer uid;

    private String uname;

    private Integer homeId;

    private Integer homeowner;

    private Integer status;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Integer getHomeId() {
		return homeId;
	}

	public void setHomeId(Integer homeId) {
		this.homeId = homeId;
	}

	public Integer getHomeowner() {
		return homeowner;
	}

	public void setHomeowner(Integer homeowner) {
		this.homeowner = homeowner;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer uid, String uname, Integer homeId, Integer homeowner, Integer status) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.homeId = homeId;
		this.homeowner = homeowner;
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", homeId=" + homeId + ", homeowner=" + homeowner + ", status="
				+ status + "]";
	}

  
}