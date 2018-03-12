package com.lny.bbs.service;

import java.util.Map;

import com.lny.bbs.pojo.User;

public interface UserService {
	public Integer addUser(User user);
	public User queryUser(String username, String passwd);
	public Integer changeUserSetting(User user);
	public User getUserById(Integer id);
	public void setOnline(Integer id);
	public Integer setUnOnline(Integer id);
}
