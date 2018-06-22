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

<form:form action="admin" method="post" modelAttribute="Form">
  <fieldset>
    <div>
      <label>ID</label><form:input path="admin_id" />
    </div>
    <div>
      <label>PASS</label><form:password path="password" />
    </div>
  </fieldset>
  <input type="submit" value="ログイン">
</form:form>

</body>
</html>