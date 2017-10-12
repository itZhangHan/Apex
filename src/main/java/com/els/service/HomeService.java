package com.els.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HomeService {

	public void inOrCreateHome(Integer uid, Integer hid) {
		System.out.println("进入方法");
		// // 查询房间信息 就判断为空，判断房子是否存在
		// Gamehome home = gameHomeMapper.selectByPrimaryKey(hid);
		// // 查询当前用户信息
		// User user1 = userMapper.selectByPrimaryKey(uid);
		// int lastId=gameHomeMapper.selectLastId();
		// HomeResult hr = null;
		// // 当房间等于空的时候新建
		// if (home == null) {
		// System.out.println("进入新建房间函数...");
		// Gamehome gameInfo = new Gamehome();
		// gameInfo.setHid(RandomUtils.nextInt(10));
		// gameInfo.setHname(user1.getUname() + "的房间");
		// gameInfo.setPersonNum(1);
		// gameInfo.setHomeStatus(0);
		// gameInfo.setCreateDate(new Date());
		// // 加入数据库
		// gameHomeMapper.insert(gameInfo);
		//
		// User user = new User();
		// int maxId = userMapper.selectMaxId();
		// user.setUid(maxId + 1);
		// user.setUname(user1.getUname());
		// System.out.println(user.getHomeId());
		//
		// user.setHomeId(lastId);
		// // 设置是否是房主
		// user.setHomeowner(0);
		// // 设置未准备
		// user.setStatus(0);
		// userMapper.updateByPrimaryKeySelective(user);
		// // 查询房间所有用户
		// UserExample example = new UserExample();
		// example.createCriteria().andHomeIdEqualTo(lastId);
		// System.out.println("开始查询房间所有用户...");
		// List<User> u = userMapper.selectByExample(example);
		//
		// hr = new HomeResult();
		// hr.setData(u);//
		// hr.setMsg("新建房间成功。");
		// System.out.println("新建房间...");
		// hr.setStatus(1);
		// return hr;
		// } else {
		// System.out.println("进入加入房间函数...");
		// // home里面mei没有人数吗
		// int maxId = userMapper.selectMaxId();
		// user1.setUid(maxId + 1);
		// user1.setUname(user1.getUname());
		// user1.setHomeId(hid);
		// // 设置是否是房主
		// user1.setHomeowner(0);
		// // 设置未准备
		// user1.setStatus(0);
		// userMapper.updateByPrimaryKeySelective(user1);
		// // 将用户加入房间
		// Gamehome gameInfo = new Gamehome();
		// gameInfo.setHid(hid);
		//
		// //获取当前房间房主姓名。
		// gameInfo.setHname(userMapper.findHomeOnwerName(hid) + "的房间");
		// gameInfo.setPersonNum(home.getPersonNum()+1);
		// gameInfo.setHomeStatus(0);
		// gameInfo.setCreateDate(new Date());
		// gameHomeMapper.updateByPrimaryKey(gameInfo);
		// // 查询房间所有用户
		// UserExample example = new UserExample();
		// example.createCriteria().andHomeIdEqualTo(hid);
		// System.out.println("开始查询房间所有用户...");
		// List<User> u = userMapper.selectByExample(example);
		//
		// hr = new HomeResult();
		// hr.setData(u);//
		// hr.setMsg("加入房间成功。");
		// System.out.println("加入房间...");
		// hr.setStatus(0);
		// return hr;
		// }
	}

}
