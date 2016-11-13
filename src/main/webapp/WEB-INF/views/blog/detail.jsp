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
<div class="wrapper">${article.content}</div>
</body>
</html>
