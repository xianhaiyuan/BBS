package com.lny.bbs.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	Integer updateUserPositionSection(Integer id, String position);
	List<User> selectUserBanPage(pageQueryVo pageQueryVo);
	Integer queryUserBanCount();
	Integer updateUserUnban(Integer id);
	Integer queryUserAccuseCount();
	List<User> selectUserAccusePage(pageQueryVo pageQueryVo);
	Integer updateUserBan(Integer id);
	Integer updateUserAccuse(Integer id);
	Integer updateUserUnaccuse(Integer id);
	Integer updateUserArticleCountInc(Integer id);
	Integer updateUserArticleCountDec(Integer id);
	Integer checkOnline(Integer id);
	Integer queryFriend(Integer uid, Integer fid);
	Integer insertFriend(Integer uid, Integer fid);
	Integer deleteFriend(Integer uid, Integer fid);
	Integer queryFriendCountByUid(Integer uid);
	List<User> selectFriendPageByUid(@Param("pageQueryVo")pageQueryVo pageQueryVo, @Param("uid")Integer uid);
}