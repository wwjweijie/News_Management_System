package com.ssh_1.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssh_1.dao.NewsDao;
import com.ssh_1.entity.News;
import com.ssh_1.entity.PageBean;

/**
 * 新闻处理的业务逻辑类
 * @author wwj
 *
 */
@Transactional
public class NewsService {
	private NewsDao newsDao;
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
	
	/*
	 * 添加新闻
	 */
	public void addNews(News news) {
		newsDao.addNews(news);
	}
//
//	/*
//	 * 跳转到新闻页面并查找所有新闻
//	 */
//	public List<News> findAll() {
//		return newsDao.findAll();
//	}

	/*
	 * 查看新闻详情
	 */
	public News findOne(News news) {
		News news2 = newsDao.findOne(news);
		return news2;
	}

	/*
	 * 删除新闻
	 */
	public void deleteNews(News news) {
		newsDao.deleteNews(news);
	}

	/*
	 * 修改新闻
	 */
	public void editNews(News news) {
		newsDao.editNews(news);
	}

	/*
	 * 根据分类查看新闻
	 */
	public List<News> findNewsByCategory(News news) {
		return newsDao.findNewsByCategory(news);
	}

	/*
	 * 查出所有新闻并分页显示
	 */
	public PageBean finaAllByPage(Integer currentPage) {
		PageBean pageBean = new PageBean();
		//设置当前页数
		pageBean.setCurrentPage(currentPage);
		
		//设置每页显示记录数
		int pageSize = 7;
		
		//设置总记录数
		int totalCount = newsDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//设置总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else{
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//得到开始位置
		int begin = (currentPage - 1) * pageSize;
		
		//每页的list集合
		List<News> list = newsDao.findAllPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	/*
	 * 查出所有新闻并分页显示在用户界面上
	 */
	public PageBean finaAllByPageIndex(Integer currentPage) {
		PageBean pageBean = new PageBean();
		//设置当前页数
		pageBean.setCurrentPage(currentPage);
		
		//设置每页显示记录数
		int pageSize = 7;
		
		//设置总记录数
		int totalCount = newsDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//设置总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else{
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//得到开始位置
		int begin = (currentPage - 1) * pageSize;
		
		//每页的list集合
		List<News> list = newsDao.findAllPageIndex(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	/*
	 * 根据类型查看新闻
	 */
	public PageBean findNewsPageByCategory(News news, Integer currentPage) {
		PageBean pageBean = new PageBean();
		//设置当前页数
		pageBean.setCurrentPage(currentPage);
		
		//设置每页显示记录数
		int pageSize = 7;
		
		//设置总记录数
		int totalCount = newsDao.findCountByCategory(news);
		pageBean.setTotalCount(totalCount);
		
		//设置总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else{
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//得到开始位置
		int begin = (currentPage - 1) * pageSize;
		
		//每页的list集合
		List<News> list = newsDao.findPageByCategory(begin,pageSize,news);
		pageBean.setList(list);
		
		return pageBean;
	}

	/*
	 * 根据标题查找新闻
	 */
	public PageBean findByTitle(News news, Integer currentPage) {
		PageBean pageBean = new PageBean();
		//设置当前页数
		pageBean.setCurrentPage(currentPage);
		
		//设置每页显示记录数
		int pageSize = 7;
		
		//设置总记录数
		int totalCount = newsDao.findCountByTitle(news);
		pageBean.setTotalCount(totalCount);
		
		//设置总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else{
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//得到开始位置
		int begin = (currentPage - 1) * pageSize;
		
		//每页的list集合
		List<News> list = newsDao.findAllPageByTitle(begin,pageSize,news);
		pageBean.setList(list);
		
		return pageBean;
	}

	/*
	 * 根据用户输入的时间查找新闻并分页
	 */
	public PageBean findByTime(Integer currentPage, Date time1, Date time2) {
		PageBean pageBean = new PageBean();
		//设置当前页数
		pageBean.setCurrentPage(currentPage);
		
		//设置每页显示记录数
		int pageSize = 7;
		
		//设置总记录数
		int totalCount = newsDao.findCountByTime(time1,time2);
		pageBean.setTotalCount(totalCount);
		
		//设置总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else{
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//得到开始位置
		int begin = (currentPage - 1) * pageSize;
		
		//每页的list集合
		List<News> list = newsDao.findPageByTime(begin,pageSize,time1,time2);
		pageBean.setList(list);
		
		return pageBean;
	}
}
