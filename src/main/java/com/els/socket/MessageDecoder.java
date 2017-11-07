package com.els.socket;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.els.common.SocketUsers;

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
		// 获取数据
		// TODO Auto-generated method stub
		System.out.println("MessageDecoder == decode" + jsonMessage);
		JSONObject object = JSONObject.fromObject(jsonMessage);
		SocketMessage message = new SocketMessage();

		message.setType(object.getString("type"));
		message.setRoomId(object.getString("roomId"));
		message.setToUserName(object.getString("toUserName"));
		message.setFromUserName(object.getString("fromUserName"));
		message.setMsgStr(object.getString("msgStr"));
		message.setUserStatus(object.getString("userStatus"));
		message.setRoomState(object.getString("roomState"));
		message.setPosition(object.getString("position"));
		message.setHeadimgurl(object.getString("headimgurl"));
		SocketUsers socketUser = (SocketUsers) object.get("socketUser");
		message.setSocketUser(socketUser);				 
		System.out.println("获取到信息:" + message);
		return message;

	}

	@Override
	public boolean willDecode(String jsonMessage) {
		// 接收前端json数据 解析
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
