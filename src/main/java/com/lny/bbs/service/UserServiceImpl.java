package com.lny.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lny.bbs.dao.UserMapper;
import com.lny.bbs.pojo.User;
import com.lny.bbs.pojo.UserSectionVo;
import com.lny.bbs.pojo.pageQueryVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper UserMapper;
	public Integer addUser(User user) {
		return UserMapper.insertUser(user);
	}
	public User queryUser(String username, String passwd) {
		return UserMapper.selectUserByUsername_passwd(username, passwd);
	}
	public Integer changeUserSetting(User user) {
		return UserMapper.updateUserSetting(user);
	}
	public User getUserById(Integer id) {
		return UserMapper.selectUserById(id);
	}
	public void setOnline(Integer id) {
		UserMapper.updateOnline(id);
	}
	public Integer setUnOnline(Integer id) {
		return UserMapper.updateUnOnline(id);
	}
	public Integer getOnlineCount() {
		return UserMapper.selectOnlineCount();
	}
	public Integer getUserCount() {
		return UserMapper.queryUserCount();
	}
	public List<UserSectionVo> getUserSectionPage(pageQueryVo pageQueryVo) {
		return UserMapper.selectUserSectionPage(pageQueryVo);
	}
	public Integer changeUserPosition(Integer id,String position) {
		return UserMapper.updateUserPosition(id, position);
	}
	public Integer changeUserPositionSection(Integer id, String sec_name, String position) {
		return UserMapper.updateUserPositionSection(id, sec_name, position);
	}

}
