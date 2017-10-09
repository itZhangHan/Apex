package com.els.serviceimpl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.bean.Gamehome;
import com.els.bean.HomeResult;
import com.els.bean.User;
import com.els.bean.UserExample;
import com.els.mapper.GamehomeMapper;
import com.els.mapper.UserMapper;
import com.els.service.HomeService;

@Service
@Transactional
public class HomeServiceImpl implements HomeService{

	@Autowired
	private GamehomeMapper gameHomeMapper;

	@Autowired
	private UserMapper userMapper;

	public HomeResult inOrCreateHome(Integer uid, Integer hid) {
		System.out.println("进入方法");
		// 查询房间信息 就判断为空，判断房子是否存在
		Gamehome home = gameHomeMapper.selectByPrimaryKey(hid);
		// 查询当前用户信息
		User user1 = userMapper.selectByPrimaryKey(uid);
		int lastId=gameHomeMapper.selectLastId();
		HomeResult hr = null;
		// 当房间等于空的时候新建
		if (home == null) {
			System.out.println("进入新建房间函数...");
			Gamehome gameInfo = new Gamehome();
			gameInfo.setHid(RandomUtils.nextInt(10));
			gameInfo.setHname(user1.getUname() + "的房间");
			gameInfo.setPersonNum(1);
			gameInfo.setHomeStatus(0);
			gameInfo.setCreateDate(new Date());
			// 加入数据库
			gameHomeMapper.insert(gameInfo);
			
			User user = new User();
			int maxId = userMapper.selectMaxId();
			user.setUid(maxId + 1);
			user.setUname(user1.getUname());
			System.out.println(user.getHomeId());
			
			user.setHomeId(lastId);
			// 设置是否是房主
			user.setHomeowner(0);
			// 设置未准备
			user.setStatus(0);
			userMapper.updateByPrimaryKeySelective(user);
			// 查询房间所有用户
			UserExample example = new UserExample();
			example.createCriteria().andHomeIdEqualTo(lastId);
			System.out.println("开始查询房间所有用户...");
			List<User> u = userMapper.selectByExample(example);

			hr = new HomeResult();
			hr.setData(u);//
			hr.setMsg("新建房间成功。");
			System.out.println("新建房间...");
			hr.setStatus(1);
			return hr;
		} else {
			System.out.println("进入加入房间函数...");
			// home里面mei没有人数吗
			int maxId = userMapper.selectMaxId();
			user1.setUid(maxId + 1);
			user1.setUname(user1.getUname());
			user1.setHomeId(hid);
			// 设置是否是房主
			user1.setHomeowner(0);
			// 设置未准备
			user1.setStatus(0);
			userMapper.updateByPrimaryKeySelective(user1);
			// 将用户加入房间
			Gamehome gameInfo = new Gamehome();
			gameInfo.setHid(hid);
//			//查询房主信息。
//			UserExample userExample = new UserExample();
//			userExample.createCriteria().andHomeownerEqualTo(1);
//			//取所有房主信息
//			List<User> ownerList = userMapper.selectByExample(userExample);
				
			//获取当前房间房主姓名。
			gameInfo.setHname(userMapper.findHomeOnwerName(hid) + "的房间");
			gameInfo.setPersonNum(home.getPersonNum()+1);
			gameInfo.setHomeStatus(0);
			gameInfo.setCreateDate(new Date());
			gameHomeMapper.updateByPrimaryKey(gameInfo);
			// 查询房间所有用户
			UserExample example = new UserExample();
			example.createCriteria().andHomeIdEqualTo(hid);
			System.out.println("开始查询房间所有用户...");
			List<User> u = userMapper.selectByExample(example);

			hr = new HomeResult();
			hr.setData(u);//
			hr.setMsg("加入房间成功。");
			System.out.println("加入房间...");
			hr.setStatus(0);
			return hr;
		}
	}

	// public HomeResult inOrCreateHome(Integer uid, Integer hid) {
	// // TODO Auto-generated method stub
	// // 根据ID查询到房间信息。将数据封装结果然后返回
	// // 根据用户id查询到用户信息。
	// User user1 = null;
	// HomeResult hr = null;
	// if (uid != null) {
	// System.out.println("开始查询当前用户...");
	// // 这里的用户就是查询出来先放着。。
	// user1 = userMapper.selectByPrimaryKey(uid);
	// System.out.println(user1);
	// } else {
	// hr = new HomeResult();
	// // 0成功 1失败
	// hr.setStatus(1);
	// hr.setMsg("用户id传输失败。");
	// return hr;
	// }
	//
	// // 房间所有用户
	// UserExample example = new UserExample();
	// example.createCriteria().andHomeIdEqualTo(hid);
	// System.out.println("开始查询房间所有用户...");
	// List<User> u = userMapper.selectByExample(example);
	// if (u == null && u.size() == 0) { // 判断房间 是否存在 用户是否为0
	// System.out.println("进入新建房间函数...");
	// // 新建房间
	// // 查询当前房间信息
	// Gamehome gameInfo = gameHomeMapper.selectByPrimaryKey(hid);
	// gameInfo.setHid(RandomUtils.nextInt(100));
	// gameInfo.setHname(user1.getUname() + "的房间");
	// gameInfo.setPersonNum(u.size());
	// gameInfo.setHomeStatus(0);
	// gameInfo.setCreateDate(new Date());
	// // 加入数据库
	// gameHomeMapper.insert(gameInfo);
	// hr = new HomeResult();
	// hr.setData(gameInfo);
	// hr.setMsg("新建房间成功。");
	// System.out.println("新建房间...");
	// hr.setStatus(1);
	// return hr;
	// } else {
	// hr = new HomeResult();
	// hr.setData(null);
	// hr.setMsg("出现异常");
	// hr.setStatus(1);
	// return hr;
	// }
	// if (u.contains(user1)) {
	// // 包含直接返回
	// hr = new HomeResult();
	// hr.setData(user1);
	// hr.setMsg("该用户已存在");
	// hr.setStatus(user1.getStatus());
	// return hr;
	// } else if (!u.contains(user1)) {
	// System.out.println("用户不存在函数进入...");
	// // 用户不存在的逻辑判断
	// // 查询最大ID
	// int maxId = userMapper.selectMaxId();
	// user1.setUid(maxId + 1);
	// user1.setUname(user1.getUname());
	// System.out.println(user1.getHomeId());
	// user1.setHomeId(user1.getHomeId());
	// // 设置是否是房主
	// user1.setHomeowner(0);
	// // 设置未准备
	// user1.setStatus(0);
	// userMapper.insert(user1);
	// hr = new HomeResult();
	// hr.setData(user1);
	// hr.setMsg("加入房间成功。");
	// hr.setStatus(1);
	// System.out.println("insert成功");
	// return hr;
	// }
	//
	// // 查询房间所有用户
	// // gameHomeMapper.s
	// // 判断房间用户是否包含该用户 如果存在该用户
	//
	// }

}
