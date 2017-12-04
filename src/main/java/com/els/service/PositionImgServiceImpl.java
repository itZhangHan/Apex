package com.els.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.bean.JhddPositionimg;
import com.els.mapper.JhddPositionimgMapper;
import com.els.serviceinterface.PositionImgService;
@Transactional
@Service("positionImgService")
public class PositionImgServiceImpl implements PositionImgService{

	@Autowired
	private JhddPositionimgMapper jhddPositionimgMapper;
	

	@Override
	public void addImg(JhddPositionimg positionImgs) {
		// TODO Auto-generated method stub

		jhddPositionimgMapper.insert(positionImgs);
	}

	@Override
	public void updateImg(JhddPositionimg positionImgs) {
		// TODO Auto-generated method stub
		jhddPositionimgMapper.updateByPrimaryKeySelective(positionImgs);
	}


	@Override
	public JhddPositionimg selectByRoomId(Integer roomId){
		
		JhddPositionimg jhddPositionimg = jhddPositionimgMapper.selectByRoomId(roomId);
		
		return jhddPositionimg;
	}

}
