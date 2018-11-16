<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看新闻</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
</head>

<body>

	<%@include file="top.jsp"%>


	<div id="content">
		<div class="left_menu">
			<%@include file="left_adminmenu.jsp"%>
		</div>
		<div class="m-right">
			<div class="main">
				<div class="search-wrap">
					<div class="search-content">
						<form
							action="${pageContext.request.contextPath }/news_findNewsPageByCategory.action?currentPage=1"
							method="post">
							<table class="search-tab">
								<tr>
									<th width="180">选择新闻类型:</th>
									<td>
										<s:fielderror cssStyle="color: red">
											<s:param>cid</s:param>
										</s:fielderror>
										<select name="category.cid">
											<option value="0">==请选择==</option>
											<c:forEach items="${clist }" var="c">
												<option value="${c.cid }">${c.cname }</option>
											</c:forEach>
										</select>
									</td>
									<td>
										<input class="btn btn-primary btn2" type="submit" value="查询">
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div class="result-wrap">
					<form name="myform" id="myform" method="post" action="">
						<div class="result-content">
							<table class="result-tab" width="100%">
								<tr>
									<th>序号</th>
									<th>标题</th>
									<th>发布时间</th>
									<th>类型</th>
									<th>操作</th>
								</tr>
								<c:forEach items="${pageBean.list }" var="n" varStatus="v">
									<tr>
										<td>${v.count }</td>
										<td><a
											href="${pageContext.request.contextPath }/news_showNews.action?nid=${n.nid}">${n.title }</a>
										</td>
										<td>${n.time }</td>
										<td>${n.category.cname }</td>
										<td><a
											href="${pageContext.request.contextPath }/news_deleteNews.action?nid=${n.nid}&currentPage=1"><input
												class="btn btn-primary btn2" type="button" value="删除"></a>
											&nbsp;&nbsp;
											<a
											href="${pageContext.request.contextPath }/news_toEditNews.action?nid=${n.nid}&currentPage=1"><input
												class="btn btn-primary btn2" type="button" value="修改"></a></td>
									</tr>
								</c:forEach>
							</table>
							<div class="list-page">
								共[<B>${pageBean.totalCount}</B>]条记录,共[<B>${pageBean.totalPage}</B>]页
								,当前第[<b>${pageBean.currentPage}</b>]页
								<!--
								前一页：当前页-1
								后一页：当前页+1
								 -->
								<c:if test="${pageBean.currentPage != 1 }">
										[<A
										href="${pageContext.request.contextPath}/news_findAllByPage.action?currentPage=${pageBean.currentPage-1}">前一页</A>]
		 						</c:if>

								<c:if
									test="${pageBean.currentPage!=pageBean.totalPage && pageBean.currentPage<pageBean.totalPage}">
										[<A
										href="${pageContext.request.contextPath}/news_findAllByPage.action?currentPage=${pageBean.currentPage+1}">后一页</A>] 
								</c:if>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="bottom"></div>
	<div id="footer">
		<p>
			<a href="http://www.mycodes.net/" target="_blank"></a>
		</p>
	</div>
	<script>
		navList(12);
	</script>
</body>
</html>
