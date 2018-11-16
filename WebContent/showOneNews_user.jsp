<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看新闻详情</title>
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
			<div class="main">
				<div class="result-wrap">
					<form name="myform" id="myform" method="post" action="">
						<div class="result-content">
							<table class="result-tab" width="100%">
								<tr>
									<!-- 如何设置居中 -->
									<th><h2>${news.title }</h2></th>
								</tr>
								<tr>
									<th>来源：${news.user.username }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发布时间：${news.time }</th>
								</tr>
								<tr>
									<!-- 如何设置空两格 -->
									<th><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${news.content }</p></th>
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
