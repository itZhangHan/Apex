package com.els.serviceinterface;

import com.els.bean.JhddUsers;
import com.els.common.UserResult;

public interface UserService {

	public UserResult addUser(JhddUsers user);

	public UserResult findUserById(Integer userid);

	public UserResult findUserList();
}
