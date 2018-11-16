<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加新闻类型</title>
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
						<!-- <form action="" method="post"> -->
						<table class="search-tab">
							<tr>
								<th width="180">发布新闻类型:</th>
							</tr>
						</table>
						<!-- </form> -->
					</div>
				</div>
				<div class="result-wrap">
					<form name="myform" id="myform" method="post"
						action="category_addCategory.action">
						<div class="result-content">
							<table class="result-tab" width="100%">
								<tr>
									<th>类型名：</th>
									<s:fielderror cssStyle="color: black">
										<s:param>cname</s:param>
									</s:fielderror>
									<th><input type="text" name="cname" style="width: 600px"></th>
									<th><input class="btn btn-primary btn2" type="submit"
										value="添加" id="bt"></th>
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
