<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>addMember Form</h2>
	<form action="<%=request.getContextPath()%>/AddMember" method="post">
		id:<input type="text" name="id"><br>
		pw:<input type="text" name="pw"><br>
		<input type="submit" value="���Թ�ư">
	</form>
</body>
</html>