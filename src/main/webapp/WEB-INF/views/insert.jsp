<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>

	<p>登録情報を入力してください</p>

	<form:form action="insert" method="post" modelAttribute="Form">
		<fieldset class="label-60">
			<div>
				<label class="required">名前</label>
				<form:input path="user_name" />
			</div>
			<div>
				<label class="required">性別</label>
				男性<form:radiobutton path="sex" value="男性" />
				女性<form:radiobutton path="sex" value="女性" />
			</div>
			<div>
				<label class="required">居住地</label>
				<form:select path="residence">
					<form:option value="">都道府県</form:option>
  					<form:options items="${residents}"/>
 				</form:select><br>
			</div>
			<div>
				<label class="required">生年月日</label>
				<form:input path="year" size="4" />年<form:input path="month" size="2" />月<form:input path="day" size="2" />日
			</div>
			<div>
				<label class="required">パスワード</label>
				<form:password path="password" showPassword="true" />
			</div>
		</fieldset>
		<input type="submit" value="登録">
	</form:form>

</body>
</html>