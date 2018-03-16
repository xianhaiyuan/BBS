package com.lny.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lny.bbs.dao.SectionMapper;
import com.lny.bbs.dao.UserMapper;
import com.lny.bbs.pojo.User;
import com.lny.bbs.pojo.UserSectionVo;
import com.lny.bbs.pojo.pageQueryVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper UserMapper;
	@Autowired
	private SectionMapper sectionMapper;
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
		sectionMapper.updateOldPosition(id);
		return UserMapper.updateUserPosition(id, position);
	}
	public Integer changeUserPositionSection(Integer id, String sec_name, String position) {
		sectionMapper.updateOldPosition(id);
		sectionMapper.updateUserPositionSection(id, sec_name);
		return UserMapper.updateUserPositionSection(id, position);
	}
	public List<User> getUserBanPage(pageQueryVo pageQueryVo) {
		return UserMapper.selectUserBanPage(pageQueryVo);
	}
	public Integer getUserBanCount() {
		return UserMapper.queryUserBanCount();
	}
	public Integer changeUserUnban(Integer id) {
		return UserMapper.updateUserUnban(id);
	}
	public Integer getUserAccuseCount() {
		return UserMapper.queryUserAccuseCount();
	}
	public List<User> getUserAccusePage(pageQueryVo pageQueryVo) {
		return UserMapper.selectUserAccusePage(pageQueryVo);
	}
	public Integer changeUserBan(Integer id) {
		return UserMapper.updateUserBan(id);
	}
	public Integer changeUserAccuse(Integer id) {
		return UserMapper.updateUserAccuse(id);
	}
	public Integer changeUserUnaccuse(Integer id) {
		return UserMapper.updateUserUnaccuse(id);
	}
	public Integer changeUserArticleCountInc(Integer id) {
		return UserMapper.updateUserArticleCountInc(id);
	}
	public Integer changeUserArticleCountDec(Integer id) {
		return UserMapper.updateUserArticleCountDec(id);
	}

}
