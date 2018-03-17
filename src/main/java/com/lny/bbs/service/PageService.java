package com.lny.bbs.service;

import java.util.List;

import com.lny.bbs.pojo.PageBean;
import com.lny.bbs.pojo.pageQueryVo;

public interface PageService<T> {
	void initPageQueryVo(Integer currentPage);
	void initCommentPageQueryVo(Integer currentPage, Integer pageSize);
	void setPageBeanTotalCount(Integer totalCount);
	void setPageBeanData(List<T> pageData);
	pageQueryVo getPageQueryVo();
	PageBean<T> getPageBean();
	void setPageQueryVo(pageQueryVo pageQueryVo);
	void setPageBean(PageBean<T> pageBean);
}
