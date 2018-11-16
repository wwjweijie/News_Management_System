<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航栏</title>
</head>
<body>
<ul id="nav_dot">
	<li>
          <h4 class="M1"  >类型管理</h4>
         <div class="list-item none">
            <a href='${pageContext.request.contextPath}/category_findAllByPage.action?currentPage=1'>类型查看</a>
            <a href='${pageContext.request.contextPath}/category_toAddCategory.action'>类型发布</a>
            
          </div>
        </li>
        <li>
          <h4 class="M2">新闻管理</h4>
         <div class="list-item none">
            <a href='${pageContext.request.contextPath}/news_findAllByPage.action?currentPage=1'>新闻查看</a>
            <a href='${pageContext.request.contextPath}/news_toAddNews.action'>新闻发布</a>
          </div>
        </li>
</ul>
</body>
</html>