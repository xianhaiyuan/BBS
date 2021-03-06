package com.lny.bbs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lny.bbs.pojo.Comment;
import com.lny.bbs.pojo.CommentVo;
import com.lny.bbs.pojo.PageBean;
import com.lny.bbs.service.CommentService;
import com.lny.bbs.service.PageService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private PageService<CommentVo> commentPageService;
	
	@RequestMapping(value="/addComment/post",method={RequestMethod.POST})
	public @ResponseBody Integer addComment(Comment comment) throws IllegalStateException, IOException {
		return commentService.addComment(comment);
	}
	@RequestMapping(value="/commentPageByAid/get",method= {RequestMethod.GET})
	public @ResponseBody PageBean<CommentVo> commentPageByAid(Integer aid, Integer currentPage){
		commentPageService.setPageBeanTotalCount(commentService.getCommentCountByAid(aid));
		commentPageService.initCommentPageQueryVo(currentPage,8);
		commentPageService.setPageBeanData(commentService.getCommentPageByAid(commentPageService.getPageQueryVo(),aid));
		return commentPageService.getPageBean();
	}
	@RequestMapping(value="/commentPageByUid/get",method= {RequestMethod.GET})
	public @ResponseBody PageBean<CommentVo> commentPageByUid(Integer uid, Integer currentPage){
		commentPageService.setPageBeanTotalCount(commentService.getCommentCountByUid(uid));
		commentPageService.initCommentPageQueryVo(currentPage,8);
		commentPageService.setPageBeanData(commentService.getCommentPageByUid(commentPageService.getPageQueryVo(),uid));
		return commentPageService.getPageBean();
	}
	@RequestMapping(value="/commentPraise/post",method={RequestMethod.POST})
	public @ResponseBody Integer commentPraise(Integer id) throws IllegalStateException, IOException {
		return commentService.changeCommentPraise(id);
	}
	@RequestMapping(value="/commentBlame/post",method={RequestMethod.POST})
	public @ResponseBody Integer commentBlame(Integer id) throws IllegalStateException, IOException {
		return commentService.changeCommentBlame(id);
	}
	@RequestMapping(value="/removeCommentById/post",method={RequestMethod.POST})
	public @ResponseBody Integer removeCommentById(Comment comment) throws IllegalStateException, IOException {
		return commentService.removeCommentById(comment);
	}
}
