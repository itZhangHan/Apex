package com.els.serviceinterface;

import com.els.bean.JhddGameInfo;
import com.els.bean.JhddUsers;

public interface GameInfoService {

	public JhddGameInfo selectByRoomId(Integer roomId);
	
	public void updataByGamesInfo(JhddGameInfo gamesInfo);
	
	public void addGamesInfo(JhddGameInfo gamesInfo);
	
	public JhddUsers selectByHeadImg(String headImg);

	public void deleteByRoomId(String roomId);
}
