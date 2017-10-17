package com.els.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ElsResult CreateRome(Integer userid, Integer roomid) {
		if (roomid != null & roomid != 0) {
			// 房间ID不等于空跳转长连接加入房间
			ElsResult joinRoomResult = roomService.joinRoom(userid, roomid);
			return joinRoomResult;
		} else {
			// 新建房间
			ElsResult createRoomResult = roomService.createRoom(userid, roomid);
			return createRoomResult;
		}

	}
}
