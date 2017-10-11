package com.els.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.bean.JhddUsers;
import com.els.common.UserResult;
import com.els.serviceinterface.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/insertUser", method = RequestMethod.GET)
	@ResponseBody
	public UserResult InsertUser(JhddUsers user) {
		// 插入数据
		UserResult result = userService.addUser(user);

		return result;
	}

	@RequestMapping("/findUserById")
	@ResponseBody
	public UserResult findUser(Integer userid) {
		// 查询数据
		UserResult result = userService.findUserById(userid);

		return result;
	}

	@RequestMapping("/findUserList")
	@ResponseBody
	public UserResult findUserList() {
		// 查询数据
		UserResult result = userService.findUserList();

		return result;
	}
}
