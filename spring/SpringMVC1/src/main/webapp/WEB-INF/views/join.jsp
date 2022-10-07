<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
</head>
<body>
<!-- DB에 넣어줘야 하기 때문에 컨트롤러를 따로 하나 더 만들어준다! => MemberController -->
	<form action="/myapp/member/join" method="POST">
		ID : <input type="text" name="id"><br> 
		PW : <input	type="password" name="pw"><br> 
		NICK : <input type="text" name="nick"><br> 
		<input type="submit" value="JOIN">
	</form>
</body>
</html>