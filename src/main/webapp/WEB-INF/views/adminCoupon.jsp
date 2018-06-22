<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
</head>
<body>

	<c:if test="${not empty msg}">
		<p>${fn:escapeXml(msg)}</p>
	</c:if>

	<div>
		<a href="couponShow">表示</a>
	</div>
	<br>
	<div>
		<a href="couponInsert">登録</a>
	</div>
	<br>
	<div>
		<a href="couponUpdate">更新</a>
	</div>
	<br>
	<div>
		<a href="couponDelete">削除</a>
	</div>
	<br>
	<div>
		<a href="adminMenu">戻る</a>
	</div>

</body>
</html>