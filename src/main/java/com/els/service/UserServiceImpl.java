package com.els.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.bean.JhddUsers;
import com.els.bean.JhddUsersExample;
import com.els.common.UserResult;
import com.els.mapper.JhddUsersMapper;
import com.els.serviceinterface.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JhddUsersMapper userMapper;

	@Override
	public UserResult addUser(JhddUsers user) {
		if (user != null) {
			// 向数据库插入用户信息
			int i = userMapper.insert(user);
			if (i != 0) {
				// 成功返回OK
				return UserResult.ok();
			} else {
				// 失败返回错误信息
				return UserResult.build(0, "用户添加失败。");
			}
		} else {
			return UserResult.build(0, "出现未知错误。");
		}

	}

	@Override
	public UserResult findUserById(Integer userid) {
		// TODO Auto-generated method stub
		if (userid != null & userid != 0) {
			JhddUsers users = userMapper.selectByPrimaryKey(userid);
			if (users != null) {
				return UserResult.build(1, "查询呢成功", users);
			} else {
				return UserResult.build(0, "查询失败");
			}
		} else {
			return UserResult.build(0, "出现未知错误");
		}

	}

	@Override
	public UserResult findUserList() {
		// TODO Auto-generated method stub
		JhddUsersExample example = new JhddUsersExample();
		List<JhddUsers> userList = userMapper.selectByExample(example);
		if (userList.size() != 0 & userList != null) {
			return UserResult.build(1, "SUCCESS", userList);
		} else {
			return UserResult.build(0, "查询失败!");
		}
	}

}
