<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select.jsp</title>
</head>
<body>
	<table>
		<tr>
			<th></th>
			<th>아이디</th>
			<th>닉네임</th>
			<th></th>
		</tr>
		<c:forEach var="member" items="${memberList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${member.id }</td>
				<td>${member.nick }</td>
			<td><a href="/myapp/member/delete?id=${member.id}">삭제</a></td>
			<!-- href="/myapp/member/delete => 이렇게만 쓰면 데이터 삭제를 못하니까 쿼리문을 써줘야 함! -->
		</tr>
		</c:forEach>
	</table>
</body>
</html>