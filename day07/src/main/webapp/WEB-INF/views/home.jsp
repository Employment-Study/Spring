<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<style>
	h3 {
		width: 100%;
		word-break: break-all; 
	}
</style>
<h3>home.jsp</h3>

<p><a href="${cpath }/ex01"><button>ex01 - 회원가입 구현 (hash 적용)</button></a>
<p><a href="${cpath }/ex02"><button>ex02 - 로그인 구현 (hash 적용)</button></a>
<p><a href="${cpath }/ex03"><button>ex03 - 비밀번호 재발급 (hash 적용)</button></a>
<p><a href="${cpath }/ex04"><button>ex04 - 비밀번호 변경 (로그인 전용)</button></a>

<fieldset>
	<legend>hash test</legend>
	<form method="POST">
		<p><input type="text" name="source" placeholder="source" autofocus></p>
		<p><input type="text" name="salt" placeholder="salt"></p>
		<p><input type="submit"></p>
	</form>
	<c:if test="${not empty hash }">
		<h3>source : ${param.source }</h3>
		<h3>salt : ${salt }</h3>
		<h3>hash : ${hash }</h3>
	</c:if>
</fieldset>

<details>
	<summary>SQL</summary>
	<pre>
drop sequence member2_seq;
drop table member2 purge;

create sequence member2_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;

create table member2 (
    idx         number          default member2_seq.nextval primary key,
    userid      varchar2(100)   not null unique,
    userpw      varchar2(500)   not null,
    salt        varchar2(50)    not null,
    username    varchar2(100)   not null,
    email       varchar2(100)   not null unique
);


select * from member2 order by idx;

commit;	
	</pre>
</details>


</body>
</html>