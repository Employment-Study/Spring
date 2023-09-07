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

<h1>ex03.jsp - artist 목록</h1>
<hr>

<table border="1" cellpadding="10" cellspacing="0">
	<c:forEach var="dto" items="${list }">
	<tr>
		<td rowspan="2">
			<img src="${cpath }/artist_img/${dto.profileImg }" width="150">
		</td>
		<td>${dto.name }</td>
		<td>${dto.country }</td>
		<td>${dto.company }</td>
	</tr>
	<tr>
		<td>${dto.member }</td>
		<td>${dto.debut }</td>
		<td>${dto.type }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>