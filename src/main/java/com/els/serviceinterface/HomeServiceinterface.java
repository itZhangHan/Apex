package com.els.serviceinterface;

import org.springframework.stereotype.Service;

import com.els.bean.HomeResult;
@Service
public interface HomeServiceinterface {

	public HomeResult inOrCreateHome(Integer uid, Integer hid);
}
