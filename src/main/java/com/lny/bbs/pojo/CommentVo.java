package com.lny.bbs.pojo;

import java.io.Serializable;

public class CommentVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String comment;
	private Integer uid;
	private Integer aid;
	private Integer sid;
	private String date;
	private String author;
	private Integer praise;
	private Integer blame;
	private String from_content;
	private String from_nickname;
	private String title;
	private String grade;
	private Integer article_count;
	private String avatar;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
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
	public Integer getPraise() {
		return praise;
	}
	public void setPraise(Integer praise) {
		this.praise = praise;
	}
	public Integer getBlame() {
		return blame;
	}
	public void setBlame(Integer blame) {
		this.blame = blame;
	}
	public String getFrom_content() {
		return from_content;
	}
	public void setFrom_content(String from_content) {
		this.from_content = from_content;
	}
	public String getFrom_nickname() {
		return from_nickname;
	}
	public void setFrom_nickname(String from_nickname) {
		this.from_nickname = from_nickname;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
