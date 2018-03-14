package com.lny.bbs.dao;
import com.lny.bbs.pojo.User;

public interface UserMapper {

	Integer insertUser(User user);
	User selectUserByUsername_passwd(String username, String passwd);
	Integer updateUserSetting(User user);
	User selectUserById(Integer id);
	void updateOnline(Integer id);
	Integer updateUnOnline(Integer id);
	Integer selectOnlineCount();
}