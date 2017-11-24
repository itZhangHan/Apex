package com.els.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.els.bean.JhddUsers;
import com.els.bean.RoomInfo;
import com.els.common.AuthUtil;
import com.els.common.SocketUsers;
import com.els.socket.SocketMessage;

import net.sf.json.JSONObject;

/*
 * 跳转页面Controller
 */
@Controller
@RequestMapping("/skip")
public class SkipController {

	// 游戏场景
	@RequestMapping("/index")
	public String toIndex(HttpSession session) {
		// return "index"+"?"+getMsg(session);
		return "index";
	}

	// 大厅
	@RequestMapping("/index0")
	public String toIndex0(HttpSession session) {

		// return "index0"+"?"+getMsg(session);
		return "index0";
	}

	// 结束
	@RequestMapping("/over")
	public String toOver(HttpServletRequest request) {

		return "over";

	}

	@RequestMapping(value = "/joinRoomSend")
	public String joinRoomSend(HttpServletRequest request, Integer userid, Integer roomId, Integer sidelinesId) {

		return "index0";
	}

	// 创建页面
	@RequestMapping("/firstsend")
	public String toFirst() {

		return "first";

	}

	// 结束页面
	@RequestMapping("/oversend")
	public String toOver() {

		return "over";

	}

	// 大厅页面
	@RequestMapping("/index0send")
	public String toIndex0() {

		return "index0";

	}

	// 接口：thdd.apexgame.cn/tetris/skip/indexsend
	// 传参：所需参数 玩家姓名：userName 房间状态：roomStatus 房间id:roomId 玩家状态：userStatus
	// 玩家头像：headImg
	/*
	 * @RequestParam("userName") String userName, @RequestParam("roomStatus")
	 * String roomStatus,
	 * 
	 * @RequestParam("userStatus") String userStatus, @RequestParam("headImg")
	 * String headImg,
	 * 
	 * @RequestParam("roomId") String roomId System.out.println("玩家姓名=" +
	 * userName + ";房间状态=" + roomStatus + ";玩家状态=" + userStatus + ";玩家头像=" +
	 * headImg + ";房间id=" + roomId);
	 */

	@RequestMapping(value = "/indexsend", method = RequestMethod.GET)
	public String toIndex() {
		
		return "index";
	}

	// 游戏页面
	// 接口 thdd.apexgame.cn/tetris/skip/indexsend
	// 需要参数
	// @RequestMapping(value = "/indexsend", method = RequestMethod.GET)
	// @RequestBody SetGoodsSpecDTO
	// public String toIndex(@PathVariable SocketMessage message) {
	// System.out.println(message.toString() + "message");
	// System.out.println("城市名称=" + message.getCity());
	// JSONObject obj = JSONObject.fromObject(message);
	// System.out.println("userStatus=" + obj.get("userStatus"));
	// List<SocketUsers> list = ((SocketMessage) message).getListUsers();
	// String roomid = obj.getString("roomid");
	// String roomstate = obj.getString("roomstate");
	// // String userStatus = obj.getString("userStatus");
	// RoomInfo roomsInfo = new RoomInfo();
	// roomsInfo.setRoomid(Integer.parseInt(roomid));
	// roomsInfo.setRoomStatus(Integer.parseInt(roomstate));
	// roomsInfo.setUserStatus(userStatus);
	// return "index";
	// }

	// 授权首页
	@RequestMapping(value = "/first")
	public void toAuto(HttpServletRequest request, HttpSession httpSession) {

	}

}
