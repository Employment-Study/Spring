<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<style>
	form{
		width : 800px;
		margin: auto;
	}
	input{
		text-align: center;
	}
	input ,textarea{
		all :unset;
		width: 500px;
		padding : 10 50px;
		border : 1px solid white;
		border-radius: 20px;
		font-size: 2em;
	}
}
</style>

<form method="POST" >
	<p><input type="text" name="menu_name" placeholder="메뉴 이름"></p>
	<p><input type="number" name="menu_price" placeholder="가격" min="0"></p>
	<p><textarea name="menu_intro" placeholder="메뉴 소개"></textarea></p>
	<p><input type="submit"></p>
</form>
</body>
</html>