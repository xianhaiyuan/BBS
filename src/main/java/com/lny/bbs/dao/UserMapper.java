package com.lny.bbs.dao;
import java.util.List;

import com.lny.bbs.pojo.User;
import com.lny.bbs.pojo.UserSectionVo;
import com.lny.bbs.pojo.pageQueryVo;

public interface UserMapper {

	Integer insertUser(User user);
	User selectUserByUsername_passwd(String username, String passwd);
	Integer updateUserSetting(User user);
	User selectUserById(Integer id);
	void updateOnline(Integer id);
	Integer updateUnOnline(Integer id);
	Integer selectOnlineCount();
	Integer queryUserCount();
	List<UserSectionVo> selectUserSectionPage(pageQueryVo pageQueryVo);
	Integer updateUserPosition(Integer id,String position);
	Integer updateUserPositionSection(Integer id, String sec_name, String position);
}