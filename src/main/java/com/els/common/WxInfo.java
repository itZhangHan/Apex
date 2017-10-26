package com.els.common;

import java.io.Serializable;

public class WxInfo implements Serializable{

	private String nickname;
	private Integer sex;
	private String headimgurl;
	private String city;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public WxInfo(String nickname, Integer sex, String headimgurl, String city) {
		super();
		this.nickname = nickname;
		this.sex = sex;
		this.headimgurl = headimgurl;
		this.city = city;
	}
	public WxInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
