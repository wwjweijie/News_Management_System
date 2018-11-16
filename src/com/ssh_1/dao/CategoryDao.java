package com.ssh_1.dao;

import java.util.List;

import com.ssh_1.entity.Category;

/**
 * 类型处理接口
 * @author wwj
 *
 */
public interface CategoryDao {

	void addCategory(Category category);

	List<Category> findAll();

	void deleteCategory(Category category);

	void editCategory(Category category);

	Category findOne(Category category);

	int findCount();

	List<Category> findAllPage(int begin, int pageSize);

}
