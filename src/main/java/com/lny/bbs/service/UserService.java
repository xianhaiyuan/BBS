package com.lny.bbs.service;

import java.util.Map;

import com.lny.bbs.pojo.User;

public interface UserService {
	public Integer insertUser(User user);
	public User getUser(Map<String ,Object> map);
}
