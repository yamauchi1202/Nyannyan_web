<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クーポン使用確認画面</title>
</head>
<body>
	<p>
		クーポンは一度使用すると使えなくなります。<br>よろしいですか？
	</p>
	<form:form action="couponUse" method="post" modelAttribute="Form">
		<form:hidden path="alter" value="はい" />
		<input type="submit" value="はい">
	</form:form>
	<form:form action="couponUse" method="post" modelAttribute="Form">
		<form:hidden path="alter" value="いいえ" />
		<input type="submit" value="いいえ">
	</form:form>
</body>
</html>