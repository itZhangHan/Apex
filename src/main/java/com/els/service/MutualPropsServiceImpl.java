package com.els.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.bean.JhddPropsRecords;
import com.els.mapper.JhddPropsRecordsMapper;
import com.els.serviceinterface.MutualPropsService;

@Transactional
@Service("mutualPropsService")
public class MutualPropsServiceImpl implements MutualPropsService{

	@Autowired
	private JhddPropsRecordsMapper jhddPropsRecordsMapper;
	
	@Override
	public void addPropsRecords(JhddPropsRecords propsRecords) {
		// TODO Auto-generated method stub
		jhddPropsRecordsMapper.insert(propsRecords);
	}

	@Override
	public void updatePropsRecords(JhddPropsRecords propsRecords) {
		// TODO Auto-generated method stub
		jhddPropsRecordsMapper.updateByPrimaryKeySelective(propsRecords);
	}

	@Override
	public JhddPropsRecords selectPropsRecords(Integer roomId) {
		// TODO Auto-generated method stub
	JhddPropsRecords propsRecords=	jhddPropsRecordsMapper.selectByRoomId(roomId);
		return propsRecords;
	}

}
