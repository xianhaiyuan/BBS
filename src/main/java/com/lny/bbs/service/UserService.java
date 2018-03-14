package com.lny.bbs.service;
import com.lny.bbs.pojo.User;

public interface UserService {
	 Integer addUser(User user);
	 User queryUser(String username, String passwd);
	 Integer changeUserSetting(User user);
	 User getUserById(Integer id);
	 void setOnline(Integer id);
	 Integer setUnOnline(Integer id);
	 Integer getOnlineCount();
}
