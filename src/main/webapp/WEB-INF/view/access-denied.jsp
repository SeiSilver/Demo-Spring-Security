<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/17/2020
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>

<html>
    <head>
        <title>Access Denied</title>
    </head>
    <body>
        <h1>Access Denied - You are not authorized to access this resource.</h1>
        <hr>

        <a href="${pageContext.request.contextPath}/">back to home</a>
    </body>
</html>
