package com.lny.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lny.bbs.dao.ArticleMapper;
import com.lny.bbs.pojo.Article;
import com.lny.bbs.pojo.pageQueryVo;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	
	public Integer getArticleCountBySid(Integer sid) {
		return articleMapper.queryArticleCountBySid(sid);
	}

	public List<Article> getArticlePageBySid(pageQueryVo pageQueryVo, Integer sid) {
		return articleMapper.selectArticlePageBySid(pageQueryVo, sid);
	}

	public Integer removeArticlePageById(Integer id) {
		return articleMapper.deleteArticlePageById(id);
	}

	public Integer changeArticle(Article article) {
		return articleMapper.updateArticle(article);
	}

	public Integer getArticleCountByUid(Integer uid) {
		return articleMapper.queryArticleCountByUid(uid);
	}

	public List<Article> getArticlePageByUid(pageQueryVo pageQueryVo, Integer uid) {
		return articleMapper.selectArticlePageByUid(pageQueryVo, uid);
	}

	public Integer getArticleCountByStar(Integer uid) {
		return articleMapper.queryArticleCountByStar(uid);
	}

	public List<Article> getArticlePageByStar(pageQueryVo pageQueryVo, Integer uid) {
		return articleMapper.selectArticlePageByStar(pageQueryVo, uid);
	}

	public Integer removeArticleByStar(Integer uid, Integer aid) {
		// TODO Auto-generated method stub
		return articleMapper.deleteArticleByStar(uid,aid);
	}

	public Integer addArticle(Article article) {
		return articleMapper.insertArticle(article);
	}

}
