<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
html {
	margin : 0;
	padding: 0;
}

body {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	background-image: url("https://www.dtoday.co.kr/news/photo/201806/268797_184100_0548.jpg");
	background-repeat: no-repeat;
	background-size: 100%;
	color: white;
	font-size: 1.1em;
	padding-top: 250px;
	padding-left: 150px;
	
	}

a {
	text-decoration: none;
	color: inherit;
}

ul {
	list-style: none;
	display: flex;
}

header{
	width:100%;
	height: 170px;
	position: fixed;
	top : 0;
	left : 0;
	background: transparent;
	display: inline-block;
}
.header-nav-menubar{
	color : white;
	font-size: 2em;
	font-weight: bold;
	width: 100%;
	margin: auto 100px;
	border-bottom: 1px solid rgba(0,0,0,0.6);
	line-height: 170px;
}
.header-nav-menubar li {
	padding : 0;
	margin :0;
	padding : 5px 120px;
}
.header-nav-logo{
	background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1JgkTsG-Iqedwk18sHaApwpVdnRiwb2dfFQ&usqp=CAU");
	background-repeat: no-repeat;
	background-size : 200px 100px;
	background-position : 10px 40px;
}

#main{
		width: 1500px;
		margin :auto;
		display: flex;
		flex-flow: wrap;
		border : 1px solid blue;
	}
	.list-menuBox{
		width: 350px;
		margin: 25px;
		padding-top : 20px;
		border:  1px solid black;
		background-color: black;
		color : white;
		border-radius: 20px;
	}
	.menu-img{
		margin : 0;
		width: 320px;
		height: 300px;
		text-align : center;
		background-size: 320px 300px;
		background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiP6C1AEqKnKDD-VTxAculivMG3u0nKsbyfw&usqp=CAU");
		background-repeat: no-repeat;
		background-position: 20px 0;
	}
	.menu-title,.menu-price{
		font-size: 1.8em;
		font-weight: bold;
		text-align: center;
		padding : 20px 0;
	}
	.menu-info{
		padding : 20px 0;
		font-size: 1.4em;
		text-align: center;
		
	}
	.menu-img > a{
		display: block;
		width: 100%;
		height: 100%;
	}

</style>
<body>
	<header>
	<nav class="header-nav-menubar">
		<ul>
			<li class="header-nav-logo"></li>
			<li class="header-nav-menu"><a href="${cpath}/list">전체 메뉴</a></li>
			<li>주류</li>
			<li>추가 메뉴</li>			
		</ul>
	</nav>
	</header>