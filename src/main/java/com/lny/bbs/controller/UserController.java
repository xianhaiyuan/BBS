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
import com.lny.bbs.pojo.User;
import com.lny.bbs.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/signUp/post",method= {RequestMethod.POST})
	public @ResponseBody Integer signUp(User user) throws IllegalStateException, IOException {
		return userService.addUser(user);
	}
	
	@RequestMapping(value="/unLogin/post",method= {RequestMethod.POST})
	public @ResponseBody Integer unLogin(Integer id,HttpSession session) throws IllegalStateException, IOException {
		session.removeAttribute("user");
		return userService.setUnOnline(id);
	}
	
	@RequestMapping(value="/login/post",method= {RequestMethod.POST})
	public @ResponseBody User login(String username, String passwd,HttpSession session) throws IllegalStateException, IOException {
		User user = userService.queryUser(username, passwd); 
		if(user != null) {
			session.setAttribute("user", user);
			userService.setOnline(user.getId());
			return user;
		}
		return null;
	}
	@RequestMapping(value="/userSettingAvatar/post",method= {RequestMethod.POST})
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
	
	@RequestMapping(value="/userSetting/post",method= {RequestMethod.POST})
	public @ResponseBody User UserSetting(User user,HttpSession session) throws IllegalStateException, IOException {
		if(session.getAttribute("user") == null) {
			user.setId(-1);
			return user;
		}
		if (userService.changeUserSetting(user) > 0) {
			return userService.getUserById(user.getId());
		}
		return null;
	}
	
	@RequestMapping(value="/onlineCount/get",method= {RequestMethod.GET})
	public @ResponseBody Integer onlineCount() throws IllegalStateException, IOException {
		return userService.getOnlineCount();
	}
	
}
