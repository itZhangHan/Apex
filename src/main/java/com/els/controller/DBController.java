package com.els.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.els.bean.JhddPositionimg;
import com.els.service.PositionImgServiceImpl;
import com.els.serviceinterface.PositionImgService;

@Controller
public class DBController {

	@Autowired
	private static PositionImgServiceImpl positionImgService;
	
	public PositionImgServiceImpl getPositionImgService() {
		return positionImgService;
	}

	public void setPositionImgService(PositionImgServiceImpl positionImgService) {
		this.positionImgService = positionImgService;
	}

	@RequestMapping
	public void addPositionImg(JhddPositionimg positionImg){
		
		
	}
	
}
