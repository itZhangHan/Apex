package com.els.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.els.common.AuthUtil;

import net.sf.json.JSONObject;
@RequestMapping("/callback")
public class WxCallbackController {
	// 创建房间
		@RequestMapping("/first")
		public String toFirst(HttpServletRequest request, HttpServletResponse response, ModelMap map,Model model) throws Exception {
			System.out.println("进入callback页面");
			map.put("base", request.getContextPath());
			String code = request.getParameter("code");
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=" + AuthUtil.APPID + "&secret="
					+ AuthUtil.APPSECRET + "&code=" + code + "&grant_type=authorization_code";
			// 2. 向微信发出请求，带上APPSCECRET和code，获取openid和access_toekn
			System.out.println("进入工具类方法");
			JSONObject jsonObject = AuthUtil.doGetJson(url);
			String openid = jsonObject.getString("openid");
			String token = jsonObject.getString("access_token");
			// 4. 获取用户信息
			String infoUrl = "https://api.weixin.qq.com/sns/userinfo?" + "access_token=" + token + "&openid=" + openid
					+ "&lang=zh_CN";
			JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
			System.out.println("用户名："+userInfo.get("nickname"));
			System.out.println("性别："+userInfo.get("sex"));
			System.out.println("头像："+userInfo.getString("headimgurl"));
			System.out.println("privilege："+userInfo.get("privilege"));
			System.out.println("地址："+userInfo.getString("country")+userInfo.get("province")+userInfo.getString("city"));
			System.out.println("openid："+userInfo.get("openid"));
			System.out.println("access_token："+userInfo.get("access_token"));
			System.out.println("refresh_token："+userInfo.get("refresh_token"));
			//当access_token过时时进行刷新
			String rf_token = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+AuthUtil.APPID
					+ "&grant_type=refresh_token"
					+ "&refresh_token=REFRESH_TOKEN";
			System.out.println(rf_token);
			
			// 1. 使用微信用户信息直接登录，无需注册和绑定
			model.addAttribute("userInfo", userInfo);
			
		//	request.setAttribute("info", userInfo);
			//request.getRequestDispatcher("/index0.html").forward(request, response);

			return "first";
		}
}
