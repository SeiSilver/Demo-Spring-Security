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
        <title>Home</title>
    </head>
    <body>
        <h2>Spring Security Demo</h2>
        <hr>
        <p>WELCOME TO MY HOME PAGE</p>

        <button><a href="${pageContext.request.contextPath}/showMyLoginPage">Login</a></button>

        <button><a href="${pageContext.request.contextPath}/detail">Detail</a></button>

        <form:form action="${pageContext.request.contextPath}/logout" method="post">
            <input type="submit" value="logout"/>
        </form:form>
    </body>
</html>
