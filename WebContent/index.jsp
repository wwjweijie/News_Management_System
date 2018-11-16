<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
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
			<%@include file="left_menu.jsp"%>
		</div>
		<div class="m-right">
			<div class="main" style="padding: 20px;">
                <!-- <div class="intro" style="font-family: '微软雅黑';">
					<h3>欢迎你</h3>
				</div> -->
				<div class="search-wrap">
					<div class="search-content">
						<form action="${pageContext.request.contextPath }/news_findByTime.action?currentPage=1" method="post" style="float:left;">
							<s:fielderror cssStyle="color: red">
								<s:param>time</s:param>
							</s:fielderror>
							请选择时间：
							<input type="date" name="time1" />
							--
							<input type="date" name="time2" />&nbsp;&nbsp;
							<input class="btn btn-primary btn2" type="submit" value="查询" id="bt">
						</form>
						
						<form action="${pageContext.request.contextPath }/news_findNewsPageByCategoryIndex.action?currentPage=1" method="post" style="float:left;">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							选择新闻类型:
							<s:fielderror cssStyle="color: red">
								<s:param>cid</s:param>
							</s:fielderror>
							<select name="category.cid">
									<option value="0">==请选择==</option>
									<c:forEach items="${clist }" var="c">
										<option value="${c.cid }">${c.cname }</option>
									</c:forEach>
							</select>
							<td><input class="btn btn-primary btn2" type="submit" value="查询"></td>
						</form>
						
						<form action="${pageContext.request.contextPath }/news_findByTitle.action?currentPage=1" method="post" style="float:left;">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<s:fielderror cssStyle="color: red">
								<s:param>title</s:param>
							</s:fielderror>
							请输入标题：
							<input type="text" name="title" width="250px" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="btn btn-primary btn2" type="submit" value="查询" id="bt">
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
										<!-- <th>操作</th> -->
									</tr>
							<c:forEach items="${pageBean.list }" var="n" varStatus="v">
									<tr>
										<td>${v.count }</td>
										<td>
											<a href="${pageContext.request.contextPath }/news_showNewsUser.action?nid=${n.nid}">${n.title }</a>
										</td>
										<td>${n.time }</td>
										<td>${n.category.cname }</td>
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
										href="${pageContext.request.contextPath}/news_findAllByPageIndex.action?currentPage=${pageBean.currentPage-1}">前一页</A>]
		 						</c:if>

								<c:if test="${pageBean.currentPage !=pageBean.totalPage && pageBean.currentPage<pageBean.totalPage}">
										[<A
										href="${pageContext.request.contextPath}/news_findAllByPageIndex.action?currentPage=${pageBean.currentPage+1}">后一页</A>] 
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