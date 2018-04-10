package com.lny.bbs.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.lny.bbs.pojo.PageBean;
import com.lny.bbs.pojo.User;
import com.lny.bbs.pojo.UserSectionVo;
import com.lny.bbs.service.SectionService;
import com.lny.bbs.service.UserService;
import com.lny.bbs.service.PageService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private SectionService sectionService;
	@Autowired
	private PageService<UserSectionVo> userSectionPageService;
	@Autowired
	private PageService<User> userPageService;
	
	
	@RequestMapping(value="/signUp/post",method={RequestMethod.POST})
	public @ResponseBody Integer signUp(User user) throws IllegalStateException, IOException {
		return userService.addUser(user);
	}
	
	@RequestMapping(value="/unLogin/post",method={RequestMethod.POST})
	public @ResponseBody Integer unLogin(Integer id,HttpSession session) throws IllegalStateException, IOException {
		session.removeAttribute("user");
		return userService.setUnOnline(id);
	}
	
	@RequestMapping(value="/login/post",method={RequestMethod.POST})
	public @ResponseBody User login(User userFrom,HttpSession session) throws IllegalStateException, IOException {
		User user = userService.queryUser(userFrom.getUsername(), userFrom.getPasswd()); 
		if(user != null) {
			session.setAttribute("user", user);
			userService.setOnline(user.getId());
			return user;
		}
		return null;
	}
	@RequestMapping(value="/userSettingAvatar/post",method={RequestMethod.POST})
	public @ResponseBody User UserSettingAvatar(User user,HttpSession session,MultipartFile picFile) throws IllegalStateException, IOException {
		if(session.getAttribute("user") == null) {
			user.setId(-1);
			return user;
		}
		String picDirectory = "C:\\Users\\Administrator\\Desktop\\vuejs学习\\lny_bbs\\static\\avatar\\";
		String[] oldFileNameArr = user.getAvatar().split("/");
		String oldFileName = oldFileNameArr[oldFileNameArr.length-1];
		File oldFile = new File(picDirectory + oldFileName);
		if (oldFile.exists()) {
          oldFile.delete();
      }
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(picFile.getOriginalFilename());
		picFile.transferTo(new File(picDirectory + name +"."+ ext));
		user.setAvatar("/static/avatar/"+name +"."+ ext);
		if (userService.changeUserSetting(user) > 0) {
			return userService.getUserById(user.getId());
		}
		return null;
	}
	
	@RequestMapping(value="/userSetting/post",method={RequestMethod.POST})
	public @ResponseBody User userSetting(User user,HttpSession session) throws IllegalStateException, IOException {
		if(session.getAttribute("user") == null) {
			user.setId(-1);
			return user;
		}
		if (userService.changeUserSetting(user) > 0) {
			return userService.getUserById(user.getId());
		}
		return null;
	}
	
	@RequestMapping(value="/onlineCount/get",method={RequestMethod.GET})
	public @ResponseBody Integer onlineCount() throws IllegalStateException, IOException {
		return userService.getOnlineCount();
	}
	
	@RequestMapping(value="/userSectionPage/get",method={RequestMethod.GET})
	public @ResponseBody PageBean<UserSectionVo> userSectionPage(Integer currentPage) throws IllegalStateException, IOException {	
		userSectionPageService.setPageBeanTotalCount(userService.getUserCount());
		userSectionPageService.initPageQueryVo(currentPage);
		userSectionPageService.setPageBeanData(userService.getUserSectionPage(userSectionPageService.getPageQueryVo()));
		return userSectionPageService.getPageBean();
	}
	
	@RequestMapping(value="/changeUserPosition/post",method={RequestMethod.POST})
	public @ResponseBody Integer changeUserPosition(Integer id,String position) throws IllegalStateException, IOException {	
		return userService.changeUserPosition(id, position);
	}
	@RequestMapping(value="/changeUserPositionSection/post",method={RequestMethod.POST})
	public @ResponseBody Integer changeUserPositionSection(Integer id,String position, String sec_name) throws IllegalStateException, IOException {	
		if (sectionService.querySectionByName(sec_name) > 0) {
			return userService.changeUserPositionSection(id, sec_name ,position);
		}		
		return -1;
	}
	@RequestMapping(value="/userBanPage/get",method={RequestMethod.GET})
	public @ResponseBody PageBean<User> userBanPage(Integer currentPage) throws IllegalStateException, IOException {	
		userPageService.setPageBeanTotalCount(userService.getUserBanCount());
		userPageService.initPageQueryVo(currentPage);
		userPageService.setPageBeanData(userService.getUserBanPage(userPageService.getPageQueryVo()));
		return userPageService.getPageBean();
	}
	@RequestMapping(value="/unBanUser/post",method={RequestMethod.POST})
	public @ResponseBody Integer unBanUser(Integer id) throws IllegalStateException, IOException {	
		return userService.changeUserUnban(id);
	}
	@RequestMapping(value="/banUser/post",method={RequestMethod.POST})
	public @ResponseBody Integer banUser(Integer id) throws IllegalStateException, IOException {	
		return userService.changeUserBan(id);
	}
	@RequestMapping(value="/userAccusePage/get",method={RequestMethod.GET})
	public @ResponseBody PageBean<User> userAccusePage(Integer currentPage) throws IllegalStateException, IOException {	
		userPageService.setPageBeanTotalCount(userService.getUserAccuseCount());
		userPageService.initPageQueryVo(currentPage);
		userPageService.setPageBeanData(userService.getUserAccusePage(userPageService.getPageQueryVo()));
		return userPageService.getPageBean();
	}
	@RequestMapping(value="/accuseUser/post",method={RequestMethod.POST})
	public @ResponseBody Integer accuseUser(Integer id) throws IllegalStateException, IOException {	
		return userService.changeUserAccuse(id);
	}
	@RequestMapping(value="/UnaccuseUser/post",method={RequestMethod.POST})
	public @ResponseBody Integer UnaccuseUser(Integer id) throws IllegalStateException, IOException {	
		return userService.changeUserUnaccuse(id);
	}
	@RequestMapping(value="/userById/get",method={RequestMethod.GET})
	public @ResponseBody User userById(Integer id) throws IllegalStateException, IOException {	
		return userService.getUserById(id);
	}
	@RequestMapping(value="/checkOnline/get",method={RequestMethod.GET})
	public @ResponseBody Integer checkOnline(Integer id) throws IllegalStateException, IOException {	
		return userService.checkOnline(id);
	}
}
