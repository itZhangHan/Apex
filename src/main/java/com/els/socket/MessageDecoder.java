package com.els.socket;

import java.io.FileInputStream;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

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
		// TODO Auto-generated method stub
		System.out.println("MessageDecoder == decode"+jsonMessage);
		JSONObject object = JSONObject.fromObject(jsonMessage);
		//JsonObject jsonObject = Json.createReader(new StringReader(jsonMessage)).readObject();
		SocketMessage message = new SocketMessage();
		message.setType(object.getString("type"));
		message.setRoomId(object.getInt("roomId"));
		message.setToUserName(object.getString("toUserName"));
		message.setFromUserName(object.getString("fromUserName"));
		message.setMsgStr(object.getString("msgStr"));
		return message;
	}

	@Override
	public boolean willDecode(String jsonMessage) {
		try {
			System.out.println(jsonMessage.toString());
			System.getProperty("java.classpath");
			// Check if incoming message is valid JSON
			// String jsonToString = JSONUtils.
			//Json.createReader(new StringReader(jsonMessage)).readObject();
			//Json.createReader(new FileInputStream(jsonMessage.toString())).readObject();
			JSONObject.fromObject(jsonMessage);
			System.out.println("MessageDecoder == willDecode");
			return true;
		} catch (Exception e) {
			System.out.println("MessageDecoder == Exception");
			return false;
		}
	}

}
