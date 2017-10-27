package com.els.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.bean.JhddUsers;
import com.els.bean.JhddUsersExample;
import com.els.common.ElsResult;
import com.els.mapper.JhddUsersMapper;
import com.els.serviceinterface.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JhddUsersMapper userMapper;

	@Override
	public ElsResult addUser(JhddUsers user) {
		if (user != null) {
			// 向数据库插入用户信息
			int userid = userMapper.insert(user);
			if (userid != 0 && !"".equals(userid)) {
				// 成功返回userid
				return ElsResult.ok(userid);
			} else {
				// 失败返回错误信息
				return ElsResult.build(0, "用户添加失败。");
			}
		} else {
			return ElsResult.build(0, "出现未知错误。");
		}

	}

	@Override
	public ElsResult findUserById(Integer userid) {
		// TODO Auto-generated method stub
		if (userid != null & userid != 0) {
			JhddUsers users = userMapper.selectByPrimaryKey(userid);
			if (users != null) {
				return ElsResult.build(1, "查询呢成功", users, null);
			} else {
				return ElsResult.build(0, "查询失败");
			}
		} else {
			return ElsResult.build(0, "出现未知错误");
		}

	}

	@Override
	public ElsResult findUserList() {
		// TODO Auto-generated method stub
		JhddUsersExample example = new JhddUsersExample();
		List<JhddUsers> userList = userMapper.selectByExample(example);
		if (userList.size() != 0 & userList != null) {
			return ElsResult.build(1, "SUCCESS", userList, null);
		} else {
			return ElsResult.build(0, "查询失败!");
		}
	}

}
