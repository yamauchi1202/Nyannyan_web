<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クーポン使用画面</title>
<link href="/css/commons.css" rel="stylesheet">
</head>
<body>
	<table>
		<caption>使用クーポン</caption>
		<thead>
			<tr>
				<th>クーポン番号</th>
				<th>クーポン名</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${CouponList}" var="CouponList">
				<tr>
					<td>${fn:escapeXml(CouponList.coupon_id)}</td>
					<td>${fn:escapeXml(CouponList.coupon_name)}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div>
		<a href="myPage">マイページに戻る</a>
	</div>
</body>
</html>