<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/login.css" />

<style>
body {
	margin-left: auto;
	margin-right: auto;
	margin-TOP: 100PX;
	width: 20em;
}
</style>
<title>登录</title>
</head>
<body class="beg-login-bg">
	<div class="beg-login-box">
		<a style="margin-top: 10px; float: right;"
			href="${pageContext.request.contextPath }/register.jsp">注册</a>
		<header>
			<h1>用户登录</h1>
		</header>
		<div class="beg-login-main">
			<form class="form-horizontal" role="form"
				action="${pageContext.request.contextPath}/user_login.action"
				method="post">
				<div class="form-group">
					<s:fielderror cssStyle="color: white">
						<s:param>username</s:param>
					</s:fielderror>
					<label for="firstname" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="firstname"
							name="username" placeholder="请输入用户名">
					</div>
				</div>
				<div class="form-group">
					<s:fielderror cssStyle="color: white">
						<s:param>password</s:param>
					</s:fielderror>
					<label for="lastname" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="lastname"
							name="password" placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10"></div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-success"
							style="float: right;">登录</button>

					</div>
				</div>
			</form>
		</div>
		<footer> </footer>
	</div>

</body>
</html>
