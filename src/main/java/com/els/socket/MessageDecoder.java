package com.els.socket;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import net.sf.json.JSONObject;

public class MessageDecoder implements Decoder.Text<SocketMessage> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public SocketMessage decode(String jsonMessage) throws DecodeException {
		//获取数据
		// TODO Auto-generated method stub
		System.out.println("MessageDecoder == decode"+jsonMessage);
		JSONObject object = JSONObject.fromObject(jsonMessage);
		//此方法错误  noFoundClassEroor : javax/json/json 狗屎异常
		//JsonObject jsonObject = Json.createReader(new StringReader(jsonMessage)).readObject();
		SocketMessage message = new SocketMessage();
		message.setType(object.getString("type"));
		message.setRoomId(object.getString("roomId"));
		message.setToUserName(object.getString("toUserName"));
		message.setFromUserName(object.getString("fromUserName"));
		message.setMsgStr(object.getString("msgStr"));
		System.out.println(message.toString());
		return message;
	}		

	@Override
	public boolean willDecode(String jsonMessage) {
		//接收前端json数据 解析
		try {
			System.out.println("接收前端数据");
			JSONObject.fromObject(jsonMessage);
			return true;
		} catch (Exception e) {
			System.out.println("MessageDecoder == Exception");
			return false;
		}
	}

}
