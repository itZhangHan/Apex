package com.els.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.els.bean.JhddGameInfo;
import com.els.bean.JhddUsers;
import com.els.service.GameInfoServiceImpl;

@Controller
public class GamesInfoController {

	@Autowired
	private static GameInfoServiceImpl gameInfoServiceImpl;

	@RequestMapping(value = "/selectByRoomId")
	public JhddGameInfo selectById(Integer roonId) {
		JhddGameInfo jhddGameInfo = gameInfoServiceImpl.selectByRoomId(roonId);
		return jhddGameInfo;
	}

	@RequestMapping(value = "/addGameInfo")
	public void addGameInfo(JhddGameInfo gameInfo) {
		gameInfoServiceImpl.addGamesInfo(gameInfo);
	}

	@RequestMapping(value = "/updateGameInfo")
	public void update(JhddGameInfo gameInfo) {
		gameInfoServiceImpl.updataByGamesInfo(gameInfo);
	}

	@RequestMapping(value = "/selectByHeadImg")
	public JhddUsers selectByImg(String headImg) {
		JhddUsers jhddUsers = gameInfoServiceImpl.selectByHeadImg(headImg);
		return jhddUsers;
	}

}
