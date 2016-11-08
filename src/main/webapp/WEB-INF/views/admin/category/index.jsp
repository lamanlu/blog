<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LamanLu
  Date: 2016/11/8
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category List</title>
</head>
<body>
<a href="/admin/category/add">添加分类</a>
<table>
    <tr>
        <th>ID</th>
        <th>名称</th>
        <th>排序</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.sort}</td>
            <td>${category.id}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
