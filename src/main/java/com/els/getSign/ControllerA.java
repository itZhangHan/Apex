package com.els.getSign;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/test")
public class ControllerA {

	@RequestMapping(value="/toA")
	public String toA(){
		
		return "a";
	}
}
