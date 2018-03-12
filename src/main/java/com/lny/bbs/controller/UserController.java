package com.lny.bbs.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
		ServletContext context = session.getServletContext();  
        int lineCount = (Integer) context.getAttribute("lineCount");  
        context.setAttribute("lineCount", lineCount - 1);  
        HashSet<HttpSession> sessionSet = (HashSet<HttpSession>) context.getAttribute("sessionSet");  
        if(sessionSet!=null){  
            sessionSet.remove(session);
        } 
		return userService.setUnOnline(id);
	}
	
	@RequestMapping(value="/login/post",method= {RequestMethod.POST})
	public @ResponseBody User login(String username, String passwd,HttpSession session) throws IllegalStateException, IOException {
		User user = userService.queryUser(username, passwd);
		if(user!=null){
            session.setAttribute("username", user.getUsername());  //将用户名存入session  
            ServletContext context = session.getServletContext();  
            //打印在线人数  
            System.out.println("在线人数："+context.getAttribute("lineCount"));
        }  
		userService.setOnline(user.getId());
        //打印在线人数  
		return user;
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
		System.out.println("no pic");
		if (userService.changeUserSetting(user) > 0) {
			return userService.getUserById(user.getId());
		}
		return null;
	}
	
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
