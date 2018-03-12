package com.lny.bbs.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lny.bbs.dao.UserMapper;
import com.lny.bbs.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper UserMapper;
	public Integer insertUser(User user) {
		return UserMapper.insertUser(user);
	}
	public User getUser(Map<String ,Object> map) {
		return UserMapper.getUser(map);
	}

}
