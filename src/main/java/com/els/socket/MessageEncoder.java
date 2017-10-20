package com.els.socket;

import javax.jms.Message;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import net.sf.json.JSONObject;

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
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		jsonBuilder.add("type", message.getType()).add("roomId", message.getRoomId())
				.add("toUserName", message.getToUserName()).add("fromUserName", message.getFromUserName())
				.add("msgStr", message.getMsgStr()).build();
		System.out.println("进入返回json");
		return jsonBuilder.toString();
	}

}
