package com.els.getSign;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

public class GetTicket {
	 public static String getTicket(String access_token) {
		 	access_token = GetAccess_token.getAccess_token();
	        String ticket = null;
	        //获取票据的网址(由微信提供)
	        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + access_token + "&type=jsapi";
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
	            JSONObject demoJson =JSONObject.parseObject(message);// new JSONObject(message);
	            ticket = demoJson.getString("ticket");
	            is.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ticket;
	    }
}
