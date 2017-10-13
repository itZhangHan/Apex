package com.els.serviceinterface;

import com.els.common.ElsResult;

public interface RoomService {

	public ElsResult createRoom(Integer userid,Integer romeid);

	public ElsResult joinRoom(Integer userid, Integer roomid);

}
