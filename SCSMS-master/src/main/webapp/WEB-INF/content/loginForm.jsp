<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

</head>
<body>
	<div class="login" >
		<h1>登录</h1>
			<form action="studentLogin" method="post">
			<input type="text" placeholder="用户名" name="ssn"><br>
			<input type="password" placeholder="密码" name="password">
			<input type="submit" value="登录">
		</form>
	</div>
	
</body>
</html>