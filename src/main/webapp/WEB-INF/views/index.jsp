<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>娘娘</title>
</head>
<body>

	<c:if test="${not empty user.user_name}">
		<p>ようこそ${fn:escapeXml(user.user_name)}さん</p>
	</c:if>

	<c:if test="${not empty msg}">
		<p>${fn:escapeXml(msg)}</p>
	</c:if>
	<c:if test="${empty user}">
		<a href="insert">登録</a>
	</c:if>
	<c:if test="${empty user}">
		<a href="login">ログイン</a>
	</c:if>

	<a href="myPage">マイページ</a>

	<c:if test="${not empty user}">
		<form action="logout" method="post">
			<input type="submit" value="ログアウト">
		</form>
	</c:if>

</body>
</html>