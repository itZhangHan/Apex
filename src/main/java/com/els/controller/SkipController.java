package com.els.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
