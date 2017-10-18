package com.els.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.common.ElsResult;
import com.els.serviceinterface.RoomService;

/*
 * 路径：http://192.168.188.98:8080/tetris/room/joinOrCreateRoom?userid=?
 * 请求方式：get
 * 返回：{
 * 	status(状态)：1成功 0失败
 * 	msg(信息)：SUCCESS
 * 	data(返回数据):data
 * }
 */
@Controller
@RequestMapping("room")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@RequestMapping(value = "joinOrCreateRoom")
	@ResponseBody
	public String CreateRome(Integer userid, Integer roomid,Model model) {
		System.out.println(userid+"aaaaas");
		ElsResult result=null;
		if (roomid != null && roomid != 0) {
			// 房间ID不等于空跳转长连接加入房间${}
			System.out.println("加入房间");
			result = roomService.joinRoom(userid, roomid);
			model.addAttribute("result", result);
			return "index";
		} else{
			// 新建房间
			System.out.println("新建房间");
			result = roomService.createRoom(userid, roomid);
			model.addAttribute("result", result);
			return "index";
		} 

	}
}
