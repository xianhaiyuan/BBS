package com.lny.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lny.bbs.pojo.Comment;
import com.lny.bbs.pojo.CommentVo;
import com.lny.bbs.pojo.pageQueryVo;

public interface CommentMapper {

	Integer insertComment(Comment comment);

	Integer selectCommentCountByAid(Integer aid);

	List<CommentVo> selectCommentPageByAid(@Param("pageQueryVo")pageQueryVo pageQueryVo, @Param("aid")Integer aid);

	Integer updateCommentPraise(Integer id);

	Integer updateCommentBlame(Integer id);

	Integer selectCommentCountByUid(Integer uid);

	List<CommentVo> selectCommentPageByUid(@Param("pageQueryVo")pageQueryVo pageQueryVo, @Param("uid")Integer uid);

	Integer deleteCommentById(Comment comment);

}
