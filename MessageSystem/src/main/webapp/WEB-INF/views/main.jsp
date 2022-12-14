<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="<c:url value='/resources/assets/css/main.css'/>" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Header -->
					<header id="header" class="alt">
						<a href="index.html" class="logo"><strong>Forty</strong> <span>by HTML5 UP</span></a>
						<nav>
							<c:choose>
								<c:when test="${empty loginM}">
									<a href="#menu">로그인</a>
								</c:when>
								<c:otherwise>
									<c:if test="${loginM.email eq 'admin'}">
										<a href="/message/member/selectAllMember">전체회원조회</a>
									</c:if>
									<a href="/message/update">개인정보수정</a>
									<a href="/message/member/logout">로그아웃</a>
								</c:otherwise>
							</c:choose>
							<!-- 로그인을 안한 경우 -->
							
							
							<!-- 로그인을 한경우 -->
							<!-- 모든 계정 -->
							<!-- a : 로그아웃 / 개인정보수정 -->
							<!-- 관리자 계정 -->
							<!-- a : 전체회원정보 -->
						</nav>
					</header>
				<!-- Menu -->
					<nav id="menu">	
						<ul class="links">
							<li><h5>로그인</h5></li>
								<form action="/message/member/login" method="post">
									<li><input type="text" name="email" placeholder="Email을 입력하세요"></li>
									<li><input type="password" name="pw" placeholder="PW를 입력하세요"></li>
									<li><input type="submit" value="LogIn" class="button fit"></li>
								</form>
						</ul>
						<ul class="actions vertical">
							<li><h5>회원가입</h5></li>
								<form action="/message/member/join" method="post">
									<li><input type="text" name="email" placeholder="Email을 입력하세요">
									<li><input type="password"  name="pw" placeholder="PW를 입력하세요"></li>
									<li><input type="text" name="tel" placeholder="전화번호를 입력하세요"></li>
									<li><input type="text" name="address" placeholder="집주소를 입력하세요"></li>
									<li><input type="submit" value="JoinUs" class="button fit"></li>
								</form>
						</ul>
					</nav>			
				<!-- Banner -->
					<section id="banner" class="major">
						<div class="inner">
							<header class="major">
								<!-- 로그인을 안한 경우 -->
								<c:choose>
									<c:when test="${empty loginM}">
										<h1>로그인 한 세션아이디를 출력해주세요</h1>
									</c:when>
									<c:otherwise>
										<h1>${loginM.email} 님 환영합니다</h1>
									</c:otherwise>
								</c:choose>
								
								<!-- 로그인을 한경우 -->
								<!-- h1 : ~(이메일)님 환영합니다 -->
								<!-- 로그인 후 로그인 한 사용자의 세션아이디로 바꾸시오.
									 ex)smart님 환영합니다 -->
							</header>
							<div class="content">
								<p>아래는 지금까지 배운 웹 기술들입니다.<br></p>
								<ul class="actions">
									<li><a href="#one" class="button next scrolly">확인하기</a></li>
								</ul>
							</div>
						</div>
					</section>
				<!-- Main -->
					<div id="main">
						<!-- One -->
							<section id="one" class="tiles">
								<article>
									<span class="image">
										<img src="images/pic01.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">HTML</a></h3>
										<p>홈페이지를 만드는 기초 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic02.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">CSS</a></h3>
										<p>HTML을 디자인해주는 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic03.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Servlet/JSP</a></h3>
										<p>Java를 기본으로 한 웹 프로그래밍 언어/스크립트 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic04.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">JavaScript</a></h3>
										<p>HTML에 기본적인 로직을 정의할 수 있는 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic05.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">MVC</a></h3>
										<p>웹 프로젝트 중 가장 많이 사용하는 디자인패턴</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic06.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Web Project</a></h3>
										<p>여러분의 최종프로젝트에 웹 기술을 활용하세요!</p>
									</header>
								</article>
							</section>
					<!-- Two -->
							<section id="two">
								<div class="inner">
									<header class="major">
										<h2>나에게 온 메세지 확인하기</h2>
									</header>
									<p></p>
									<ul class="actions">
									<c:choose>
										<c:when test="${empty loginM }">
											<li>로그인을 하세요.</li>
										</c:when>
										<c:otherwise>
											<li><a href="/message/mail/deleteAllMail" class="button next scrolly">전체삭제하기</a></li>
										</c:otherwise>
									</c:choose>
									</ul>
									<table>
										<c:forEach var="mail" items="${messageList }" varStatus="status">
											<tr>
												<td>${status.count }</td> <!--  페이지 마다 1 2 3 4 5가 뜨니까 rowNum을 같이 받아오면 좋음 -->
												<td>${mail.sendName }</td>
												<td>${mail.message }</td>
												<td>${mail.sendDate }</td>
												<td><a href="/message/mail/selectDeleteMail/${mail.num}">삭제</a></td>
											</tr>
										</c:forEach>
									</table>
									<div>
										<ul class="pagination">			
											<c:if test="${pagination.prev}">				
												<li class="page-item previous"><a class="page-link" href="${pagination.startPage-1 }"><</a></li>
											</c:if>							
											<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">				
												<li class="page-item ${pagination.cri.pageNum == idx ? 'active' : ''}">
												<a class="page-link" href="${idx }"> ${idx} </a></li>			
											</c:forEach>							
											<c:if test="${pagination.next}">				
												<li class="page-item next"><a class="page-link" href="${pagination.endPage+1 }">></a></li>
											</c:if>		
										</ul>
										<!-- 값을 전송하는 용도로 사용 사용자 눈엔 보이지 않음 -->
										<form id="pageForm" action="/message/main">
											<input type="hidden" name="pageNum" value="${pagination.cri.pageNum }"></input>
											<input type="hidden" name="amount" value="${pagination.cri.amount }"></input>
										</form>
									
									</div>
								</div>
							</section>
					</div>
				<!-- Contact -->
					<section id="contact">
						<div class="inner">
							<section>
								<form action="/message/mail/sendMail" method="post">
								<div class="field half first">
										<label for="name">Name</label>
										<input type="text" name="sendName" id="name" placeholder="보내는 사람 이름" />
									</div>
									<div class="field half">
										<label for="email">Email</label>
										<input type="text" name="receiveEmail" id="email" placeholder="받는 사람 이메일"/>
									</div>
									<div class="field">
										<label for="message">Message</label>
										<textarea  id="message" name="message" rows="6"></textarea>
									</div>
									<ul class="actions">
										<li><input type="submit" value="Send Message" class="special" /></li>
										<li><input type="reset" value="Clear" /></li>
									</ul>
								</form>
							</section>
							
							<section class="split">
								<section>
									<div class="contact-method">
										<span class="icon alt fa-envelope"></span>
										<h3>Email</h3>
										<c:choose>
											<c:when test="${empty loginM}">
												<a href="#">로그인 한 사람의 이메일을 출력</a>
											</c:when>
											<c:otherwise>
												<a href="#">${loginM.email }</a>
											</c:otherwise>
										</c:choose>
												
											
										<!-- 로그인 한 사용자의 이메일을 출력하시오 -->
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon alt fa-phone"></span>
										<h3>Phone</h3>
											<c:choose>
												<c:when test="${empty loginM}">
													<span>로그인 한 사람의 전화번호를 출력</span>	
												</c:when>
												<c:otherwise>
													<span>${loginM.tel }</span>	
												</c:otherwise>
											</c:choose>
																				
										<!-- 로그인 한 사용자의 전화번호를 출력하시오 -->
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon alt fa-home"></span>
										<h3>Address</h3>
											<c:choose>
												<c:when test="${empty loginM}">
													<span>로그인 한 사람의 집주소를 출력</span>		
												</c:when>
												<c:otherwise>
													<span>${loginM.address }</span>	
												</c:otherwise>
											</c:choose>
											
										<!-- 로그인 한 사용자의 집주소를 출력하시오 -->
									</div>
								</section>
							</section>					
						</div>
					</section>
				<!-- Footer -->
					<footer id="footer">
						<div class="inner">
							<ul class="icons">
								<li><a href="#" class="icon alt fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon alt fa-facebook"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon alt fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a href="#" class="icon alt fa-github"><span class="label">GitHub</span></a></li>
								<li><a href="#" class="icon alt fa-linkedin"><span class="label">LinkedIn</span></a></li>
							</ul>
							<ul class="copyright">
								<li>&copy; Untitled</li><li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>
					</footer>
			</div>
		<!-- Scripts -->
			<script src="<c:url value='/resources/assets/js/jquery.min.js'/>"></script>
			<script src="<c:url value='/resources/assets/js/jquery.scrolly.min.js'/>"></script>
			<script src="<c:url value='/resources/assets/js/jquery.scrollex.min.js'/>"></script>
			<script src="<c:url value='/resources/assets/js/skel.min.js'/>"></script>
			<script src="<c:url value='/resources/assets/js/util.js'/>"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="<c:url value='/resources/assets/js/main.js'/>"></script>
			<script>
				let pageForm=$("#pageForm");
				$(".page-link").on("click", function(e){
					e.preventDefault();//a태그의 이동하는 기능 막기
					//val($(this(현재 이벤트가 발생된 값을 변경하겠다)).attr(속성값을 수정하겠다)
					pageForm.find("input[name=pageNum]").val($(this).attr("href"));
					pageForm.submit();//제출해달라는 뜻(위에서 a태그의 이동 기능을 막아 뒀으니 여기서 제출할 수 있도록(우리가 지정한 메인으로))
				})
				
			
			</script>
	</body>
</html>