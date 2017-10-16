package com.els.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.bean.JhddRooms;
import com.els.bean.JhddSidelines;
import com.els.bean.JhddSidelinesExample;
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
		System.out.println("进入加入房间函数");
		// 查出用户信息备用
		JhddUsers user = jhddUsersMapper.selectByPrimaryKey(userid);
		// 1.判断房间人数是否已满，已满则跳转创建房间页面
		// JhddRooms jhddRooms = jhddRoomsMapper.selectByPrimaryKey(roomid);
		JhddSidelinesExample example = new JhddSidelinesExample();
		example.createCriteria().andRoomidEqualTo(roomid);
		// 查询房间人数
		int roomCount = jhddSidelinesMapper.countByExample(example);
		System.out.println(roomCount);
		// 可加入状态
		if (roomCount > 0 & roomCount <= 8) {
			System.out.println("进入可加入状态");
			// 查询房间状态
			int roomStatus = jhddRoomsMapper.selectRoomStatus(roomid);
			System.out.println(roomStatus);
			// 2.房间未满则判断房间是否处于开始状态。
			JhddSidelines sidelines = new JhddSidelines();
			sidelines.setRoomid(roomid);
			sidelines.setUserid(userid);
			// roomStatus:0=未开始 ,1=游戏中,2=游戏结束
			sidelines.setSidelinestate((byte) 1);
			jhddSidelinesMapper.insert(sidelines);
			// 加入成功展示所有数据
			JhddSidelinesExample jhddSidelinesExample = new JhddSidelinesExample();
			jhddSidelinesExample.createCriteria().andRoomidEqualTo(roomid);
			List<JhddSidelines> JhddSidelines = jhddSidelinesMapper.selectByExample(jhddSidelinesExample);
			return ElsResult.build(1, "SUCCESS", JhddSidelines);
		} else {
			// 不可加入 跳转新建房间页面
			System.out.println("进入不可加入函数");
			return ElsResult.build(0, "房间已满", user);
		}

	}
}
