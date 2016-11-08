<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LamanLu
  Date: 2016/11/8
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Article List</title>
</head>
<body>
<a href="/admin/article/add">写文章</a>
<table>
    <tr>
        <th>ID</th>
        <th>标题</th>
        <th>分类</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td>${article.id}</td>
            <td>${article.title}</td>
            <td>${article.category_id}</td>
            <td>${article.status}</td>
            <td>
                <a href="/admin/article/edit?id=${article.id}">编辑</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
