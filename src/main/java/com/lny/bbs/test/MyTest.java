package com.lny.bbs.test;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

public class MyTest {

	@Test
	public void test() throws SolrServerException {
		String baseURL = "http://localhost:8081/solr/collection1";
		SolrServer solrServer = new HttpSolrServer(baseURL);
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("*:*");
		QueryResponse queryResponse = solrServer.query(solrQuery);
		System.out.println(queryResponse);
		SolrDocumentList docs = queryResponse.getResults();
//		System.out.println(docs);
		for (SolrDocument doc : docs) {
			System.out.println(doc.get("article_title"));
		}
	}

}
