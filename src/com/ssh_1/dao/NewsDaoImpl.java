package com.ssh_1.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ssh_1.entity.News;

/**
 * 新闻处理实现类
 * @author wwj
 *
 */
public class NewsDaoImpl extends HibernateDaoSupport implements NewsDao {

	/*
	 * 添加新闻
	 */
	@Override
	public void addNews(News news) {
		this.getHibernateTemplate().save(news);
	}

//	/*
//	 * 跳转到查看新闻页面并查找所有新闻
//	 */
//	@Override
//	public List<News> findAll() {
//		@SuppressWarnings("unchecked")
//		List<News> list = (List<News>) this.getHibernateTemplate().find("from News");
//		return list;
//	}

	/*
	 * 查看新闻详情
	 */
	@Override
	public News findOne(News news) {
		@SuppressWarnings("unchecked")
		List<News> list = (List<News>) this.getHibernateTemplate().find("from News where nid = ?", news.getNid());
		News news2 = list.get(0);
		return news2;
	}

	/*
	 * 删除新闻
	 */
	@Override
	public void deleteNews(News news) {
		this.getHibernateTemplate().delete(news);
	}

	/*
	 * 修改新闻
	 */
	@Override
	public void editNews(News news) {
		this.getHibernateTemplate().update(news);
	}

	/*
	 * 根据分类查看新闻
	 */
	@Override
	public List<News> findNewsByCategory(News news) {
		@SuppressWarnings("unchecked")
		List<News> list = (List<News>) this.getHibernateTemplate().find("from News where c_id = ?",
				news.getCategory().getCid());
		return list;
	}

	/*
	 * 查出所有新闻的数量
	 */
	@Override
	public int findCount() {
		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) this.getHibernateTemplate()
				.find("select count(*) from News where c_id is not null");
		if (list.size() != 0 && list != null) {
			Object object = list.get(0);
			Long long1 = (Long) object;
			int count = long1.intValue();
			return count;
		}
		return 0;
	}

	/*
	 * 查出所有新闻并返回分页的list集合
	 */
	@Override
	public List<News> findAllPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class);

		//类型不能为空且根据时间倒叙排序
		criteria.add(Restrictions.isNotNull("category.cid"));
		criteria.addOrder(Order.desc("time"));
		@SuppressWarnings("unchecked")
		List<News> list = (List<News>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	/*
	 * 查出所有新闻并返回倒叙分页的list集合
	 */
	@Override
	public List<News> findAllPageIndex(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class);

		//类型不能为空且根据时间倒叙排序
		criteria.add(Restrictions.isNotNull("category.cid"));
		criteria.addOrder(Order.desc("time"));
		@SuppressWarnings("unchecked")
		List<News> list = (List<News>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	/*
	 * 查询所有该类型新闻的数量
	 */
	@Override
	public int findCountByCategory(News news) {
		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from News where c_id=?",
				news.getCategory().getCid());
		if (list.size() != 0) {
			Object object = list.get(0);
			Long long1 = (Long) object;
			int count = long1.intValue();
			return count;
		}
		return 0;
	}

	/*
	 * 查出所有此类型的新闻并返回list集合
	 */
	@Override
	public List<News> findPageByCategory(int begin, int pageSize, News news) {
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class);
		criteria.add(Restrictions.eq("category.cid", news.getCategory().getCid()));
		@SuppressWarnings("unchecked")
		List<News> list = (List<News>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	/*
	 * 根据标题查询符合的新闻条数
	 */
	@Override
	public int findCountByTitle(News news) {
		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) this.getHibernateTemplate()
				.find("select count(*) from News where title like '%" + news.getTitle() + "%' and category.cid is not null");
		if (list.size() != 0) {
			Object object = list.get(0);
			Long long1 = (Long) object;
			int count = long1.intValue();
			return count;
		}
		return 0;
	}

	/*
	 * 根据用户输入的标题查找新闻
	 */
	@Override
	public List<News> findAllPageByTitle(int begin, int pageSize, News news) {
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class);
		criteria.add(Restrictions.like("title", "%" + news.getTitle() + "%"));
		
		//类型不能为空且根据时间倒叙排序
		criteria.add(Restrictions.isNotNull("category.cid"));
		criteria.addOrder(Order.desc("time"));
		@SuppressWarnings("unchecked")
		List<News> list = (List<News>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	/*
	 * 查找出该时间区域的记录条数
	 */
	@Override
	public int findCountByTime(Date time1, Date time2) {
		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) this.getHibernateTemplate()
				.find("select count(*) from News n where n.time >= ? and n.time <= ? and category.cid is not null",time1,time2);
		if (list.size() != 0) {
			Object object = list.get(0);
			Long long1 = (Long) object;
			int count = long1.intValue();
			return count;
		}
		return 0;
	}

	/*
	 * 根据时间分页查询新闻    添加拦截器介绍页面，然后自动跳转
	 */
	@Override
	public List<News> findPageByTime(int begin, int pageSize, Date time1, Date time2) {
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class);
		
		//类型不能为空
		criteria.add(Restrictions.isNotNull("category.cid"));
		criteria.add(Restrictions.ge("time", time1));
		criteria.add(Restrictions.le("time", time2));
		@SuppressWarnings("unchecked")
		List<News> list = (List<News>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

}
