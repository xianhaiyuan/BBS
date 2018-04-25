package com.lny.bbs.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class pageQueryVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer startIndex = 0;
	private Integer pageSize = 8;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "pageQueryVo [startIndex=" + startIndex + ", pageSize=" + pageSize + "]";
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
}
