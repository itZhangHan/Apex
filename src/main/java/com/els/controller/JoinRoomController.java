package com.els.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.bean.JhddUsers;
import com.els.common.AuthUtil;
import com.els.common.ElsResult;
import com.els.serviceinterface.RoomService;

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

	@Autowired
	private RoomService roomService;

	@RequestMapping(value = "joinRoom")
	public String CreateRome(HttpServletRequest request, Integer userid, Integer roomid, Model model) {
		System.out.println(userid + "进入加入房间方法...");
		ElsResult result = null;
		if (roomid != null && roomid != 0) {
			// 房间ID不等于空跳转长连接加入房间${}
			System.out.println("加入房间");
			result = roomService.joinRoom(userid, roomid);
			model.addAttribute("result", result);
			return AuthUtil.getMsg(null, "index0", null, null);
		} else {
			return AuthUtil.getMsg(null, "first", null, null);
		}

	}
}
