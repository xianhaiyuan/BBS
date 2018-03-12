package com.lny.bbs.dao;

import org.apache.ibatis.annotations.Param;

import com.lny.bbs.pojo.User;

public interface UserMapper {

	public Integer insertUser(User user);
	public User getUser(@Param("username")String username, @Param("passwd")String passwd);
}