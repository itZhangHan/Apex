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
@SuppressWarnings("all")
@Controller
@RequestMapping("/WxAuth")
public class LoginController {

	@RequestMapping("/wxLogin")
	public void wxAuthorze(HttpServletResponse resp) throws IOException {
		System.out.printf("进入登录方法");

		// String backUrl = "http://atwjsw.s1.natapp.cc/WxAuth/callBack";
		String backUrl = "http://thdd.apexgame.cn/tetris/callback/first";
		System.out.println("1");
//		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" + "appid=" + AuthUtil.APPID
//				+ "&redirect_uri=" + URLEncoder.encode(backUrl) + "&response_type=code" + "&scope=snsapi_userinfo"
//				+ "&state=STATE" + "#wechat_redirect";
		String url1 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AuthUtil.APPID
				+ "&redirect_uri="+URLEncoder.encode(backUrl)
				+ "&response_type=code"
				+ "&scope=snsapi_userinfo"
				+ "&state=STATE#wechat_redirect";
		// 重定向用户请求到微信授权URL
		resp.sendRedirect(url1);
		// super.doGet(req, resp);
	}
}
