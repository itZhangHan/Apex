package com.els.socket;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<SocketMessage>  {
	

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
		JsonObject jsonObject=Json.createObjectBuilder().add("type", message.getType())
        .add("roomId", message.getRoomId())
        .add("toUserName", message.getToUserName())
        .add("fromUserName", message.getFromUserName())
        .add("msgStr", message.getMsgStr())
        .build();
		return jsonObject.toString();
	}

}
