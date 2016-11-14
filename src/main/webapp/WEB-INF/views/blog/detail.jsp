<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" uri="http://www.mytld.com/dateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: laman
  Date: 16-11-6
  Time: 下午10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail Page</title>
</head>
<body>
<h3>${article.title}</h3>
<h4>${article.category.name}</h4>
<c:forEach items="${article.tags}" var="tag">
    <a href="/search?tag=${tag.name}">${tag.name}</a>
</c:forEach>
创建于：${artilce.create_time}  <my:date_format timeStamp="${artilce.create_time}"/>  更新于：${article.update_time} <my:date_format timeStamp="${article.update_time}"/>
<div class="wrapper">${article.content}</div>
</body>
</html>
