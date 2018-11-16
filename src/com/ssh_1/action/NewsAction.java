package com.ssh_1.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh_1.entity.Category;
import com.ssh_1.entity.News;
import com.ssh_1.entity.PageBean;
import com.ssh_1.service.CategoryService;
import com.ssh_1.service.NewsService;

/**
 * 新闻处理的动作类
 * @author wwj
 *
 */
public class NewsAction extends ActionSupport implements ModelDriven<News> {
	private News news = new News();

	@Override
	public News getModel() {
		return news;
	}

	//注入userService
	private NewsService newsService;
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	//注入categoryService
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/*
	 * 跳转到管理员新闻发布页面
	 */
	public String toAddNews() {
		List<Category> list = categoryService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toAddNews";
	}

	/*
	 * 跳转到用户新闻发布页面
	 */
	public String toAddNewsUser() {
		List<Category> list = categoryService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toAddNewsUser";
	}

	/*
	 * 添加新闻
	 */
	public String addNews() {
		String title = news.getTitle();
		String content = news.getContent();
		Integer cid = news.getCategory().getCid();
		if (title.equals("")) {
			addFieldError("title", "标题不允许为空");
		}
		if (content.equals("")) {
			addFieldError("content", "内容不允许为空");
		}
		if (cid == 0) {
			addFieldError("cid", "类型不允许为空");
		}
		if (content.length() > 255) {
			addFieldError("content", "内容的长度不能超过255");
		}
		if (hasErrors()) {
			List<Category> list = categoryService.findAll();
			ServletActionContext.getRequest().setAttribute("list", list);
			return "inputAdd";
		}
		newsService.addNews(news);
		return "addNews";
	}

	/*
	 * 用户添加新闻
	 */
	public String addNewsUser() {
		String title = news.getTitle();
		String content = news.getContent();
		Integer cid = news.getCategory().getCid();
		if (title.equals("")) {
			addFieldError("title", "标题不允许为空");
		}
		if (content.equals("")) {
			addFieldError("content", "内容不允许为空");
		}
		if (cid == 0) {
			addFieldError("cid", "类型不允许为空");
		}
		if (content.length() > 255) {
			addFieldError("content", "内容的长度不能超过255");
		}
		if (hasErrors()) {
			List<Category> list = categoryService.findAll();
			ServletActionContext.getRequest().setAttribute("list", list);
			return "inputAddUser";
		}
		newsService.addNews(news);
		return "addNewsUser";
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
	 * 跳转到查看新闻页面并查找所有新闻
	 */
	public String findAllByPage() {
		// 查询出所有分类
		List<Category> clist = categoryService.findAll();
		ServletActionContext.getRequest().setAttribute("clist", clist);

		PageBean pageBean = newsService.finaAllByPage(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "findAllByPage";
	}

	/*
	 * 跳转到用户查看新闻页面并查找所有新闻
	 */
	public String findAllByPageIndex() {
		// 查询出所有分类
		List<Category> clist = categoryService.findAll();
		ServletActionContext.getRequest().setAttribute("clist", clist);

		PageBean pageBean = newsService.finaAllByPageIndex(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "findAllByPageIndex";
	}
	
	/*
	 * 用户查看新闻详情
	 */
	public String showNewsUser() {
		News news1 = newsService.findOne(news);
		ServletActionContext.getRequest().setAttribute("news", news1);
		return "showNewsUser";
	}

	/*
	 * 查看新闻详情
	 */
	public String showNews() {
		News news1 = newsService.findOne(news);
		ServletActionContext.getRequest().setAttribute("news", news1);
		return "showNews";
	}

	/*
	 * 删除新闻
	 */
	public String deleteNews() {
		newsService.deleteNews(news);
		return "deleteNews";
	}

	/*
	 * 跳转到修改新闻页面
	 */
	public String toEditNews() {
		News news2 = newsService.findOne(news);
		List<Category> list = categoryService.findAll();
		ServletActionContext.getRequest().setAttribute("news", news2);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toEditNews";
	}

	/*
	 * 修改新闻
	 */
	public String editNews() {
		newsService.editNews(news);
		return "editNews";
	}

	/*
	 * 查询不同类别的新闻显示在管理员界面上
	 */
	public String findNewsPageByCategory() {
		// 判断用户是否选择新闻类型
		Integer c_id = news.getCategory().getCid();
		if (c_id == 0) {
			addFieldError("cid", "*请选择类型");
		}
		if (hasErrors()) {
			// 查询出所有分类
			List<Category> clist = categoryService.findAll();
			ServletActionContext.getRequest().setAttribute("clist", clist);

			PageBean pageBean = newsService.finaAllByPage(currentPage);
			ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
			return "inputCategoryadmin";
		}

		// 查询出所有分类
		List<Category> clist = categoryService.findAll();
		ServletActionContext.getRequest().setAttribute("clist", clist);

		PageBean pageBean = newsService.findNewsPageByCategory(news, currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "findNewsPageByCategory";
	}

	/*
	 * 查询不同类别的新闻显示在用户界面上
	 */
	public String findNewsPageByCategoryIndex() {
		// 判断用户是否选择新闻类型
		Integer c_id = news.getCategory().getCid();
		if (c_id == 0) {
			addFieldError("cid", "*请选择类型");
		}
		if (hasErrors()) {
			// 查询出所有分类
			List<Category> clist = categoryService.findAll();
			ServletActionContext.getRequest().setAttribute("clist", clist);

			PageBean pageBean = newsService.finaAllByPage(currentPage);
			ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
			return "inputCategory";
		}

		// 查询出所有分类
		List<Category> clist = categoryService.findAll();
		ServletActionContext.getRequest().setAttribute("clist", clist);

		PageBean pageBean = newsService.findNewsPageByCategory(news, currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "findNewsPageByCategoryIndex";
	}

	/*
	 * 用户页面根据标题模糊查询
	 */
	public String findByTitle() {
		// 判断用户是否选择标题
		String title = news.getTitle();
		if (title == null || title.equals("")) {
			addFieldError("title", "*请输入标题");
		}
		if (hasErrors()) {
			// 查询出所有分类
			List<Category> clist = categoryService.findAll();
			ServletActionContext.getRequest().setAttribute("clist", clist);

			PageBean pageBean = newsService.finaAllByPage(currentPage);
			ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
			return "inputTitleUser";
		}

		// 查询出所有分类
		List<Category> clist = categoryService.findAll();
		ServletActionContext.getRequest().setAttribute("clist", clist);

		PageBean pageBean = newsService.findByTitle(news, currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "findByTitle";
	}

	// 使用属性封装获取用户选择的时间
	private Date time1;
	private Date time2;

	public Date getTime1() {
		return time1;
	}
	public void setTime1(Date time1) {
		this.time1 = time1;
	}
	public Date getTime2() {
		return time2;
	}
	public void setTime2(Date time2) {
		this.time2 = time2;
	}

	/*
	 * 根据用户选择时间范围查找新闻
	 */
	public String findByTime() {
		// 判断用户是否选择时间
		if (time1 == null || time2 == null) {
			addFieldError("time", "*请输入时间");
		}
		if (hasErrors()) {
			// 查询出所有分类
			List<Category> clist = categoryService.findAll();
			ServletActionContext.getRequest().setAttribute("clist", clist);

			PageBean pageBean = newsService.finaAllByPage(currentPage);
			ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
			return "inputTimeUser";
		}

		// 查询出所有分类
		List<Category> clist = categoryService.findAll();
		ServletActionContext.getRequest().setAttribute("clist", clist);

		// 将用户输入的时间保存到session域对象中
		if (time1 != null && time2 != null) {
			ServletActionContext.getRequest().getSession().setAttribute("time1", time1);
			ServletActionContext.getRequest().getSession().setAttribute("time2", time2);
		}
		if (time1 == null && time2 == null) {
			time1 = (Date) ServletActionContext.getRequest().getSession().getAttribute("time1");
			time2 = (Date) ServletActionContext.getRequest().getSession().getAttribute("time2");
		}

		PageBean pageBean = newsService.findByTime(currentPage, time1, time2);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);

		return "findByTime";
	}
}
