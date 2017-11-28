package com.els.getSign;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;
import com.els.common.AuthUtil;

public class GetAccess_token {

	 public static String getAccess_token() {
	        String APP_ID = AuthUtil.APPID;//微信id
	        String APP_SECRET=AuthUtil.APPSECRET;//微信秘钥
	        //微信令牌请求网址(由微信提供)
	        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APP_ID + "&secret=" + APP_SECRET;
	        String accessToken = null;
	        try {
	            URL urlGet = new URL(url);
	            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
	            http.setRequestMethod("GET"); // 必须是get方式请求
	            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
	            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
	            http.connect();
	            InputStream is = http.getInputStream();
	            int size = is.available();
	            byte[] jsonBytes = new byte[size];
	            is.read(jsonBytes);
	            String message = new String(jsonBytes, "UTF-8");
	            JSONObject demoJson = JSONObject.parseObject(message);//new JSONObject(message);
	            accessToken = demoJson.getString("access_token");
	            is.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return accessToken;
	    }
}
