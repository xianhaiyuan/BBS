package com.lny.bbs.test;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

public class MyTest {

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void test() throws SolrServerException {
		String baseURL = "http://localhost:8081/solr/collection1";
		SolrServer solrServer = new HttpSolrServer(baseURL);
		SolrQuery solrQuery = new SolrQuery();
//		solrQuery.setQuery("*:*");
		solrQuery.set("q","article_keywords:羽毛球");
//		solrQuery.setFields("article_content");
		solrQuery.setHighlight(true);
		solrQuery.addHighlightField("article_content");
		solrQuery.addHighlightField("article_title");
		solrQuery.setHighlightSimplePre("<span style='color:red'>");
		solrQuery.setHighlightSimplePost("</span>");
		QueryResponse queryResponse = solrServer.query(solrQuery);
		System.out.println(queryResponse);
		SolrDocumentList docs = queryResponse.getResults();
//		System.out.println(docs);
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		Map<String, List<String>> map = highlighting.get(2);
		System.out.println(map);
		for (SolrDocument doc : docs) {
//			System.out.println(doc.get("article_title"));
		}
	}

}
