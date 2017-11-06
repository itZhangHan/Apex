package com.els.WebSockerServer;

import java.io.IOException;
import java.net.URLEncoder;

import com.els.common.AuthUtil;
import com.els.socket.SocketMessage;

public class WxSdkType extends BaseType {

	@Override
	public String onMessage(SocketMessage message) {
		// TODO Auto-generated method stub
		String backUrl = "http://thdd.apexgame.cn/tetris/callback/first";
		System.out.println("1");
		// 回调微信接口
		String authURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtil.APPID
				+ "&redirect_uri=" + URLEncoder.encode(backUrl) + "&response_type=code" + "&scope=snsapi_userinfo"
				+ "&state=STATE#wechat_redirect";
		// 重定向用户请求到微信授权URL
		try {
			AuthUtil.doGetJson(authURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
