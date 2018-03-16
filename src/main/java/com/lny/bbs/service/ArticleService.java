package com.lny.bbs.service;

import java.util.List;

import com.lny.bbs.pojo.Article;
import com.lny.bbs.pojo.ArticleVo;
import com.lny.bbs.pojo.pageQueryVo;

public interface ArticleService {

	Integer getArticleCountBySid(Integer sid);

	List<Article> getArticlePageBySid(pageQueryVo pageQueryVo, Integer sid);

	Integer removeArticlePageById(Article article);

	Integer changeArticle(Article article);

	Integer getArticleCountByUid(Integer uid);

	List<Article> getArticlePageByUid(pageQueryVo pageQueryVo, Integer uid);

	Integer getArticleCountByStar(Integer uid);

	List<Article> getArticlePageByStar(pageQueryVo pageQueryVo, Integer uid);

	Integer removeArticleByStar(Integer uid, Integer aid);

	Integer addArticle(Article article);

	ArticleVo getArticleBySidAid(Integer sid, Integer aid);

	Integer addArticleStar(Integer uid, Integer aid);

}
