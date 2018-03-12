package com.lny.bbs.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lny.bbs.pojo.User;

public interface UserMapper {

	public Integer insertUser(User user);
	public User getUser(Map<String ,Object> map);
}