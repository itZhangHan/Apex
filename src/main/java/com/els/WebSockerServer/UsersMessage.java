package com.els.WebSockerServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import com.els.common.SocketUsers;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

public class UsersMessage extends BaseType {
    

	public String onMessage(SocketMessage message){
		CopyOnWriteArraySet<WebSocketServer> arrayset = SocketManger.getRoomArray(message.getRoomId());
		 List<SocketUsers> list=new ArrayList<SocketUsers>();
		 Session userWebSocket=null;
		for (WebSocketServer object : arrayset) {
			try {
			    if(message!=null){
			    	if(message.getSocketUser()!=null){
			    		if( message.getSocketUser().getUserid()==object.getSocketUser().getUserid()){			    			
			    			userWebSocket=object.getSession();
			    		}
			    		list.add(message.getSocketUser());
			    	}
			    }
				object.getSession().getBasicRemote().sendObject(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EncodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		try {
			if(message!=null)
			message.setListUsers(list);
			if(userWebSocket!=null)
			userWebSocket.getBasicRemote().sendObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
