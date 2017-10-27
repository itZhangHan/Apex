package com.els.common;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 判断用户是否授权登录拦截器
 */
@SuppressWarnings("all")
public class WxInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		// request.getSession().removeAttribute("openid");
		System.out.println("进入拦截");
		String requestURI = request.getRequestURI();
		request.getSession().setAttribute("urlName", requestURI);
		this.wxAuthorze(response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	public void wxAuthorze(HttpServletResponse resp) throws IOException {
		System.out.printf("进入认证方法");
		String backUrl = "http://thdd.apexgame.cn/tetris/callback/first";
		System.out.println("1");
		// 回调微信接口
		String authURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtil.APPID
				+ "&redirect_uri=" + URLEncoder.encode(backUrl) + "&response_type=code" + "&scope=snsapi_base"
				+ "&state=STATE#wechat_redirect";
		// 重定向用户请求到微信授权URL
		resp.sendRedirect(authURL);

	}

}
