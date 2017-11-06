package com.els.common;

import com.els.bean.JhddUsers;
import net.sf.json.JSONObject;

public class TokenAndUsers {

	private JhddUsers users;

	private String token;

	private String openid;

	private JSONObject jsonObject;

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public JhddUsers getUsers() {
		return users;
	}

	public void setUsers(JhddUsers users) {
		this.users = users;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
