<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="http://www.mypager.com/pager" %>
<%--
  Created by IntelliJ IDEA.
  User: LamanLu
  Date: 2016/11/17
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="./public/header.jsp"/>

<table>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td>${article.title}</td>
            <td>${article.category.name}</td>
            <td>
                <a href="/view?id=${article.id}" target="_blank">查看</a>
            </td>
        </tr>
    </c:forEach>
</table>
<my:pagination url="/tag" dataCount="${dataCount}" curPage="${page}" pageSize="${pageSize}" />

<jsp:include page="./public/footer.jsp"/>
