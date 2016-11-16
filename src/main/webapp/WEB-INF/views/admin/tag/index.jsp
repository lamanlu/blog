<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LamanLu
  Date: 2016/11/8
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../public/sider.jsp"/>

<a href="/admin/tag/add">添加标签</a>
<table>
    <tr>
        <th>ID</th>
        <th>名称</th>
        <th>排序</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${tags}" var="tag">
        <tr>
            <td>${tag.id}</td>
            <td>${tag.name}</td>
            <td>${tag.sort}</td>
            <td>
                <a href="/admin/tag/edit?id=${tag.id}">编辑</a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../public/footer.jsp"/>
