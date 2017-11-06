package com.els.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.els.bean.JhddUsers;
import com.els.mapper.JhddUsersMapper;

import net.sf.json.JSONObject;

@Controller
public class GetUserInfo {

	@Autowired
	private JhddUsersMapper userMapper;

	public TokenAndUsers getUsersInfo(HttpServletRequest request, HttpSession session) throws IOException {
		String code = request.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=" + AuthUtil.APPID + "&secret="
				+ AuthUtil.APPSECRET + "&code=" + code + "&grant_type=authorization_code";
		// 2. 向微信发出请求，带上APPSCECRET和code，获取openid和access_toekn
		System.out.println("进入工具类方法");
		JSONObject jsonObject = AuthUtil.doGetJson(url);
		String openid = jsonObject.getString("openid");
		String token = jsonObject.getString("access_token");
		// 通过openid查询是否存在信息
		JhddUsers users = userMapper.selectByOpenid(openid);
		TokenAndUsers tokenAndUsers = new TokenAndUsers();
		tokenAndUsers.setToken(token);
		tokenAndUsers.setUsers(users);
		tokenAndUsers.setOpenid(openid);
		tokenAndUsers.setJsonObject(jsonObject);
		return tokenAndUsers;
	}
}
