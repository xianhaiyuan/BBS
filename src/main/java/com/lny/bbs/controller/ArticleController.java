package com.lny.bbs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lny.bbs.pojo.Article;
import com.lny.bbs.pojo.ArticleVo;
import com.lny.bbs.pojo.PageBean;
import com.lny.bbs.pojo.StarArticle;
import com.lny.bbs.service.ArticleService;
import com.lny.bbs.service.PageService;
import com.lny.bbs.service.SolrService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private PageService<Article> articlePageService;
	@Autowired
	private PageService<StarArticle> starArticlePageService;
	@Autowired
	private SolrService solrService;
	
	
	@RequestMapping(value="/articlePageBySid/get",method= {RequestMethod.GET})
	public @ResponseBody PageBean<Article> articlePageBySid(Integer sid, Integer currentPage){
		articlePageService.setPageBeanTotalCount(articleService.getArticleCountBySid(sid));
		articlePageService.initPageQueryVo(currentPage);
		articlePageService.setPageBeanData(articleService.getArticlePageBySid(articlePageService.getPageQueryVo(),sid));
		return articlePageService.getPageBean();
	}
	@RequestMapping(value="/removeArticleById/post",method= {RequestMethod.POST})
	public @ResponseBody Integer removeArticleById(Article article){
		if(articleService.removeArticleById(article) > 0) {
			solrService.removeArticleById(article.getId());
			return 1;
		}
		return 0;
	}
	@RequestMapping(value="/changeArticle/post",method= {RequestMethod.POST})
	public @ResponseBody Integer changeArticle(Article article){
		if(articleService.changeArticle(article) > 0) {
			solrService.addOrUpdateArticle(article);
			return 1;
		}
		return 0;
	}
	@RequestMapping(value="/articlePageByUid/get",method= {RequestMethod.GET})
	public @ResponseBody PageBean<Article> articlePageByUid(Integer uid, Integer currentPage){
		articlePageService.setPageBeanTotalCount(articleService.getArticleCountByUid(uid));
		articlePageService.initPageQueryVo(currentPage);
		articlePageService.setPageBeanData(articleService.getArticlePageByUid(articlePageService.getPageQueryVo(),uid));
		return articlePageService.getPageBean();
	}
	@RequestMapping(value="/articlePageByStar/get",method= {RequestMethod.GET})
	public @ResponseBody PageBean<StarArticle> articlePageByStar(Integer uid, Integer currentPage){
		starArticlePageService.setPageBeanTotalCount(articleService.getArticleCountByStar(uid));
		starArticlePageService.initPageQueryVo(currentPage);
		starArticlePageService.setPageBeanData(articleService.getArticlePageByStar(starArticlePageService.getPageQueryVo(),uid));
		return starArticlePageService.getPageBean();
	}
	@RequestMapping(value="/removeArticleByStar/post",method= {RequestMethod.POST})
	public @ResponseBody Integer removeArticleByStar(Integer uid, Integer aid){
		return articleService.removeArticleByStar(uid, aid);
	}
	@RequestMapping(value="/addArticleStar/post",method= {RequestMethod.POST})
	public @ResponseBody Integer addArticleStar(Integer uid, Integer aid,String date){
		return articleService.addArticleStar(uid, aid,date);
	}
	@RequestMapping(value="/addArticle/post",method= {RequestMethod.POST})
	public @ResponseBody Integer addArticle(Article article){
		if(articleService.addArticle(article) > 0) {
			solrService.addOrUpdateArticle(article);
			return 1;
		}
		return 0;
	}
	@RequestMapping(value="/articleBySidAid/get",method= {RequestMethod.GET})
	public @ResponseBody ArticleVo articleBySidAid(Integer sid, Integer aid){
		return articleService.getArticleBySidAid(sid,aid);
	}
	
	@RequestMapping(value="/searchArticlePage/get",method= {RequestMethod.GET})
	public @ResponseBody PageBean<Article> searchArticle(String keyword,int currentPage){
		return solrService.getArticlePage(keyword, currentPage);
	}
	
	@RequestMapping(value="/articlePraise/post",method={RequestMethod.POST})
	public @ResponseBody Integer articlePraise(Integer id) throws IllegalStateException, IOException {
		return articleService.changeArticlePraise(id);
	}
	@RequestMapping(value="/articleBlame/post",method={RequestMethod.POST})
	public @ResponseBody Integer articleBlame(Integer id) throws IllegalStateException, IOException {
		return articleService.changeArticleBlame(id);
	}
}
