package com.lny.bbs.controller;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
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
	@Autowired
	private HttpSolrServer httpSolrServer;
	
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
	
	@RequestMapping(value="/searchArticlePage/get",method= {RequestMethod.GET})
	public @ResponseBody PageBean<Article> searchArticle(String keyword,int currentPage){
		SolrQuery query = new SolrQuery();
		PageBean<Article> pageBean = new PageBean<Article>();
		query.setQuery("article_keywords:"+keyword);
		try {
			QueryResponse queryTotal = httpSolrServer.query(query);
			SolrDocumentList results = queryTotal.getResults();
			Integer total = (int) results.getNumFound();
			pageBean.setTotalCount(total);
			pageBean.setCurrentPage(currentPage);
		} catch (SolrServerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		query.addSort("article_date",ORDER.desc);
		query.setStart((currentPage-1)*pageBean.getPageSize());
		query.setRows(pageBean.getPageSize());
		QueryResponse queryResponse = null;
		try {
			queryResponse = httpSolrServer.query(query);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(queryResponse);
		if(queryResponse != null) {
			SolrDocumentList docs = queryResponse.getResults();
//			System.out.println("docs:"+docs);
			for (SolrDocument doc : docs) {
				Article article = new Article();
				article.setId((Integer)doc.get("article_id"));
				article.setArt_label((String)doc.get("article_art_label"));
				article.setTitle((String)doc.get("article_title"));
				article.setContent((String)doc.get("article_content"));
				article.setDate((String)doc.get("article_date"));
				article.setAuthor((String)doc.get("article_author"));
				pageBean.getPageData().add(article);
				System.out.println("date:"+doc.get("article_date"));
				System.out.println("title:"+doc.get("article_title"));
				System.out.println("content:"+doc.get("article_content"));
			}
			return pageBean;
		}
		return null;
	}
}
