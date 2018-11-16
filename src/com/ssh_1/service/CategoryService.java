package com.ssh_1.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssh_1.dao.CategoryDao;
import com.ssh_1.entity.Category;
import com.ssh_1.entity.PageBean;

/**
 * 新闻类型处理业务逻辑类
 * @author wwj
 *
 */
@Transactional
public class CategoryService {
	private CategoryDao categoryDao;
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/*
	 * 类型发布
	 */
	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}

	/*
	 * 查看新闻类型
	 */
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	/*
	 * 删除类型
	 */
	public void deleteCategory(Category category) {
		categoryDao.deleteCategory(category);
	}

	/*
	 * 修改类型
	 */
	public void editCategory(Category category) {
		categoryDao.editCategory(category);
	}

	/*
	 * 通过id查找类型
	 */
	public Category findOne(Category category) {
		return categoryDao.findOne(category);
	}

	/*
	 * 查询出每页的list集合并封装到pageBean对象
	 */
	public PageBean findAllByPage(Integer currentPage) {
		PageBean pageBean = new PageBean();
		
		//设置当前页
		pageBean.setCurrentPage(currentPage);
		
		//设置每页显示的记录数
		int pageSize = 7;
		
		//设置总记录数
		int totalCount = categoryDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//设置总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//设置开始位置
		int begin = (currentPage - 1) * pageSize;
		
		//设置分页的list集合
		List<Category> list = categoryDao.findAllPage(begin,pageSize);
		pageBean.setList2(list);
		return pageBean;
	}
	
}
