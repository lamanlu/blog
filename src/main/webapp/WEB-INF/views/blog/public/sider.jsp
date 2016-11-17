<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LamanLu
  Date: 2016/11/17
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="sidebar">
    <div class="side-box">
        <ul>
        <c:forEach items="${categories}" var="category">
            <li><a href="/category?id=${category.id}">${category.name}</a> </li>
        </c:forEach>
        </ul>
    </div>

    <div class="side-box">
        <ul>
            <c:forEach items="${tags}" var="tag">
                <li><a href="/tag?id=${tag.id}">${tag.name}</a> </li>
            </c:forEach>
        </ul>
    </div>
</div>
