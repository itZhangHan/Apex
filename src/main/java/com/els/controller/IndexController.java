package com.els.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.common.HomeResult;
import com.els.service.HomeService;

@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private HomeService sc;

	@RequestMapping(value = "/getTransfer", method = RequestMethod.GET)
	@ResponseBody
	public HomeResult getTransfer(@RequestParam(value = "uid", defaultValue = "0") Integer uid,
			@RequestParam(value = "hid", defaultValue = "0") Integer hid, String callback) {
		System.out.println(uid);
		System.out.println(hid);
		// 判断房间是否等于空
		HomeResult homeResult = sc.inOrCreateHome(uid, hid);
		return homeResult;
	}

}
