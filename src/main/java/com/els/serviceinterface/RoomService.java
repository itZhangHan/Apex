package com.els.serviceinterface;

import com.els.bean.JhddSidelines;
import com.els.common.ElsResult;

public interface RoomService {

	public JhddSidelines createRoom(Integer userid);

	public ElsResult joinRoom(Integer roomid);

	//public JhddUsers selectUsers(JhddSidelines sidelines);

}
