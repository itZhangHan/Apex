package com.els.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.els.bean.JhddUsers;
import com.els.bean.RoomInfo;
import com.els.common.AuthUtil;
import com.els.mapper.JhddUsersMapper;
import com.els.serviceinterface.UserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/callback")
public class WxCallbackFirst {

	@Autowired
	private JhddUsersMapper userMapper;

	@Autowired
	private UserService userService;

	// 查询用户信息返回参数
	@RequestMapping("/first")
	public String toFirst(HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("进入callback页面");
		String code = request.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=" + AuthUtil.APPID + "&secret="
				+ AuthUtil.APPSECRET + "&code=" + code + "&grant_type=authorization_code";
		// 2. 向微信发出请求，带上APPSCECRET和code，获取openid和access_toekn
		System.out.println("进入工具类方法");
		JSONObject jsonObject = AuthUtil.doGetJson(url);
		String openid = jsonObject.getString("openid");
		if ("".equals(openid) && openid == null) {
			return "first";
		}
		System.out.println("openid获取成功" + openid);
		String token = jsonObject.getString("access_token");
		// 通过openid查询是否存在信息
		JhddUsers users = userMapper.selectByOpenid(openid);
		RoomInfo roomInfo = new RoomInfo();
		// 获取请求路径
		String urlName = request.getSession().getAttribute("urlName").toString();
		if (users == null) {
			// 1. 使用微信用户信息直接登录，无需注册和绑定
			// 4. 获取用户信息
			String infoUrl = "https://api.weixin.qq.com/sns/userinfo?" + "access_token=" + token + "&openid=" + openid
					+ "&lang=zh_CN";
			JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
			System.out.println("5");
			request.setAttribute("userInfo", userInfo);
			// 当access_token过时时进行刷新
			System.out.println("进入刷新呢token方法");
			// 获取token
			String refresh_token = jsonObject.getString("refresh_token");

			// 刷新token
			String refresh_url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" + AuthUtil.APPID
					+ "&grant_type=refresh_token" + "&refresh_token=" + refresh_token;
			AuthUtil.doGetJson(refresh_url);
			System.out.println("刷新成功......");

			String nickname = (String) userInfo.get("nickname");
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
			return AuthUtil.getMsg(insertUsers, urlName, roomInfo,null);
		}

		return AuthUtil.getMsg(users, urlName, roomInfo,null);
	}
}
