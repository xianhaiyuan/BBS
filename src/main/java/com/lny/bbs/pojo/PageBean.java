package com.lny.bbs.pojo;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	//当前页
	private Integer currentPage;
	//每页多少条
	private Integer pageSize = 2;
	//总条数
	private Integer totalCount;
	//每页显示的数据
	private List<T> pageData = new ArrayList<T>();
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", pageData=" + pageData + "]";
	}
	
}
