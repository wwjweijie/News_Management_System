package com.ssh_1.dao;

import java.util.Date;
import java.util.List;

import com.ssh_1.entity.News;

/**
 * 新闻处理接口类
 * @author wwj
 *
 */
public interface NewsDao {

	void addNews(News news);

//	List<News> findAll();

	News findOne(News news);

	void deleteNews(News news);

	void editNews(News news);

	List<News> findNewsByCategory(News news);

	int findCount();

	List<News> findAllPage(int begin, int pageSize);

	int findCountByCategory(News news);

	List<News> findPageByCategory(int begin, int pageSize, News news);

	List<News> findAllPageIndex(int begin, int pageSize);

	int findCountByTitle(News news);

	List<News> findAllPageByTitle(int begin, int pageSize, News news);

	int findCountByTime(Date time1, Date time2);

	List<News> findPageByTime(int begin, int pageSize, Date time1, Date time2);

}
