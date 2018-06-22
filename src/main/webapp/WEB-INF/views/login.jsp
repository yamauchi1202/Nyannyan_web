<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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

<form:form action="login" method="post" modelAttribute="Form">
  <fieldset>
    <div>
      <label>シリアルID</label><form:input path="user_id" />
    </div>
    <div>
      <label>パスワード</label><form:password path="password" />
    </div>
  </fieldset>
  <input type="submit" value="ログイン">
</form:form>

<div>
  <a href="insert">登録はこちら</a>
</div>

<div>
  <a href="admin">管理者ログイン</a>
</div>

<div>
  <a href="index">TOP画面に戻る</a>
</div>

</body>
</html>