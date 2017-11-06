package com.els.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.els.bean.JhddUsers;
import com.els.mapper.JhddUsersMapper;
import com.els.serviceinterface.UserService;

import net.sf.json.JSONObject;

@Controller
public class GetUsersAndURLPath {

	@Autowired
	private static JhddUsersMapper userMapper;
	@Autowired
	private static UserService userService;

	public UsersAndUrlPath getUsersAndUrlPath(HttpServletRequest request, HttpSession session) throws Exception {
		GetUserInfo getUserInfo = new GetUserInfo();
		getUserInfo.getUsersInfo(request, session);
		TokenAndUsers tokenAndUsers = new TokenAndUsers();
		String openid = tokenAndUsers.getOpenid();
		String token = tokenAndUsers.getToken();
		JSONObject jsonObject = tokenAndUsers.getJsonObject();

		// 获取请求路径
		String urlName = request.getSession().getAttribute("urlName").toString();
		UsersAndUrlPath usersAndUrlPath = new UsersAndUrlPath();
		// 1. 使用微信用户信息直接登录，无需注册和绑定
		// 4. 获取用户信息
		String infoUrl = "https://api.weixin.qq.com/sns/userinfo?" + "access_token=" + token + "&openid=" + openid
				+ "&lang=zh_CN";
		JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
		System.out.println("5");
		request.setAttribute("userInfo", userInfo);
		// 当access_token过时时进行刷新
		System.out.println("进入刷新token方法");
		System.out.println(userInfo);
		System.out.println(userInfo.toString());

		// 获取token
		String refresh_token = jsonObject.getString("refresh_token");

		// 刷新token
		String refresh_url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" + AuthUtil.APPID
				+ "&grant_type=refresh_token" + "&refresh_token=" + refresh_token;
		AuthUtil.doGetJson(refresh_url);
		System.out.println("刷新成功......");

		String nickname = (String) userInfo.get("nickname");
		System.out.println(nickname);
		Integer sex = (Integer) userInfo.get("sex");
		String headimgurl = userInfo.getString("headimgurl");
		String city = userInfo.getString("city");
		// 将授权用户信息加入数据库

		JhddUsers user = new JhddUsers();
		user.setOpenid(openid);
		user.setUsername(nickname);
		user.setCity(city);
		user.setUserportrait(headimgurl);
		user.setUsersex(sex);

		// 插入用户成功返回userID
		userService.addUser(user);
		int userid = userMapper.selectLastInsertUserId();
		JhddUsers insertUsers = userMapper.selectByPrimaryKey(userid);
		usersAndUrlPath.setUrlPath(urlName);
		usersAndUrlPath.setUsers(insertUsers);
		return usersAndUrlPath;
	}
}
