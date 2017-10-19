package com.els.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.els.common.AuthUtil;

import net.sf.json.JSONObject;

/*
 * 跳转页面Controller
 */
@Controller
@RequestMapping("/skip")
public class SkipController {
	// 创建房间
	@RequestMapping("/first")
	public String toFirst(HttpServletRequest request, HttpServletResponse response, ModelMap map) throws Exception {
		map.put("base", request.getContextPath());
		String code = request.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=" + AuthUtil.APPID + "&secret="
				+ AuthUtil.APPSECRET + "&code=" + code + "&grant_type=authorization_code";
		// 2. 向微信发出请求，带上APPSCECRET和code，获取openid和access_toekn
		JSONObject jsonObject = AuthUtil.doGetJson(url);
		String openid = jsonObject.getString("openid");
		String token = jsonObject.getString("access_token");
		// 4. 获取用户信息
		String infoUrl = "https://api.weixin.qq.com/sns/userinfo?" + "access_token=" + token + "&openid=" + openid
				+ "&lang=zh_CN";
		JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
		System.out.println(userInfo);

		// 1. 使用微信用户信息直接登录，无需注册和绑定
		request.setAttribute("info", userInfo);
		request.getRequestDispatcher("/first.html").forward(request, response);

		// // 2. 将微信与当前的系统账号绑定
		// try {
		// String nickName = getNickName(openid);
		// if (!"".equals(nickName)) {
		// // 已绑定。直接跳转登录成功页面
		// request.setAttribute("nickname", nickName);
		// request.getRequestDispatcher("/index2.jsp").forward(request,
		// response);
		// } else {
		// // 未绑定。 跳转到绑定页面，要求用户输入账户密码
		// // 更新数据库openid
		// request.setAttribute("openid", openid);
		// request.getRequestDispatcher("/login.jsp").forward(request,
		// response);
		// }
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }

		return "first";
	}

	// 游戏场景
	@RequestMapping("/index")
	public String toIndex() {

		return "index";
	}

	// 大厅
	@RequestMapping("/index0")
	public String toIndex0() {

		return "index0";
	}

	// 结束
	@RequestMapping("/over")
	public String toOver() {

		return "over";
	}

	// 授权首页
	@RequestMapping("/auth_first")
	public String toAuto() {

		return "auth_first";
	}
}
