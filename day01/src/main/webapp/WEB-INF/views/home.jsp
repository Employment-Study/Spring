<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>

<h1>home.jsp</h1>
<hr>

<h3>Hello</h3>
<h3>접속된 DB의 버전 : ${version }</h3>

<ul>
	<li><a href="${cpath }/ex01">ex01 - 파라미터 전달 및 출력</a></li>
	<li><a href="${cpath }/ex02">ex02 - 파라미터 전달 및 출력</a></li>
	<li><a href="${cpath }/ex03">ex03 - DB 데이터 리스트 불러와서 출력</a></li>
</ul>









</body>
</html>