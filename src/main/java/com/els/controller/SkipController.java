package com.els.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 跳转页面Controller
 */
@Controller
@RequestMapping("/skip")
public class SkipController {
	//创建房间
	@RequestMapping("/first")
	public String toFirst(HttpServletRequest request,ModelMap map) {
		map.put("base", request.getContextPath());
		return "first";
	}
	//游戏场景
	@RequestMapping("/index")
	public String toIndex() {

		return "index";
	}
	//大厅
	@RequestMapping("/index0")
	public String toIndex0() {

		return "index0";
	}
	//结束
	@RequestMapping("/over")
	public String toOver() {

		return "over";
	}
}
