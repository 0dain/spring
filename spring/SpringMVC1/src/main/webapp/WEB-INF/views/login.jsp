<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<form action="/myapp/member/login" method="POST">
		ID : <input type="text" name="id"><br> 
		PW : <input	type="password" name="pw"><br> 
		<input type="submit" value="LOGIN">
	</form>
</body>
</html>