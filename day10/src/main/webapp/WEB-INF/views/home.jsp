<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>day10</h1>
<hr>
<h3>java path : ${javaVersion }</h3>
<h3>spring version : ${springVersion }</h3>

<ul>
	<li><a href="${cpath }/ex01">ex01 - 예외 처리 (ExceptionHandler)</a></li>
	<li><a href="${cpath }/ex02">ex02 - 예외 처리 (ControllerAdvice)</a></li>
</ul>

<h3>현재 로그인 : ${login.userid }</h3>
<ul>
	<li><a href="${cpath }/login">ex03 - 로그인</a></li>
	<li><a href="${cpath }/board">ex03 - 게시판</a></li>
	<li><a href="${cpath }/sitemap">ex03 - 사이트맵</a></li>
	<li><a href="${cpath }/mypage">ex03 - 내 정보</a></li>
</ul>

</body>
</html>













