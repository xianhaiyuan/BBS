package com.lny.bbs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lny.bbs.pojo.Comment;
import com.lny.bbs.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	@RequestMapping(value="/addComment/post",method={RequestMethod.POST})
	public @ResponseBody Integer addComment(Comment comment) throws IllegalStateException, IOException {
		return commentService.addComment(comment);
	}
}
