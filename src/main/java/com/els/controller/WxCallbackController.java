package com.els.controller;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.els.bean.JhddUsers;
import com.els.common.AuthUtil;
import com.els.mapper.JhddUsersMapper;
import com.els.serviceinterface.UserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/callback")
public class WxCallbackController {

	@Autowired
	private JhddUsersMapper userMapper;

	@Autowired
	private UserService userService;

	// 创建房间
	@RequestMapping("/first")
	public String toFirst(RedirectAttributes attr, HttpServletRequest request, HttpServletResponse response,
			ModelMap map, Model model, HttpSession session) throws Exception {
		System.out.println("进入callback页面");
		String code = request.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=" + AuthUtil.APPID + "&secret="
				+ AuthUtil.APPSECRET + "&code=" + code + "&grant_type=authorization_code";
		// 2. 向微信发出请求，带上APPSCECRET和code，获取openid和access_toekn
		System.out.println("进入工具类方法");
		JSONObject jsonObject = AuthUtil.doGetJson(url);
		// request.setAttribute("jsonObject", jsonObject);
		String openid = jsonObject.getString("openid");
		String token = jsonObject.getString("access_token");
		session.setAttribute("token", token);
		session.setAttribute("openid", openid);
		// 1. 使用微信用户信息直接登录，无需注册和绑定
		// 4. 获取用户信息
		String infoUrl = "https://api.weixin.qq.com/sns/userinfo?" + "access_token=" + token + "&openid=" + openid
				+ "&lang=zh_CN";
		JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
		request.setAttribute("userInfo", userInfo);
		// 当access_token过时时进行刷新
		System.out.println("进入刷新呢token方法");
		// 获取token
		String refresh_token = jsonObject.getString("refresh_token");

		// 刷新token
		String refresh_url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" + AuthUtil.APPID
				+ "&grant_type=refresh_token" + "&refresh_token=" + refresh_token;
		// response.sendRedirect(refresh_url);
		AuthUtil.doGetJson(refresh_url);
		System.out.println("刷新成功:" + refresh_url);

		String nickname = (String) userInfo.get("nickname");
		Integer sex = (Integer) userInfo.get("sex");
		String headimgurl = userInfo.getString("headimgurl");
		String city = userInfo.getString("city");
		// 将授权用户信息加入数据库
		JhddUsers users = userMapper.selectByOpenid(openid);

		if (users == null) {
			JhddUsers user = new JhddUsers();
			user.setOpenid(openid);
			user.setUsername(nickname);
			user.setCity(city);
			user.setUserportrait(headimgurl);
			user.setUsersex(sex);
			userService.addUser(user);
			// userMapper.updateByPrimaryKeySelective(user);
		}

		// 将数据存入session 前端获取
		session.setAttribute("openid", openid);
		session.setAttribute("nickname", nickname);
		session.setAttribute("city", city);
		session.setAttribute("headimgurl", headimgurl);
		session.setAttribute("sex", sex);
		System.out.println("callback方法走完...");
		String urlName = request.getSession().getAttribute("urlName").toString();
		String[] split = urlName.split("/");
		return split[split.length - 1];
	}
}
