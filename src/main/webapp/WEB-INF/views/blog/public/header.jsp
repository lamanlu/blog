<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LamanLu
  Date: 2016/11/17
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
    <link type="text/css" rel="stylesheet" charset="UTF-8" href="/static/style.css">
</head>
<body>
<div id="header">Header

<ul>
    <li><a href="/">首页</a></li>
    <c:forEach items="${categories}" var="category">
        <li><a href="/category?id=${category.id}">${category.name}</a> </li>
    </c:forEach>
</ul>
</div>

<div id="wrapper">

<jsp:include page="sider.jsp"/>