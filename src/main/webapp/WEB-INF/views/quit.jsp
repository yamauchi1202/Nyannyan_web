<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会画面</title>
</head>
<body>
	<p>本当に退会しますか？</p>
	<br>
	<form:form action="quit" method="post" modelAttribute="Form">
		<form:hidden path="alter" value="はい" />
		<input type="submit" value="はい">
	</form:form>
	<form:form action="quit" method="post" modelAttribute="Form">
		<form:hidden path="alter" value="いいえ" />
		<input type="submit" value="いいえ">
	</form:form>
</body>
</html>