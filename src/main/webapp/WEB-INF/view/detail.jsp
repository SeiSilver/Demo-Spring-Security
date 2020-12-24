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
    <h1>THIS IS THE DETAIL VIEW</h1>

    <hr>
    <p>
        User: <security:authentication property="principal.username"/>
        <br><br>
        Roles: <security:authentication property="principal.authorities"/>
    </p>
    <security:authorize access="hasRole('MANAGER')">

        <button>
            <a href="${pageContext.request.contextPath}/leader">
                Leader Meeting (Only for Manager peeps)
            </a>
        </button>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
        <button>
            <a href="${pageContext.request.contextPath}/system">
                IT Systems Meeting (Only for Admin peeps)
            </a>
        </button>
    </security:authorize>


    <hr>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="logout"/>
    </form:form>
</body>
</html>
