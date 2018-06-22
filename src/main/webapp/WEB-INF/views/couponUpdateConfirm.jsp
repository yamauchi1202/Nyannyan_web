<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<p>クーポンの名前を入力してください。</p>

	<form:form action="couponUpdateConfirm" method="post" modelAttribute="Form">
		<div>
			<label class="required">クーポン名</label>
			<form:input path="coupon_name" />
		</div>
		<input type="submit" value="更新">
	</form:form>

</body>
</html>