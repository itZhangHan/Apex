package com.els.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.bean.JhddUsers;
import com.els.common.ElsResult;
import com.els.serviceinterface.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	/*
	 * url：http://192.168.188.98:8080/tetris/user/insertUser?userid=? 请求方式：get
	 * 返回：{ status：1成功 msg：SUCCESS data:用户数据
	 */
	@RequestMapping(value = "/insertUser", method = RequestMethod.GET)
	@ResponseBody
	public ElsResult InsertUser(JhddUsers user) {
		// 插入数据
		System.out.println("进入增加用户页面");
		ElsResult result = userService.addUser(user);

		return result;
	}

	/*
	 * url：http://192.168.188.98:8080/tetris/user/insertUser?userid=? 请求方式：get
	 * 参数：用户id 返回：{ status：1成功 msg：SUCCESS data:用户数据
	 */
	@RequestMapping("/findUserById")
	@ResponseBody
	public JhddUsers findUser(Integer userid) {
		// 查询数据
		JhddUsers users = userService.findUserById(userid);

		return users;
	}

	/*
	 * url：http://192.168.188.98:8080/tetris/user/findUserList 请求方式：get 参数：无
	 * 返回：{ status：1成功 msg：SUCCESS data:用户数据
	 */
	@RequestMapping("/findUserList")
	@ResponseBody
	public ElsResult findUserList() {
		// 查询数据
		ElsResult result = userService.findUserList();

		return result;
	}
}
