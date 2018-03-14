package com.lny.bbs.pojo;

public class pageQueryVo {
	private Integer startIndex = 0;
	private Integer pageSize = 1;
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
