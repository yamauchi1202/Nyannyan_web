<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール更新画面</title>
</head>
<body>
	<form:form action="update" method="post" modelAttribute="Form">
		<fieldset>
			<div>
				<label class="required">名前</label>
				<form:input path="user_name" value="${user.user_name}"/>
			</div>
			<div>
				<label class="required">性別</label>
				男性<form:radiobutton path="sex" value="男性" />
				女性<form:radiobutton path="sex" value="女性" />
			</div>
			<div>
				<label class="required">居住地</label>
				<form:select path="residence">
					<form:option value="">${user.residence}</form:option>
					<form:options items="${residents}"/>
				</form:select>
				<br>
			</div>
			<div>
				<label class="required">生年月日</label>
				<form:input path="year" size="4" value="${birthday[0]}"/>年
				<form:input path="month" size="2" value="${birthday[1]}"/>月
				<form:input path="day" size="2" value="${birthday[2]}"/>日
			</div>
		</fieldset>
		<input type="submit" value="確認">
	</form:form>
</body>
</html>