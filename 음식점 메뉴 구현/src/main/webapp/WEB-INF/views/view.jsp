<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<div class="list-menuBox">
	<div class="menu-img"><a href="${cpath}/view/${dto.idx}">${dto.menu_img }</a></div>
	<div class="menu-title">${dto.menu_name }</div>
	<div class="menu-price">${dto.menu_price }</div>
	<div class="menu-info">${dto.menu_intro }</div>
</div>

</body>
</html>