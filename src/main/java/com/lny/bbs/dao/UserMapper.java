package com.lny.bbs.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lny.bbs.pojo.User;

public interface UserMapper {

	public Integer insertUser(User user);
	public User selectUserByUsername_passwd(String username, String passwd);
	public Integer updateUserSetting(User user);
	public User selectUserById(Integer id);
	public void updateOnline(Integer id);
	public Integer updateUnOnline(Integer id);
}