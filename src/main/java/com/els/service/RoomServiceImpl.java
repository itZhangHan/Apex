package com.els.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.bean.JhddRooms;
import com.els.bean.JhddSidelines;
import com.els.bean.JhddUsers;
import com.els.common.ElsResult;
import com.els.mapper.JhddRoomsMapper;
import com.els.mapper.JhddSidelinesMapper;
import com.els.mapper.JhddUsersMapper;
import com.els.serviceinterface.RoomService;

@Transactional
@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private JhddRoomsMapper jhddRoomsMapper;

	@Autowired
	private JhddUsersMapper jhddUsersMapper;

	@Autowired
	private JhddSidelinesMapper jhddSidelinesMapper;

	@Override
	public ElsResult createRoom(Integer userid, Integer romeid) {
		// TODO Auto-generated method stub
		System.out.println("进入新建方法");
		// 查询用户信息
		JhddUsers user = jhddUsersMapper.selectByPrimaryKey(userid);
		// 当房间ID为空的时候跳转创建房�?
		ElsResult result = new ElsResult();
		// 设置房间属性。
		JhddRooms room = new JhddRooms();
		room.setRoomname(user.getUsername());
		room.setRoomstate((byte) 0);
		int insertid = jhddRoomsMapper.insert(room);
		System.out.println(insertid);
		System.out.println(room.getRoomid());
		// 添加第三组表属�?
		if (room.getRoomid() != null) {
			JhddSidelines jhddSideline = new JhddSidelines();
			jhddSideline.setRoomid(room.getRoomid());
			jhddSideline.setUserid(userid);
			// 0房主 1玩家 2旁观者
			jhddSideline.setSidelinestate((byte) 0);
			jhddSidelinesMapper.insert(jhddSideline);
			// 新建房间成功时查询房间信息并返回�?
			JhddSidelines jhddSidelines = jhddSidelinesMapper.selectByPrimaryKey(jhddSideline.getSidelinesid());
			// 1成功 0失败
			return result.build(1, "SUCCESS", jhddSidelines);
		} else {
			return result.build(1, "出现未知错误！");
		}

	}

	@Override
	public ElsResult joinRoom(Integer userid, Integer roomid) {
		// TODO Auto-generated method stub
		JhddUsers user = jhddUsersMapper.selectByPrimaryKey(userid);
		JhddRooms jhddRooms = jhddRoomsMapper.selectByPrimaryKey(roomid);
		while(jhddRooms.getRoomstate()==1){
			
		}
		JhddSidelines jhddSidelines = new JhddSidelines();
		jhddSidelines.setRoomid(roomid);
		jhddSidelines.setUserid(userid);
		return null;
	}
}
