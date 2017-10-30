package com.els.WebSockerServer;

import java.util.HashMap;
import java.util.Map;

public class MessageManger {
	
	private static Map<String,InterfaceType> messType=new HashMap();
	
	static{
		
		messType.put("message",new MessageType());
		
	}

	public static InterfaceType getType(String key){
		if(messType.containsKey(key)){
			return messType.get(key);
		}
		return null;
	}
}
