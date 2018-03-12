package com.lny.bbs.service;

import com.lny.bbs.pojo.User;

public interface UserService {
	public Integer insertUser(User user);
	public User getUser(String username, String passwd);
}
