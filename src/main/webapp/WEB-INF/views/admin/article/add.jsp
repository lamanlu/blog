<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LamanLu
  Date: 2016/11/7
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="form1" action="/admin/article/save" method="post">
    标题：<input type="text" name="title" value=""/>
    <br>
    分类：
    <select name="category_id">
        <c:forEach items="${categories}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <br>
    内容：
    <textarea name="content" rows="10" cols="50"></textarea>
    <br>
    标签：
    <c:forEach items="${tags}" var="tag">
        <input type="checkbox" name="tags[]" id="tag_${tag.id}" value="${tag.id}"/><label for="tag_${tag.id}">${tag.name}</label>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:forEach>
    <br>
    状态：
    <select name="status">
        <c:forEach items="${status}" var="tmp">
            <option value="${tmp.key}">${tmp.value}</option>
        </c:forEach>
    </select>
    <br>
    <input type="submit" name="submit" value="保存"/>
</form>
</body>
</html>
