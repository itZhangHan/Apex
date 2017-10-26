package com.els.controller;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
			System.out.println("toOvertoOvertoOver");
			return "first";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	
	}
	
	
	
	
	// 创建页面
	@RequestMapping(value = "/firstsend")
	public String toFirst(){
		
		return "first";
		
		
	}
     
	// 授权首页
	@RequestMapping(value = "/first")
	public void toAuto(HttpServletRequest request,HttpSession httpSession) {
       
		
	}

}
