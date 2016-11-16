<%--
  Created by IntelliJ IDEA.
  User: laman
  Date: 16-11-7
  Time: 下午9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../public/sider.jsp"/>

<form name="form1" action="/admin/category/save" method="post">
    <input type="text" name="name" value=""/>
    <input type="text" name="sort" value="0"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" name="submit" value="保存"/>
</form>

<jsp:include page="../public/footer.jsp"/>
