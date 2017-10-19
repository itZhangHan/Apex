package com.els.socket;

import java.io.FileInputStream;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

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
		JsonObject jsonObject = Json.createReader(new StringReader(jsonMessage)).readObject();
		SocketMessage message = new SocketMessage();
		message.setType(jsonObject.getString("type"));
		message.setRoomId(jsonObject.getInt("roomId"));
		message.setToUserName(jsonObject.getString("toUserName"));
		message.setFromUserName(jsonObject.getString("fromUserName"));
		message.setMsgStr(jsonObject.getString("msgStr"));
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
			System.out.println("MessageDecoder == willDecode");
			return true;
		} catch (Exception e) {
			System.out.println("MessageDecoder == Exception");
			return false;
		}
	}

}
