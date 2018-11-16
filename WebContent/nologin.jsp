<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>警告</title>
<style type="text/css">
#msg {
	width: 600px;
	margin: 30px auto;
	border: 5px solid black;
	box-sizing: border-box;
	border-radius: 5px;
	color: black;
}
</style>
</head>
<body>
	<div id="msg">
		<h2>您未登录，1秒后返回登录页面,如浏览器无反应,<a href="login.jsp">请点击</a></h2>
	</div>
	<script type="text/javascript">  
    var count=1;  
    window.setInterval(function(){  
        if(count==0){  
            location.href="login.jsp";  
        }  
        var div_msg=document.getElementById("msg");  
        div_msg.innerHTML="<h2>您未登录，" + count + "秒后返回登录页面,如浏览器无反应,<a href='login.jsp'>请点击</a></h2>"
			count--;
		}, 1000);
	</script>
</body>
</html>