package com.els.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.els.bean.JhddRooms;
import com.els.bean.JhddSidelines;
import com.els.bean.JhddSidelinesExample;
import com.els.bean.JhddUsers;
import com.els.bean.RoomInfo;
import com.els.common.AuthUtil;
import com.els.mapper.JhddRoomsMapper;
import com.els.mapper.JhddSidelinesMapper;
import com.els.mapper.JhddUsersMapper;
import com.els.serviceinterface.UserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/callback")
public class WxCallbackJoinRoom {
	@Autowired
	private JhddSidelinesMapper jhddSidelinesMapper;
	@Autowired
	private JhddUsersMapper userMapper;
	@Autowired
	private JhddRoomsMapper roomsMapper;
	@Autowired
	private UserService userService;

	// 查询用户信息返回参数
	@RequestMapping("/joinRoom")
	public String toFirst(HttpServletRequest request, HttpSession session, Integer roomid) throws Exception {
		System.out.println("进入callback页面");
		System.out.println(roomid);
		String roomId = request.getSession().getAttribute("roomid").toString();
		Integer room_id = Integer.parseInt(roomId);
		String code = request.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=" + AuthUtil.APPID + "&secret="
				+ AuthUtil.APPSECRET + "&code=" + code + "&grant_type=authorization_code";
		// 2. 向微信发出请求，带上APPSCECRET和code，获取openid和access_toekn
		System.out.println("进入工具类方法");
		JSONObject jsonObject = AuthUtil.doGetJson(url);
		String openid = jsonObject.getString("openid");
		System.out.println("openid获取成功" + openid);
		String token = jsonObject.getString("access_token");
		// 通过openid查询是否存在信息
		JhddUsers users = userMapper.selectByOpenid(openid);

		// 获取请求路径
		String urlName = request.getSession().getAttribute("urlName").toString();
		if (users == null) {
			// 1. 使用微信用户信息直接登录，无需注册和绑定
			// 4. 获取用户信息
			String infoUrl = "https://api.weixin.qq.com/sns/userinfo?" + "access_token=" + token + "&openid=" + openid
					+ "&lang=zh_CN";
			JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
			System.out.println("5");
			request.setAttribute("userInfo", userInfo);
			// 当access_token过时时进行刷新
			System.out.println("进入刷新呢token方法");
			// 获取token
			String refresh_token = jsonObject.getString("refresh_token");

			// 刷新token
			String refresh_url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" + AuthUtil.APPID
					+ "&grant_type=refresh_token" + "&refresh_token=" + refresh_token;
			AuthUtil.doGetJson(refresh_url);
			System.out.println("刷新成功......");

			String nickname = (String) userInfo.get("nickname");
			Integer sex = (Integer) userInfo.get("sex");
			String headimgurl = userInfo.getString("headimgurl");
			String city = userInfo.getString("city");
			// 将授权用户信息加入数据库

			JhddUsers user = new JhddUsers();
			user.setOpenid(openid);
			user.setUsername(nickname);
			user.setCity(city);
			user.setUserportrait(headimgurl);
			user.setUsersex(sex);
			// 插入用户成功返回userID
			userService.addUser(user);
			RoomInfo roomsInfo = new RoomInfo();
			roomsInfo.setRoomid(room_id);
			// 查询房间状态
			JhddRooms jhddRooms = roomsMapper.selectByPrimaryKey(room_id);
			Integer roomstate = jhddRooms.getRoomstate();
			roomsInfo.setRoomStatus(roomstate);
			// 查询玩家状态
			Integer userStatus = jhddSidelinesMapper.selectUserStatusByUserid(user.getUserid(), room_id);
			roomsInfo.setUserStatus(userStatus);

//			List<JhddUsers> userList = jhddSidelinesMapper.selectUsersInfoByRoomId(room_id);
//			roomsInfo.setUserList(userList);
			// 加入房间函数

			// 1.判断房间人数是否已满，已满则跳转创建房间页面
			JhddSidelinesExample example = new JhddSidelinesExample();
			example.createCriteria().andRoomidEqualTo(room_id);
			// 查询房间人数
			int roomCount = jhddSidelinesMapper.countByExample(example);
			System.out.println("当前房间人数:" + roomCount);
			// 可加入状态
			if (roomCount > 0 & roomCount <= 8) {
				System.out.println("进入可加入状态");
				// 查询房间状态
				int roomStatus = roomsMapper.selectRoomStatus(room_id);
				System.out.println(roomStatus);
				// 2.房间未满则判断房间是否处于开始状态。
				if (roomStatus == 0 && !"0".equals(roomStatus)) {

					JhddSidelines sidelines = new JhddSidelines();

					sidelines.setRoomid(room_id);

					// 0:房主，1:玩家,2:旁观者
					sidelines.setSidelinestate((byte) 2);
					jhddSidelinesMapper.insert(sidelines);
				}
			} else {
				return AuthUtil.getMsg(user, "first", roomsInfo,null);
			}

			return AuthUtil.getMsg(user, urlName, roomsInfo,null);
		}
		RoomInfo roomsInfo = new RoomInfo();
		roomsInfo.setRoomid(room_id);
		// 查询房间状态
		JhddRooms jhddRooms = roomsMapper.selectByPrimaryKey(room_id);
		Integer roomstate = jhddRooms.getRoomstate();
		roomsInfo.setRoomStatus(roomstate);
		// 如果房间内包含房主 那么设置新加入玩家属性为旁观
		roomsInfo.setUserStatus(2);

//		List<JhddUsers> userList = jhddSidelinesMapper.selectUsersInfoByRoomId(room_id);
//
//		roomsInfo.setUserList(userList);

		JhddSidelinesExample example = new JhddSidelinesExample();
		example.createCriteria().andRoomidEqualTo(room_id);
		// 查询房间人数
		int roomCount = jhddSidelinesMapper.countByExample(example);
		System.out.println("当前房间人数:" + roomCount);
		// 可加入状态
		if (roomCount > 0 & roomCount <= 8) {
			System.out.println("进入可加入状态");
			// 查询房间状态
			int roomStatus = roomsMapper.selectRoomStatus(room_id);
			System.out.println(roomStatus);
			// 2.房间未满则判断房间是否处于开始状态。
			if (roomStatus == 0 && !"0".equals(roomStatus)) {

				JhddSidelines sidelines = new JhddSidelines();
				sidelines.setUserid(users.getUserid());
				sidelines.setRoomid(room_id);
				// List<Integer> status =
				// jhddSidelinesMapper.selectAllUserStatus(room_id);
				// 0:房主，1:玩家,2:旁观者
				sidelines.setSidelinestate((byte) 2);
				jhddSidelinesMapper.insert(sidelines);
			}
		} else {
			return AuthUtil.getMsg(users, "first", roomsInfo,null);
		}

		return AuthUtil.getMsg(users, urlName, roomsInfo,null);
	}
}
