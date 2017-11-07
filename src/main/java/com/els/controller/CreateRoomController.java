package com.els.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.els.bean.JhddRooms;
import com.els.bean.JhddSidelines;
import com.els.bean.JhddUsers;
import com.els.bean.RoomInfo;
import com.els.common.AuthUtil;
import com.els.mapper.JhddRoomsMapper;
import com.els.mapper.JhddSidelinesMapper;
import com.els.mapper.JhddUsersMapper;
import com.els.serviceinterface.RoomService;

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
	private JhddUsersMapper userMapper;
	
	@Autowired
	private JhddRoomsMapper jhddRoomsMapper;
	@Autowired
	private JhddSidelinesMapper jhddSidelinesMapper;

	@RequestMapping(value = "createRoom")
	public String CreateRome(HttpServletRequest request, Integer userid) {
		System.out.println(userid + "获取到userid，进入创建房间方法...");
		// 新建房间
		System.out.println("新建房间");
		JhddSidelines sidelines = roomService.createRoom(userid);

		JhddUsers users = userMapper.selectByPrimaryKey(userid);

		RoomInfo roomsInfo = new RoomInfo();
		roomsInfo.setRoomid(sidelines.getRoomid());
		// 查询房间状态
		JhddRooms jhddRooms = jhddRoomsMapper.selectByPrimaryKey(sidelines.getRoomid());
		Integer roomstate = jhddRooms.getRoomstate();
		roomsInfo.setRoomStatus(roomstate);
		// 查询玩家状态
		Integer userStatus = jhddSidelinesMapper.selectUserStatusByUserid(users.getUserid(), sidelines.getRoomid());
		roomsInfo.setUserStatus(userStatus);

//		List<JhddUsers> userList = jhddSidelinesMapper.selectUsersInfoByRoomId(sidelines.getRoomid());
//		roomsInfo.setUserList(userList);
		//System.out.println(userList);
		return AuthUtil.getMsg(users, "index0send", roomsInfo);

	}
}
