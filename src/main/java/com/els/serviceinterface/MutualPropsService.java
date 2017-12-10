package com.els.serviceinterface;

import com.els.bean.JhddPropsRecords;

public interface MutualPropsService {

	public void addPropsRecords(JhddPropsRecords propsRecords);
	
	public void updatePropsRecords(JhddPropsRecords propsRecords);
	
	public JhddPropsRecords selectPropsRecords(Integer roomId);
}
