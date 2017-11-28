package com.els.wxutil;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.common.AuthUtil;

@Controller
@RequestMapping("/weixin")
public class GetShareController {

		@RequestMapping(value = "/share", method = RequestMethod.POST)
	    @ResponseBody
	    //将签名转换成json格式传回前端
	    public Map<String, Object> share(HttpServletRequest request) {
	        String urlTemp = "http://" + request.getServerName() + request.getContextPath();
	        String urlpath = "http://" + request.getServerName();
	        String appUrl = request.getParameter("url");
	        if (request.getParameter("code") != null) {
	            appUrl += "&code=" + request.getParameter("code");
	        }
	        if (request.getParameter("state") != null) {
	            appUrl += "&state=" + request.getParameter("state");
	        }
	        return WxConfigUtil.getSignature(appUrl, AuthUtil.APPID, AuthUtil.APPSECRET, urlTemp, urlpath);
	    }
	
}
