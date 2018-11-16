<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看新闻类型</title>
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
						<form action="" method="post">
							<table class="search-tab">
								<tr>
									<th width="180">查看新闻类型:</th>
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
									<th>类型名</th>
									<th>操作</th>
								</tr>
								<c:forEach items="${pageBean.list2 }" var="c" varStatus="v">
									<tr>
										<td>${v.count }</td>
										<td>${c.cname }</td>
										<td><a
											href="${pageContext.request.contextPath }/category_deleteCategory.action?cid=${c.cid}"><input
												class="btn btn-primary btn2" type="button" value="删除"></a>
											&nbsp;&nbsp;
											<a
											href="${pageContext.request.contextPath }/category_toEditCategory.action?cid=${c.cid}"><input
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
										href="${pageContext.request.contextPath}/category_findAllByPage.action?currentPage=${pageBean.currentPage-1}">前一页</A>]
		 						</c:if>

								<c:if
									test="${pageBean.currentPage!=pageBean.totalPage && pageBean.currentPage<pageBean.totalPage}">
										[<A
										href="${pageContext.request.contextPath}/category_findAllByPage.action?currentPage=${pageBean.currentPage+1}">后一页</A>] 
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
