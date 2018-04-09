package com.lny.bbs.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lny.bbs.pojo.Article;
import com.lny.bbs.pojo.PageBean;

@Service
public class SolrServiceImpl implements SolrService {
	@Autowired
	private HttpSolrServer httpSolrServer;
	
	public PageBean<Article> getArticlePage(String keyword,int currentPage){
		SolrQuery query = new SolrQuery();
		PageBean<Article> pageBean = new PageBean<Article>();
		query.set("df", "article_keywords");
		if(!keyword.equals("") && keyword != null) {
			query.set("q","article_keywords:"+keyword);
		}else {
			query.setQuery("*:*");
			query.set("fl","article_id,article_sid,article_art_label,article_title,article_date,article_author,article_content");
		}
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
		query.setHighlight(true);
		query.addHighlightField("article_content");
		query.addHighlightField("article_title");
		query.setHighlightSimplePre("<span style='color:red'>");
		query.setHighlightSimplePost("</span>");
		QueryResponse queryResponse = null;
		try {
			queryResponse = httpSolrServer.query(query);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(queryResponse != null) {
			SolrDocumentList docs = queryResponse.getResults();
			Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
			for (SolrDocument doc : docs) {
				Article article = new Article();
				article.setId((Integer)doc.get("article_id"));
				article.setSid((Integer)doc.get("article_sid"));
				article.setArt_label((String)doc.get("article_art_label"));
				Map<String, List<String>> map = highlighting.get(doc.get("id"));
				if(map!=null) {
					if(map.get("article_title")!=null) {
						article.setTitle(map.get("article_title").get(0));
					}else {
						article.setTitle((String)doc.get("article_title"));
					}
					if(map.get("article_content")!=null) {
						article.setContent(map.get("article_content").get(0));
					}else {
						article.setContent((String)doc.get("article_content"));
					}
				}else {
					article.setTitle((String)doc.get("article_title"));
					article.setContent((String)doc.get("article_content"));
				}
				article.setDate((String)doc.get("article_date"));
				article.setAuthor((String)doc.get("article_author"));
				pageBean.getPageData().add(article);
			}
			return pageBean;
		}
		return null;
	}

	public void removeArticleById(Integer id) {
		try {
			httpSolrServer.deleteByQuery("id:"+id,1000);
		} catch (SolrServerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeArticleBySid(Integer sid) {
		try {
			httpSolrServer.deleteByQuery("article_sid:"+sid,1000);
		} catch (SolrServerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addOrUpdateArticle(Article article) {
		SolrInputDocument doc = new SolrInputDocument();
		doc.setField("id", article.getId());
		doc.setField("article_id", article.getId());
		doc.setField("article_content", article.getContent());
		doc.setField("article_uid", article.getUid());
		doc.setField("article_date", article.getDate());
		doc.setField("article_author", article.getAuthor());
		doc.setField("article_art_label", article.getArt_label());
		doc.setField("article_sid", article.getSid());
		doc.setField("article_reply_count", article.getReply_count());
		doc.setField("article_title", article.getTitle());
		try {
			httpSolrServer.add(doc);
			httpSolrServer.commit();
		} catch (SolrServerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
