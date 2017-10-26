package com.els.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 跳转页面Controller
 */
@Controller
@RequestMapping("/skip")
public class SkipController {

	

	// 游戏场景
	@RequestMapping("/index")
	public String toIndex(HttpSession session) {
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
	@RequestMapping("/first")
	public String toAuto() {

		return "first";
	}
}
