<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クーポン一覧</title>
<link href="/css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty couponmsg}">
		<p>${fn:escapeXml(couponmsg)}</p>
	</c:if>
	<c:if test="${empty couponmsg}">
		<table>
			<caption>クーポンリスト</caption>
			<thead>
				<tr>
					<th>クーポン番号</th>
					<th>クーポン名</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${CouponList}" var="CouponList">
					<tr>
						<form:form action="coupon" method="post" modelAttribute="Form">
							<td><input type="submit" name="coupon_id"
								value="${fn:escapeXml(CouponList.coupon_id)}"></td>
						</form:form>
						<td>${fn:escapeXml(CouponList.coupon_name)}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<div>
		<a href="myPage">マイページに戻る</a>
	</div>

</body>
</html>