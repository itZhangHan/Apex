package com.els.serviceinterface;

import com.els.bean.JhddPositionimg;

public interface PositionImgService {
	//新增玩家信息
	public void addImg(JhddPositionimg positionImgs);
	//更新数据库数据
	public void updateImg(JhddPositionimg positionImgs);
	//根据房间id查询数据
	public JhddPositionimg selectByRoomId(Integer roomId);
}
