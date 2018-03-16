package com.lny.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lny.bbs.pojo.Article;
import com.lny.bbs.pojo.ArticleVo;
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
	@RequestMapping(value="/removeArticleById/post",method= {RequestMethod.POST})
	public @ResponseBody Integer removeArticlePageById(Article article){
		return articleService.removeArticlePageById(article);
	}
	@RequestMapping(value="/changeArticle/post",method= {RequestMethod.POST})
	public @ResponseBody Integer changeArticle(Article article){
		return articleService.changeArticle(article);
	}
	@RequestMapping(value="/articlePageByUid/get",method= {RequestMethod.GET})
	public @ResponseBody PageBean<Article> articlePageByUid(Integer uid, Integer currentPage){
		articlePageService.setPageBeanTotalCount(articleService.getArticleCountByUid(uid));
		articlePageService.initPageQueryVo(currentPage);
		articlePageService.setPageBeanData(articleService.getArticlePageByUid(articlePageService.getPageQueryVo(),uid));
		return articlePageService.getPageBean();
	}
	@RequestMapping(value="/articlePageByStar/get",method= {RequestMethod.GET})
	public @ResponseBody PageBean<Article> articlePageByStar(Integer uid, Integer currentPage){
		articlePageService.setPageBeanTotalCount(articleService.getArticleCountByStar(uid));
		articlePageService.initPageQueryVo(currentPage);
		articlePageService.setPageBeanData(articleService.getArticlePageByStar(articlePageService.getPageQueryVo(),uid));
		return articlePageService.getPageBean();
	}
	@RequestMapping(value="/removeArticleByStar/post",method= {RequestMethod.POST})
	public @ResponseBody Integer removeArticleByStar(Integer uid, Integer aid){
		return articleService.removeArticleByStar(uid, aid);
	}
	@RequestMapping(value="/addArticleStar/post",method= {RequestMethod.POST})
	public @ResponseBody Integer addArticleStar(Integer uid, Integer aid){
		return articleService.addArticleStar(uid, aid);
	}
	@RequestMapping(value="/addArticle/post",method= {RequestMethod.POST})
	public @ResponseBody Integer addArticle(Article article){
		return articleService.addArticle(article);
	}
	@RequestMapping(value="/articleBySidAid/get",method= {RequestMethod.GET})
	public @ResponseBody ArticleVo articleBySidAid(Integer sid, Integer aid){
		return articleService.getArticleBySidAid(sid,aid);
	}
}
