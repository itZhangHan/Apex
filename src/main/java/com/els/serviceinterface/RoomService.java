package com.els.serviceinterface;

import com.els.bean.JhddSidelines;
import com.els.bean.JhddUsers;
import com.els.common.ElsResult;

public interface RoomService {

	public ElsResult createRoom(Integer userid);

	public ElsResult joinRoom(Integer userid, Integer roomid);

	//public JhddUsers selectUsers(JhddSidelines sidelines);

}
