package com.ssh_1.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh_1.entity.Category;
import com.ssh_1.entity.PageBean;
import com.ssh_1.service.CategoryService;

/**
 * 新闻类型动作类
 * @author wwj
 *
 */
public class CategoryAction extends ActionSupport implements ModelDriven<Category> {
	private Category category = new Category();
	@Override
	public Category getModel() {
		return category;
	}
	
	//注入CategoryService
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/*
	 * 跳转到类型发布页面
	 */
	public String toAddCategory(){
		return "toAddCategory";
	}
	
	/*
	 * 类型发布
	 */
	//使用属性封装获取类型名
	private String cname;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	public String addCategory(){
		if (cname.trim().equals("")) {
			addFieldError("cname", "发布的类型不允许为空");
			return "inputAdd";
		}
		category.setcname(cname);
		categoryService.addCategory(category);
		return "addCategory";
	}

	// 使用属性封装，获取当前页数
	private Integer currentPage = 1;

	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	/*
	 * 查看新闻类型
	 */
	public String findAllByPage(){
		PageBean pageBean = categoryService.findAllByPage(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "findAllByPage";
	}
	
	/*
	 * 删除类型
	 */
	public String deleteCategory(){
		categoryService.deleteCategory(category);
		return "deleteCategory";
	}
	
	/*
	 * 到修改类型页面
	 */
	public String toEditCategory(){
		Category category1 = categoryService.findOne(category);
		ServletActionContext.getRequest().setAttribute("category", category1);
		return "toEditCategory";
	}
	
	/*
	 * 修改类型
	 */
	public String editCategory(){
		Category category1 = new Category();
		int cid = category.getCid();
		category1.setcname(cname);
		category1.setCid(cid);
		categoryService.editCategory(category1);
		return "editCategory";
	}
}
