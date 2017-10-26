package com.els.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.els.bean.JhddUsers;

/*
 * 跳转页面Controller
 */
@Controller
@RequestMapping("/skip")
public class SkipController {


//	// 游戏场景
//	@RequestMapping("/index")
//	public String toIndex(HttpSession session) {
//		return "index"+"?"+getMsg(session);
//
//	}
//
//	// 大厅
//	@RequestMapping("/index0")
//	public String toIndex0(HttpSession session) {
//
//		
//		return "index0"+"?"+getMsg(session);
//
//	}

	// 结束
	@RequestMapping("/over")
	public String toOver(HttpServletRequest request) {

		try {
			return "over"+"?"+ WxCallbackController.getIntance().toFirst(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	
	}

	// 授权首页
	@RequestMapping("/first")
	public String toAuto(HttpServletRequest request) {
		JhddUsers jhddUser=null;
		try {
			return "first"+"?"+ WxCallbackController.getIntance().toFirst(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
