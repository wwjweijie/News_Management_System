<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改新闻</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
</head>

<body>
	<%
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = formatter.format(currentTime);
	%>

	<%@include file="top.jsp"%>

	<div id="content">
		<div class="left_menu">
			<%@include file="left_adminmenu.jsp"%>
		</div>
		<div class="m-right">
			<div class="main">
				<div class="search-wrap">
					<div class="search-content">
						<!-- <form action="" method="post"> -->
						<table class="search-tab">
							<tr>
								<th width="180">发布新闻:</th>
							</tr>
						</table>
						<!-- </form> -->
					</div>
				</div>
				<div class="result-wrap">
					<form name="myform" id="myform" method="post"
						action="news_editNews.action">
						<div class="result-content">
							<table class="result-tab" width="100%">
								<tr>
									<th>标题：</th>
									<th>
										<input type="text" name="title" style="width: 200px"
											value="${news.title }">
										<s:fielderror cssStyle="color: black">
											<s:param>title</s:param>
										</s:fielderror>
									</th>
								</tr>
								<tr>
									<th>类型：</th>
									<td>
										<select name="category.cid">
											<!-- <option value="0">==请选择==</option> -->
											<c:forEach items="${list }" var="c">
												<option value="${c.cid }"
													<c:if test="${news.category.cname == c.cname}"> selected="selected"</c:if>>${c.cname }</option>
											</c:forEach>
										</select>
										<s:fielderror cssStyle="color: black">
											<s:param>cid</s:param>
										</s:fielderror>
									</td>
								</tr>
								<tr>
									<th>内容：</th>
									<th>
										<textarea rows="8" cols="120" name="content">${news.content }</textarea>
										<s:fielderror cssStyle="color: black">
											<s:param>content</s:param>
										</s:fielderror>
									</th>
								</tr>
								<tr>
									<th>来源：</th>
									<th><input type="text" name="username" value="${news.user.username }"
										style="width: 200px" readonly="true"></th>
								</tr>
								<tr>
									<th><input class="btn btn-primary btn2" type="submit"
										value="修改"></th>
								</tr>
								<tr>
									<td><input type="hidden" name="time" value="<%=datetime%>"></td>
									<td><input type="hidden" name="nid" value="${news.nid }"></td>
									<td><input type="hidden" name="user.uid"
										value="${news.user.uid }" style="width: 200px"></td>
								</tr>
							</table>
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
