package com.els.socket;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<SocketMessage>  {

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
		 JsonObject jsonObject = Json
			        .createReader(new StringReader(jsonMessage)).readObject();
		 SocketMessage message = new SocketMessage();
		 message.setType(jsonObject.getString("type"));
		 message.setRoomId(jsonObject.getInt("roomId"));
		 message.setToUserName(jsonObject.getString("toUserName"));
		 message.setFromUserName(jsonObject.getString("fromUserName"));
		 message.setMsgStr(jsonObject.getString("msgStr"));
		return null;
	}

	@Override
	public boolean willDecode(String jsonMessage) {
		try {
		      // Check if incoming message is valid JSON
		      Json.createReader(new StringReader(jsonMessage)).readObject();
		      return true;
		    } catch (Exception e) {
		      return false;
		    }
	}

}
