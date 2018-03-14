package com.lny.bbs.pojo;

import java.io.Serializable;

public class Section implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String sec_name;
	private String sec_label;
	private Integer uid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSec_name() {
		return sec_name;
	}
	public void setSec_name(String sec_name) {
		this.sec_name = sec_name;
	}
	public String getSec_label() {
		return sec_label;
	}
	public void setSec_label(String sec_label) {
		this.sec_label = sec_label;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Section [id=" + id + ", sec_name=" + sec_name + ", sec_label=" + sec_label + ", uid=" + uid + "]";
	}
}
