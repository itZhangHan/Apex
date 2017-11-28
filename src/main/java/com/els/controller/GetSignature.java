package com.els.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.common.WxSignature;

@Controller
@RequestMapping(value="/weixin")
public class GetSignature {

	@RequestMapping(value="/getSignature")
	@ResponseBody
	public WxSignature getSignature(){
		
		return null;
	}
}
