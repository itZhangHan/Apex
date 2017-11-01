package com.els.controller;

import javax.servlet.http.HttpServletRequest;
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
		// return "index"+"?"+getMsg(session);
		return "index";
	}

	// 大厅
	@RequestMapping("/index0")
	public String toIndex0(HttpSession session) {

		// return "index0"+"?"+getMsg(session);
		return "index0";
	}

	// 结束
	@RequestMapping("/over")
	public String toOver(HttpServletRequest request) {

		return "over";

	}
	
	@RequestMapping("/joinsend")
	public String joinsend(HttpServletRequest request) {

		return "redirect:/room/joinRoom";

	}
	// 创建页面
	@RequestMapping("/firstsend")
	public String toFirst() {

		return "first";

	}

	// 结束页面
	@RequestMapping("/oversend")
	public String toOver() {

		return "over";

	}

	// 大厅页面
	@RequestMapping("/index0send")
	public String toIndex0() {

		return "index0";

	}

	// 聊天页面
	@RequestMapping("/indexsend")
	public String toIndex() {

		return "index";

	}

	// 授权首页
	@RequestMapping(value = "/first")
	public void toAuto(HttpServletRequest request, HttpSession httpSession) {

	}

}
