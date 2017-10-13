package com.els.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.WebSockerServer.WebSocketServer;
import com.els.common.ElsResult;
import com.els.serviceinterface.RoomService;

/*
 * 路径：http://192.168.188.98:8080/tetris/room/createRoom?userid=?
 * 请求方式：get
 * 返回：{
 * 	status：1成功
 * 	msg：SUCCESS
 * 	data:data
 * }
 */
@Controller
@RequestMapping("room")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@RequestMapping(value = "createRoom")
	@ResponseBody
	public ElsResult CreateRome(Integer userid, Integer roomid) {
		if (roomid != null) {
			// 房间ID不等于空跳转长连接加入房间
			// WebSocketServer webSocketServer = new WebSocketServer();
			ElsResult result = new ElsResult();
			return result.build(0, "加入房间失败！");
		} else {
			// 新建房间
			ElsResult result = roomService.createRoom(userid, roomid);
			return result;
		}

	}
}
