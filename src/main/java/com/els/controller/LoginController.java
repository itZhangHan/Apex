package com.els.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.els.common.AuthUtil;
/*
 * 授权登录
 */
@Controller
@RequestMapping("/WxAuth")
public class LoginController {

	@RequestMapping("/wxLogin")
	public void wxAuthorze(HttpServletResponse resp) throws IOException{
		System.out.printf("进入登录方法");

		// String backUrl = "http://atwjsw.s1.natapp.cc/WxAuth/callBack";
		String backUrl = "http://192.168.1.16:8080/tetris/skip/first";

		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" + "appid=" + AuthUtil.APPID
				+ "&redirect_uri=" + URLEncoder.encode(backUrl) + "&response_type=code" + "&scope=snsapi_userinfo"
				+ "&state=STATE" + "#wechat_redirect";
		// 重定向用户请求到微信授权URL
		resp.sendRedirect(url);
		// super.doGet(req, resp);
	}
}
