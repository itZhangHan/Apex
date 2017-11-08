package com.els.socket;

import javax.websocket.EncodeException;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.alibaba.fastjson.JSON;

public class MessageEncoder implements Encoder.Text<SocketMessage> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public String encode(SocketMessage message) throws EncodeException {
		// TODO Auto-generated method stub
		// json编码
		System.out.println("进入json编码方法");
		String jsonString = JSON.toJSONString(message);
		
		System.out.println("转换成功："+jsonString);
		return JSON.toJSONString(jsonString);
	}

}
