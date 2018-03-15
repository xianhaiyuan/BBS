package com.lny.bbs.service;
import java.util.List;

import com.lny.bbs.pojo.User;
import com.lny.bbs.pojo.UserSectionVo;
import com.lny.bbs.pojo.pageQueryVo;

public interface UserService {
	Integer addUser(User user);
	User queryUser(String username, String passwd);
	Integer changeUserSetting(User user);
	User getUserById(Integer id);
	void setOnline(Integer id);
	Integer setUnOnline(Integer id);
	Integer getOnlineCount();
	Integer getUserCount();
	List<UserSectionVo> getUserSectionPage(pageQueryVo pageQueryVo);
	Integer changeUserPosition(Integer id,String position);
	Integer changeUserPositionSection(Integer id ,String sec_name,String position);
	List<User> getUserBanPage(pageQueryVo pageQueryVo);
	Integer getUserBanCount();
	Integer changeUserUnban(Integer id);
	Integer getUserAccuseCount();
	List<User> getUserAccusePage(pageQueryVo pageQueryVo);
	Integer changeUserBan(Integer id);
	Integer changeUserAccuse(Integer id);
	Integer changeUserUnaccuse(Integer id);
}
