package com.lny.bbs.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Article implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String content;
	private Integer uid;
	private String date;
	private String author;
	private String art_label;
	private Integer sid;
	private Integer reply_count;
	private String title;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
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
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getReply_count() {
		return reply_count;
	}
	public void setReply_count(Integer reply_count) {
		this.reply_count = reply_count;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", content=" + content + ", uid=" + uid + ", date=" + date + ", author=" + author
				+ ", art_label=" + art_label + ", sid=" + sid + ", reply_count=" + reply_count + ", title=" + title
				+ "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
