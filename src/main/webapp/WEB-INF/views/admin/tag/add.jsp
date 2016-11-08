<%--
  Created by IntelliJ IDEA.
  User: LamanLu
  Date: 2016/11/8
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Tag</title>
</head>
<body>
<form name="form1" action="/admin/tag/save" method="post">
    <input type="text" name="name" value=""/>
    <input type="text" name="sort" value="0"/>
    <input type="submit" name="submit" value="保存"/>
</form>
</body>
</html>
