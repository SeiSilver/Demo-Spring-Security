<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/19/2020
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>

<html>
    <head>
        <title>Login</title>
    </head>

    <style>
        .failed {
            color: #ff0000;
        }
    </style>

    <body>
        <h3>My Custom Login Page</h3>
        <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">

            <c:if test="${param.error != null}">
                <i class="failed">Sorry! you enter invalid username or password</i>
            </c:if>

            <p>
                Username:<input type="text" name="username"/>
            </p>
            <p>
                Password: <input type="password" name="password"/>
            </p>
            <input type="submit" value="Login"/>
        </form:form>
    </body>
</html>
