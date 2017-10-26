package com.els.controller;

import java.io.UnsupportedEncodingException;

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


	// 游戏场景
	@RequestMapping("/index")
	public String toIndex(HttpSession session) {
		return "index";
	}

	// 大厅
	@RequestMapping("/index0")
	public String toIndex0(HttpSession session) {

		return "index0";
	}

	// 结束
	@RequestMapping("/over")
	public String toOver(HttpSession session) {

		return "over";
	}

	// 授权首页
	@RequestMapping("/first")
	public String toAuto(HttpSession session) {
		getMsg(session);
		return "first"+"?"+getMsg(session);
	}
	
	private String getMsg(HttpSession session){
		String nickname="";
		String city="";
		String headimgurl="";
		String sex="";
		try {
			nickname= new String(session.getAttribute("urlName").toString().getBytes(), "UTF-8");
			city=new String(session.getAttribute("city").toString().getBytes(), "UTF-8");
			headimgurl=new String(session.getAttribute("headimgurl").toString().getBytes(), "UTF-8");
			sex=new String(session.getAttribute("sex").toString().getBytes(), "UTF-8");
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "nickname="+ nickname+"&sex="+sex+"&headimgurl="+headimgurl+"&city="+city;
		
	}
}
