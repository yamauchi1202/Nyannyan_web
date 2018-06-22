<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<c:if test="${empty user}">
	<c:redirect url="/login" />
</c:if>
<script src="<c:url value="/resources/js/jquery-1.8.2.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery-ui-1.9.1.custom.js" />"
	type="text/javascript"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

	<p>～${user.user_name}さんのプロフィール～</p>
	<p>
		性別…${user.sex} <br> 居住地…${user.residence} <br>
		生年月日…${user.birthday} <br>
	</p>

	<a href="update"><button type="button" class="btn btn-primary">プロフィールの更新</button></a>
	<br>
	<a href="coupon"><button type="button" class="btn btn-danger">クーポン</button></a>
	<br>
	<a href="quit"><button type="button" class="btn btn-warning">退会する</button></a>
	<br>
	<form action="logout" method="post">
		<button type="submit" value="logout" class="btn btn-success">ログアウト</button>
	</form>
	<br>
	<a href="index">TOP画面へ</a>
</body>
</html>