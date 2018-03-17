package com.lny.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lny.bbs.pojo.PageBean;
import com.lny.bbs.pojo.pageQueryVo;

@Service
public class PageServiceImpl<T> implements PageService<T> {
	@Autowired
	private pageQueryVo pageQueryVo;
	@Autowired
	private PageBean<T> pageBean;
	public void initPageQueryVo(Integer currentPage) {
		this.pageBean.setCurrentPage(currentPage);
		this.pageQueryVo.setPageSize(this.pageBean.getPageSize());
		this.pageQueryVo.setStartIndex( (currentPage-1) * this.pageBean.getPageSize() );
	}
	public void initCommentPageQueryVo(Integer currentPage, Integer pageSize) {
		this.pageBean.setCurrentPage(currentPage);
		this.pageBean.setPageSize(pageSize);
		this.pageQueryVo.setPageSize(this.pageBean.getPageSize());
		this.pageQueryVo.setStartIndex( (currentPage-1) * this.pageBean.getPageSize() );
	}
	public void setPageBeanTotalCount(Integer totalCount) {
		this.pageBean.setTotalCount(totalCount);
	}
	public void setPageBeanData(List<T> pageData) {
		this.pageBean.setPageData(pageData);
	}
	public PageBean<T> getPageBean() {
		return pageBean;
	}
	public pageQueryVo getPageQueryVo() {
		return pageQueryVo;
	}
	public void setPageQueryVo(pageQueryVo pageQueryVo) {
		this.pageQueryVo = pageQueryVo;
	}
	public void setPageBean(PageBean<T> pageBean) {
		this.pageBean = pageBean;
	}

}
