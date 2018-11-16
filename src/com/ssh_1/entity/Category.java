package com.ssh_1.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 新闻类型类
 * @author wwj
 *
 */
public class Category {
	private Integer cid;		//类型id
	private String cname;		//类型名称
	
	//表示属于这个类别的新闻
	private Set<News> news = new HashSet<News>();
	public Set<News> getNews() {
		return news;
	}
	public void setNews(Set<News> news) {
		this.news = news;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getcname() {
		return cname;
	}
	public void setcname(String cname) {
		this.cname = cname;
	}
}
