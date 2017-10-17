package com.els.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

	@RequestMapping("/index1")
	public String toIndex() {
		
		return "index";
	}
}