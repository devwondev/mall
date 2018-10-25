<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${loginMember.id != null}">
		${loginMember.id}님 반갑습니다.
		<a href="/mall/logout">로그아웃</a>
	</c:if>
	<c:if test="${loginMember.id == null}">
		<a href="/mall/login">로그인</a>
	</c:if>
</body>
</html>
