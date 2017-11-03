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
	@SuppressWarnings("all")
	public JhddSidelines createRoom(Integer userid) {
		// TODO Auto-generated method stub
		String a = "";
		System.out.println("进入新建房间方法");
		// 查询用户信息
		JhddUsers user = jhddUsersMapper.selectByPrimaryKey(userid);
		// 当房间ID为空的时候跳转创建房�?
		// 设置房间属性。
		JhddRooms room = new JhddRooms();
		room.setRoomname(user.getUsername() + "的房间");
		// 0未开始 1：游戏中 2:游戏结束
		room.setRoomstate((byte) 0);
		jhddRoomsMapper.insert(room);
		// 插入成功返回roomid
		int roomid = jhddRoomsMapper.selectLastInsertRoomId();
		// int roomid = jhddRoomsMapper.insert(room);
		System.out.println("新建房间成功 返回roomid=" + roomid);

		// 添加第三组表属�?
		if (roomid != 0 && !"".equals(roomid)) {
			JhddSidelines jhddSideline = new JhddSidelines();
			jhddSideline.setRoomid(roomid);
			jhddSideline.setUserid(userid);
			// 0房主 1玩家 2旁观者
			jhddSideline.setSidelinestate((byte) 0);
			jhddSidelinesMapper.insert(jhddSideline);
			JhddSidelinesExample example = new JhddSidelinesExample();
			example.createCriteria().andRoomidEqualTo(roomid);
			List<JhddSidelines> list = jhddSidelinesMapper.selectByExample(example);
			for (JhddSidelines jhddSidelines : list) {
				return jhddSideline;
			}
			// 新建房间成功时查询房间信息并返回�?
			JhddSidelines jhddSidelines = jhddSidelinesMapper.selectLastSidelines();

			return jhddSidelines;

			// 1成功 0失败

		} else {
			JhddSidelines jhddSidelines = jhddSidelinesMapper.selectLastSidelines();

			return jhddSidelines;
		}

	}

	public ElsResult joinRoom(Integer roomid) {
		System.out.println("进入加入房间函数");
		// 查出用户信息备用
		// JhddUsers user = jhddUsersMapper.selectByPrimaryKey(userid);
		// 1.判断房间人数是否已满，已满则跳转创建房间页面
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
			if (roomStatus == 0 && !"0".equals(roomStatus)) {

				JhddSidelines sidelines = new JhddSidelines();

				sidelines.setRoomid(roomid);

				// 0:房主，1:玩家,2:旁观者
				sidelines.setSidelinestate((byte) 2);
				jhddSidelinesMapper.insert(sidelines);
				return ElsResult.build(1, "SUCCESS", sidelines, roomStatus);
			}
			// 加入成功展示所有数据
			JhddSidelinesExample jhddSidelinesExample = new JhddSidelinesExample();
			jhddSidelinesExample.createCriteria().andRoomidEqualTo(roomid);
			List<JhddSidelines> JhddSidelines = jhddSidelinesMapper.selectByExample(jhddSidelinesExample);
			for (JhddSidelines jhddSidelines2 : JhddSidelines) {
				return ElsResult.build(1, "SUCCESS", jhddSidelines2, roomStatus);
			}
		} else {
			// 不可加入 跳转新建房间页面
			System.out.println("进入不可加入函数");
			return ElsResult.ok("redirect:/skip/first");
		}
		return null;

	}

	// @Override
	// public JhddUsers selectUsers(JhddSidelines sidelines) {
	// // TODO Auto-generated method stub
	//
	// JhddSidelinesExample example = new JhddSidelinesExample();
	// example.createCriteria().andUseridEqualTo(sidelines.getUserid());
	// List<JhddSidelines> user =jhddSidelinesMapper.selectByExample(example);
	// return null;
	// }
}
