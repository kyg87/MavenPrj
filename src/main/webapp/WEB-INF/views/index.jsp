<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
System.out.println(request.getSession().getAttribute("id"));

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<a href="../index.html">Home</a> 
		<c:if test="${empty sessionScope}">
		<a href="account/login">로그인</a>
		</c:if>
		
		<c:if test="${not empty sessionScope}">
		<a href="logout">${sessionScope.id}님 로그아웃</a>
		</c:if>
		
		<a href="account/login">회원가입</a> 
		<a href="customer/notice">고객센터</a>
	</header>
	<h1>홈페이지 환영</h1>


</body>
</html>