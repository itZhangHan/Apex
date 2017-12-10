package com.els.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.bean.JhddGameInfo;
import com.els.bean.JhddUsers;
import com.els.mapper.JhddGameInfoMapper;
import com.els.mapper.JhddUsersMapper;
import com.els.serviceinterface.GameInfoService;

@Transactional
@Service("gameInfoService")
public class GameInfoServiceImpl implements GameInfoService{

	@Autowired
	private JhddGameInfoMapper jhddGameInfoMapper;
	
	@Autowired
	private JhddUsersMapper jhddUsersMapper;
	
	@Override
	public JhddGameInfo selectByRoomId(Integer roomId) {
		// 根据房间Id查询详细玩家信息
		
		JhddGameInfo gameInfo = jhddGameInfoMapper.selectByRoomId(roomId);
		return gameInfo;
	}

	@Override
	public void updataByGamesInfo(JhddGameInfo gamesInfo) {
		// TODO Auto-generated method stub
		jhddGameInfoMapper.updateByPrimaryKeySelective(gamesInfo);
	}

	@Override
	public void addGamesInfo(JhddGameInfo gamesInfo) {
		// TODO Auto-generated method stub
		jhddGameInfoMapper.insert(gamesInfo);
	}

	@Override
	public JhddUsers selectByHeadImg(String headImg) {
		// TODO Auto-generated method stub
		JhddUsers user= jhddUsersMapper.selectByHeadImg(headImg);
		return user;
	}

	@Override
	public void deleteByRoomId(String roomId) {
		// TODO Auto-generated method stub
		jhddGameInfoMapper.deleteByRoomId(roomId);
	}

}
