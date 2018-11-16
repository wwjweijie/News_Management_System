package com.ssh_1.entity;

import java.util.List;

/**
 * 分页类
 * @author wwj
 *
 */
public class PageBean {
	// 当前页
	private Integer currentPage;
	// 总记录数
	private Integer totalCount;
	// 每页显示记录数
	private Integer pageSize;
	// 总页数
	private Integer totalPage;
	// 开始位置
	private Integer begin;
	// 每页记录的list集合
	private List<News> list;		//新闻的list集合
	
	private List<Category> list2;	//类型的list集合
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public List<News> getList() {
		return list;
	}
	public void setList(List<News> list) {
		this.list = list;
	}
	public List<Category> getList2() {
		return list2;
	}
	public void setList2(List<Category> list2) {
		this.list2 = list2;
	}
}
