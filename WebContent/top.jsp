<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
</head>
<body>
	<div class="top"></div>
	<div id="header">
		<div class="logo">新闻系统</div>
		<div class="navigation">
			<ul>
				<li>欢迎您！</li>
				<li>${sessionScope.user.username }</li>
				<%-- <li><a
					href="${ pageContext.request.contextPath }/user_toChangePswPage.action">修改密码</a></li> --%>
				<!-- <li><a href="">设置</a></li> -->
				<li><a
					href="${ pageContext.request.contextPath }/user_quit.action">退出</a></li>
			</ul>
		</div>
	</div>
</body>
</html>