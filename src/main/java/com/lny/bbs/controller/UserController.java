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
	public @ResponseBody Integer unLogin(Integer id) throws IllegalStateException, IOException {
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
	public @ResponseBody User UserSettingAvatar(User user,MultipartFile picFile) throws IllegalStateException, IOException {
		String picDirectory = "C:\\Users\\Administrator\\Desktop\\vuejs学习\\lny_bbs\\static\\avatar\\";
		String oldFileName = user.getAvatar().split("/")[3];
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
	public @ResponseBody User UserSetting(User user) throws IllegalStateException, IOException {
		if (userService.changeUserSetting(user) > 0) {
			return userService.getUserById(user.getId());
		}
		return null;
	}
	
	@RequestMapping(value="/onlineCount/get",method= {RequestMethod.GET})
	public @ResponseBody Integer onlineCount() throws IllegalStateException, IOException {
		return userService.getOnlineCount();
	}
	
//	@RequestMapping(value="/testSession/get",method= {RequestMethod.GET})
//	public @ResponseBody Integer testSession(HttpSession session) throws IllegalStateException, IOException {
//		System.out.println(session.getAttribute("user"));
//		return 1;
//	}
	
//	@RequestMapping(value="/user",method= {RequestMethod.POST})
//	public @ResponseBody User findUserById(Integer id,MultipartFile picFile,Model model) throws IllegalStateException, IOException {
//		User user = userService.findUserById(id);
//		String name = UUID.randomUUID().toString().replaceAll("-", "");
//		String ext = FilenameUtils.getExtension(picFile.getOriginalFilename());
//		picFile.transferTo(new File("H:\\upload\\" + name +"."+ ext));
//		System.out.println(id);
//		System.out.println(user);
//		return user;
//	}

//	@RequestMapping(value="/login/post", method= {RequestMethod.POST})
//	public @ResponseBody String login(String username, String pass, HttpSession session) {
////		session.setAttribute("SESSION_USER", user);
//		System.out.println(username+","+pass);
////		return User;
//		return "yes";
//	}
}
