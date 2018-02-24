package com.lny.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lny.bbs.dao.UserMapper;
import com.lny.bbs.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper UserMapper;
	public User findUserById(Integer id) {
		return UserMapper.selectByUserId(id);
	}

}
