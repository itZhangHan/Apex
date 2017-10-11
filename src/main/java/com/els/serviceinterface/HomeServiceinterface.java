package com.els.serviceinterface;

import org.springframework.stereotype.Service;

import com.els.common.HomeResult;
@Service
public interface HomeServiceinterface {

	public HomeResult inOrCreateHome(Integer uid, Integer hid);
}
