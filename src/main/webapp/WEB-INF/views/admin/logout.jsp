<%--
  Created by IntelliJ IDEA.
  User: laman
  Date: 16-11-16
  Time: 下午9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<form name="form1" action="/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" name="submit" value="Logout" />
</form>
</body>
</html>
