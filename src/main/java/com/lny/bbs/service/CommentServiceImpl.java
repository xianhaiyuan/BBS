package com.lny.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lny.bbs.dao.CommentMapper;
import com.lny.bbs.pojo.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;

	public Integer addComment(Comment comment) {
		return commentMapper.insertComment(comment);
	}
}
