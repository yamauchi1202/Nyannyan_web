<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<c:if test="${not empty admin.admin_name}">
		<p>お疲れ様です${fn:escapeXml(admin.admin_name)}さん</p>
	</c:if>

	<div>
		<a href="adminCoupon">クーポン情報編集</a>
	</div>

	<form action="logout" method="post">
		<input type="submit" value="ログアウト">
	</form>

</body>
</html>