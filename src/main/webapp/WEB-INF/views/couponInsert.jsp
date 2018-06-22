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

	<p>登録したいクーポンの名前を入力してください。</p>

	<form:form action="couponInsert" method="post" modelAttribute="Form">
		<div>
			<label class="required">クーポン名</label>
			<form:input path="coupon_name" />
		</div>
		<input type="submit" value="登録">
	</form:form>

</body>
</html>