package com.els.common;

public class SocketUsers {
	private Integer userid;

	private String username;

	private String userportrait;

	private Integer usersex;

	private String city;

	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(Object object) {
		this.username = object == null ? null : ((String) object).trim();
	}

	public String getUserportrait() {
		return userportrait;
	}

	public void setUserportrait(String userportrait) {
		this.userportrait = userportrait == null ? null : userportrait.trim();
	}

	public Integer getUsersex() {
		return usersex;
	}

	public void setUsersex(Integer object) {
		this.usersex = (Integer) object;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}
}
