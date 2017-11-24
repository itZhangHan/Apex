package com.els.WebSockerServer;

public class PositionMessage {
	//位置
	private Integer position;
	//用户状态
	private Integer peopleStatus;
	//是否允许坐下
	private Integer upDown;

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getPeopleStatus() {
		return peopleStatus;
	}

	public void setPeopleStatus(Integer peopleStatus) {
		this.peopleStatus = peopleStatus;
	}

	public Integer getUpDown() {
		return upDown;
	}

	public void setUpDown(Integer upDown) {
		this.upDown = upDown;
	}
	
	
}
