package com.els.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.bean.JhddPositionimg;
import com.els.service.PositionImgServiceImpl;

/*
 * 跳转页面Controller
 */
@Controller
@RequestMapping("/skip")
public class SkipController {
	@Autowired
	private static PositionImgServiceImpl positionImgService;
	@RequestMapping("/toA")
	@ResponseBody
	public JhddPositionimg getJhddPositionimg(Integer roomId){
		JhddPositionimg pg = new JhddPositionimg();
		pg.setImgone("aaa");
		DBController dbc = new DBController();
		positionImgService.addImg(pg);
		JhddPositionimg selectPositionImg = dbc.selectPositionImg(roomId);
		System.out.println(selectPositionImg.getImgone()+"=获取到的第一个图片。");
		return selectPositionImg;
	}
	/*@RequestMapping(value="/toA")
	public String toA(){
		
		return "a";
	}*/
	// 游戏场景
	@RequestMapping("/index")
	public String toIndex(HttpSession session) {
		// return "index"+"?"+getMsg(session);
		return "index";
	}

	// 大厅
	@RequestMapping("/index0")
	public String toIndex0(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException {
		//截取跳转路径
//		String backUrl = request.getRequestURI();
//		String backCallJoinRoom = "http://thdd.apexgame.cn/tetris/callback/joinRoom";
//		String authURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtil.APPID
//				+ "&redirect_uri=" + URLEncoder.encode(backCallJoinRoom) + "&response_type=code" + "&scope=snsapi_userinfo"
//				+ "&state=STATE#wechat_redirect";
//		 重定向用户请求到微信授权URL
//		response.sendRedirect(authURL);
//		 return "index0"+"?"+getMsg(session);
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
