<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
<!-- EL표기법으로 if~else문 쓰는 법 -->
	<c:choose>
		<c:when test="${empty loginM}">
			<a href="/myapp/join"><button>회원가입</button></a>
			<a href="/myapp/login"><button>로그인</button></a>
		</c:when>
		<c:otherwise>
			<!-- 닉네임님 환영합니다 출력 -->
			${loginM.nick}님 환영합니다!<br/>
		<%-- 	<p><%String nick=(String)session.getAttribute("nick");
				out.print(nick+"님 환영합니다");
			%></p>--%>
			<a href="/myapp/update"><button>회원정보수정</button></a>
			<!-- 전체 회원 조회는 id가 admin일 경우에만 보이게 -->
			<c:if test="${loginM.id eq 'admin'}">
			
			<a href="/myapp/member/select"><button>전체회원조회</button></a>
			</c:if>
			<a href="/myapp/member/logout"><button>로그아웃</button></a>
		</c:otherwise>
	</c:choose>
</body>
</html> 