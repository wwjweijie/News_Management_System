package com.ssh_1.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ssh_1.entity.Category;

/**
 * 新闻类型处理实现类
 * @author wwj
 *
 */
public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	/*
	 * 类型发布
	 */
	@Override
	public void addCategory(Category category) {
		this.getHibernateTemplate().save(category);
	}

	/*
	 * 查看新闻类型
	 */
	@Override
	public List<Category> findAll() {
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) this.getHibernateTemplate().find("from Category");
		return list;
	}

	/*
	 * 删除类型
	 */
	@Override
	public void deleteCategory(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	/*
	 * 修改类型
	 */
	@Override
	public void editCategory(Category category) {
		this.getHibernateTemplate().update(category);
	}

	/*
	 * 通过id查找类型
	 */
	@Override
	public Category findOne(Category category) {
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) this.getHibernateTemplate().find("from Category where cid = ?",
				category.getCid());
		Category category2 = list.get(0);
		return category2;
	}

	/*
	 * 查询类型的数量
	 */
	@Override
	public int findCount() {
		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Category");
		if (list != null && list.size() > 0) {
			Object object = list.get(0);
			Long long1 = (Long) object;
			int count = long1.intValue();
			return count;
		}
		return 0;
	}

	/*
	 * 查询出分页的list集合
	 */
	@Override
	public List<Category> findAllPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Category.class);
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

}
