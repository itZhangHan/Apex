package com.els.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.els.bean.JhddPositionimg;
import com.els.service.PositionImgServiceImpl;

@Controller
public class DBController {

	@Autowired
	private static PositionImgServiceImpl positionImgService;

	/*
	 * 向数据库增加座位信息。
	 */
	@RequestMapping("/addPositionImg")
	public void addPositionImg(JhddPositionimg positionImg) {
		positionImgService.addImg(positionImg);

	}

	/*
	 * 
	 */
	@RequestMapping("/updatePositionImg")
	public void updataPositionImg(JhddPositionimg positionImg) {
		positionImgService.updateImg(positionImg);

	}

	@RequestMapping("/selectPositionImg")
	public JhddPositionimg selectPositionImg(Integer roomId) {
		JhddPositionimg jhddPositionimg = positionImgService.selectByRoomId(roomId);
		return jhddPositionimg;

	}

}
