package com.lny.bbs.service;

import java.util.List;

import com.lny.bbs.pojo.Comment;
import com.lny.bbs.pojo.CommentVo;
import com.lny.bbs.pojo.pageQueryVo;

public interface CommentService {

	Integer addComment(Comment comment);

	Integer getCommentCountByAid(Integer aid);

	List<CommentVo> getCommentPageByAid(pageQueryVo pageQueryVo, Integer aid);

	Integer changeCommentPraise(Integer id);

	Integer changeCommentBlame(Integer id);

	Integer getCommentCountByUid(Integer uid);

	List<CommentVo> getCommentPageByUid(pageQueryVo pageQueryVo, Integer uid);

	Integer removeCommentById(Comment comment);

}
