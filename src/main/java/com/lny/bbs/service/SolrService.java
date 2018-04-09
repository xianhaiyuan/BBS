package com.lny.bbs.service;

import com.lny.bbs.pojo.Article;
import com.lny.bbs.pojo.PageBean;

public interface SolrService {
	PageBean<Article> getArticlePage(String keyword,int currentPage);
	void removeArticleById(Integer id);
	void removeArticleBySid(Integer sid);
	void addOrUpdateArticle(Article article);
}
