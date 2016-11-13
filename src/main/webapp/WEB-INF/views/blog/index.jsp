<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="http://www.mypager.com/pager" %>
<%--
  Created by IntelliJ IDEA.
  User: laman
  Date: 16-11-6
  Time: 下午10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
    <style type="text/css">
        .pagination{
            display: block;
            height: 20px;
            line-height: 20px;
        }

        .pagination a {
            font-size: 12px;
            text-align: center;
            margin-left: 5px;
        }
    </style>
</head>
<body>
<table>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td>${article.id}</td>
            <td>${article.title}</td>
            <td>${article.category.name}</td>
            <td>
                <a href="/view?id=${article.id}" target="_blank">查看</a>
            </td>
        </tr>
    </c:forEach>
</table>
<my:pagination url="/admin/article" dataCount="${dataCount}" curPage="${page}" pageSize="${pageSize}" />
</body>
</html>
