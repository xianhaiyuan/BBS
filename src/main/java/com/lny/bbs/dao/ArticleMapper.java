package com.lny.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lny.bbs.pojo.Article;
import com.lny.bbs.pojo.pageQueryVo;

public interface ArticleMapper {

	Integer queryArticleCountBySid(Integer sid);

	List<Article> selectArticlePageBySid(@Param("pageQueryVo")pageQueryVo pageQueryVo, @Param("sid")Integer sid);

	Integer deleteArticlePageById(Integer id);

	Integer updateArticle(Article article);

	Integer queryArticleCountByUid(Integer uid);

	List<Article> selectArticlePageByUid(@Param("pageQueryVo")pageQueryVo pageQueryVo, @Param("uid")Integer uid);

	Integer queryArticleCountByStar(Integer uid);

	List<Article> selectArticlePageByStar(@Param("pageQueryVo")pageQueryVo pageQueryVo, @Param("uid")Integer uid);

	Integer deleteArticleByStar(Integer uid, Integer aid);

}
