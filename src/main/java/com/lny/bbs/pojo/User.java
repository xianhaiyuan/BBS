package com.lny.bbs.pojo;

import java.io.Serializable;

public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String username;
    private String passwd;
    private String grade;
    private String email;
    private String nickname;
    private String birthday;
    private String sex;
    private Integer accuse;  
    private Integer ban;
    private Integer position;
    private Integer online;
    private String avatar;
    private Integer article_count;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAccuse() {
		return accuse;
	}
	public void setAccuse(Integer accuse) {
		this.accuse = accuse;
	}
	public Integer getBan() {
		return ban;
	}
	public void setBan(Integer ban) {
		this.ban = ban;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Integer getOnline() {
		return online;
	}
	public void setOnline(Integer online) {
		this.online = online;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwd=" + passwd + ", grade=" + grade + ", email="
				+ email + ", nickname=" + nickname + ", birthday=" + birthday + ", sex=" + sex + ", accuse=" + accuse
				+ ", ban=" + ban + ", position=" + position + ", online=" + online + ", avatar=" + avatar
				+ ", article_count=" + article_count + "]";
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Integer getArticle_count() {
		return article_count;
	}
	public void setArticle_count(Integer article_count) {
		this.article_count = article_count;
	}
    

}