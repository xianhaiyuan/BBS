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

}
