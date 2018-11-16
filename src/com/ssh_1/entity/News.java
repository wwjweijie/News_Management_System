package com.ssh_1.entity;

import java.util.Date;

/**
 * 新闻类
 * @author wwj
 *
 */
public class News {
	private Integer nid;		//新闻id
	private String title;		//新闻开头
	private String content;		//新闻内容
	private Date time;			//新闻发布的时间
	
	//表示发布的用户
	private User user;
	
	//表示所属类别
	private Category category;
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
