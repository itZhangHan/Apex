package com.els.serviceinterface;

import com.els.bean.JhddPositionimg;

public interface PositionImgService {

	public void addImg(JhddPositionimg positionImgs);
	
	public void deleteImg(JhddPositionimg positionImgs);
	
	public JhddPositionimg selectImg();
}
