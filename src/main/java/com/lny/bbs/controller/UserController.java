package com.lny.bbs.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@RequestMapping(value="/user",method= {RequestMethod.POST})
	public @ResponseBody User findUserById(Integer id,MultipartFile picFile,Model model) throws IllegalStateException, IOException {
		User user = userService.findUserById(id);
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(picFile.getOriginalFilename());
		picFile.transferTo(new File("H:\\upload\\" + name +"."+ ext));
		System.out.println(id);
		System.out.println(user);
		return user;
	}
	@RequestMapping(value="/user1")
	public @ResponseBody User findUserById_1(Integer id) {
		User user = userService.findUserById(id);
		System.out.println(id);
		System.out.println(user);
//		test
		return user;
	}
}
