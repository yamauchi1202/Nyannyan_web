<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:if test="${not empty errmsg}">
		<p class="error">${fn:escapeXml(errmsg)}</p>
	</c:if>

	<p>削除したいクーポンのIDを入力してください。</p>

	<form:form action="couponDelete" method="post" modelAttribute="Form">
		<div>
			<label class="required">クーポンID</label>
			<form:input path="coupon_id" />
		</div>
		<input type="submit" value="決定">
	</form:form>

</body>
</html>