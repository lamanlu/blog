<%--
  Created by IntelliJ IDEA.
  User: LamanLu
  Date: 2016/11/15
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Login Page</h3>
<form name="form1" action="/login" method="post">
<input type="text" name="username" value="" /><br/>
<input type="password" name="password" value="" /><br/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input type="submit" name="submit" value="登录" />
</form>
</body>
</html>
