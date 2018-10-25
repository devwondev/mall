<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 목록</h1>
	<table border="1">
		<tr>
			<td>no</td><td>name</td><td>price</td><td>주문</td>
		</tr>
		<c:foreach var="item" items="${list}">
		<tr>
			<td>${item.no}</td>
			<td>${item.name}</td>
			<td>${item.price}</td>
			<td><a href=" ${pageContext.request.contextPath}/Order">주문</a></td>
		</tr>
		</c:foreach>
	</table>
	<div>
		<!-- 페이징 링크 ${pageContext.request.contextPath}/itemList.jsp?currentPage=0 -->
	</div>
</body>
</html>