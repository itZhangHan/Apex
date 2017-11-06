package com.els.common;

import com.els.bean.JhddUsers;

public class UsersAndUrlPath {

	private JhddUsers users;

	private String urlPath;

	public JhddUsers getUsers() {
		return users;
	}

	public void setUsers(JhddUsers users) {
		this.users = users;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	@Override
	public String toString() {
		return "UsersAndUrlPath [users=" + users + ", urlPath=" + urlPath + "]";
	}

}
