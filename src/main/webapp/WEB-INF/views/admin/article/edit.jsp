<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <title>Edit Article</title>
</head>
<body>
<form name="form1" action="/admin/article/save" method="post">
    标题：<input type="text" name="title" value="${article.title}"/>
    <br>
    分类：
    <select name="category_id">
        <c:forEach items="${categories}" var="category">
            <option value="${category.id}" <c:if test="${article.category_id == category.id}">selected="selected"</c:if>>${category.name}</option>
        </c:forEach>
    </select>
    <br>
    内容：
    <textarea name="content" rows="10" cols="50">${article.content}</textarea>
    <br>
    标签：
    <c:forEach items="${tags}" var="tag">
        <input type="checkbox" name="tags" id="tag_${tag.id}" value="${tag.id}" <c:if test="${fn:contains(article.tags,tag)}">checked="checked"</c:if> /><label for="tag_${tag.id}">${tag.name}</label>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:forEach>
    <br>
    状态：
    <select name="status">
        <c:forEach items="${status}" var="tmp">
            <option value="${tmp.key}" <c:if test="${article.status == tmp.key}">selected="selected"</c:if>>${tmp.value}</option>
        </c:forEach>
    </select>
    <br>
    <input type="hidden" name="id" value="${article.id}"/>
    <input type="submit" name="submit" value="保存"/>
</form>
</body>
</html>
