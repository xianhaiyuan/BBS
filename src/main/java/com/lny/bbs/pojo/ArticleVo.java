package com.lny.bbs.pojo;

import java.io.Serializable;

public class ArticleVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String content;
	private Integer uid;
	private String date;
	private String author;
	private String art_label;
	private String title;
	private String grade;
	private Integer article_count;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getArt_label() {
		return art_label;
	}
	public void setArt_label(String art_label) {
		this.art_label = art_label;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getArticle_count() {
		return article_count;
	}
	public void setArticle_count(Integer article_count) {
		this.article_count = article_count;
	}
}
