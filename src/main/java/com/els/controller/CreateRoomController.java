package com.els.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.els.bean.JhddSidelines;
import com.els.bean.JhddUsers;
import com.els.common.AuthUtil;
import com.els.common.ElsResult;
import com.els.mapper.JhddRoomsMapper;
import com.els.serviceinterface.RoomService;
import com.els.serviceinterface.UserService;

/*
 * 路径：http://thdd.apexgame.cn/tetris/room/createRoom?userid=?
 * 请求方式：get
 * 返回：{
 * 	status(状态)：1成功 0失败
 * 	msg(信息)：SUCCESS
 * 	data(返回数据):data
 * }
 */

@Controller
@RequestMapping("room")
public class CreateRoomController {

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private UserService userService;
	@Autowired 
	private JhddRoomsMapper jhddRoomsMapper;

	@RequestMapping(value = "createRoom")
	public String CreateRome(HttpServletRequest request, Integer userid, Integer roomid, Model model) {
		System.out.println(userid + "获取到userid，进入创建房间方法...");
		// 新建房间
		System.out.println("新建房间");
		ElsResult result = roomService.createRoom(userid);
		//JhddSidelines jhddSidelines = (JhddSidelines) result.getData();
		JhddSidelines sidelines = (JhddSidelines) result.getData();
		ElsResult userResult = userService.findUserById(userid);
		JhddUsers users = (JhddUsers) userResult.getData();
		Integer lastInsertRoomId = jhddRoomsMapper.selectLastInsertRoomId();
		System.out.println("房间id："+lastInsertRoomId);
		return AuthUtil.getMsg(users, "index0", sidelines);

	}
}
