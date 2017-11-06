package com.els.bean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JhddUsers {
	private Integer userid;

	private String username;

	private String userportrait;

	private Integer usersex;

	private String openid;

	private String city;

	private Set<JhddSidelines> jhddIsdelines = new HashSet();

	public Set<JhddSidelines> getJhddIsdelines() {
		return jhddIsdelines;
	}

	public void setJhddIsdelines(Set<JhddSidelines> jhddIsdelines) {
		this.jhddIsdelines = jhddIsdelines;
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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid == null ? null : openid.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}
}