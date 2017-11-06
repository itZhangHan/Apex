package com.els.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 路径：http://thdd.apexgame.cn/tetris/room/joinRoom?userid=?&roomid=?
 * 请求方式：get
 * 返回：{
 * 	status(状态)：1成功 0失败
 * 	msg(信息)：SUCCESS
 * 	data(返回数据):data
 * }
 */

@Controller
@RequestMapping("room")
public class JoinRoomController {

	 

	@RequestMapping(value = "/joinRoom")
	public String CreateRome(HttpServletRequest request, Integer userid, Integer roomid, Model model) {
		System.out.println("aaa");
		return "redirect:/skip/joinRoomSend";
	}

	
}
