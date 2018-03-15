package com.lny.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lny.bbs.pojo.Article;
import com.lny.bbs.pojo.PageBean;
import com.lny.bbs.service.ArticleService;
import com.lny.bbs.service.PageService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private PageService<Article> articlePageService;
	
	@RequestMapping(value="/articlePageBySid/get",method= {RequestMethod.GET})
	public @ResponseBody PageBean<Article> articlePageBySid(Integer sid, Integer currentPage){
		articlePageService.setPageBeanTotalCount(articleService.getArticleCountBySid(sid));
		articlePageService.initPageQueryVo(currentPage);
		articlePageService.setPageBeanData(articleService.getArticlePageBySid(articlePageService.getPageQueryVo(),sid));
		return articlePageService.getPageBean();
	}
	@RequestMapping(value="/removeArticlePageById/post",method= {RequestMethod.POST})
	public @ResponseBody Integer removeArticlePageById(Integer id){
		return articleService.removeArticlePageById(id);
	}
	@RequestMapping(value="/changeArticlePage/post",method= {RequestMethod.POST})
	public @ResponseBody Integer changeArticle(Article article){
		return articleService.changeArticle(article);
	}
}
