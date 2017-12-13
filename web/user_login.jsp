<%--
  Created by IntelliJ IDEA.
  User: wilder
  Date: 10/12/17
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
    <c:choose>
        <c:when test="${not empty sessionScope.userEmail}">
            <p>Welcome ${sessionScope.userEmail}</p>
            <p><a href="${pageContext.request.contextPath}/mail/list">Check your emails</a></p>
        </c:when>
        <c:otherwise>
        <form method="get" action="${pageContext.request.contextPath}/user/login">
            <label for="loginEmail">Email : </label>
            <input required type="email" name="loginEmailValue" id="loginEmail" placeholder="Your login email here..." />
            <br />
            <input type="submit" value="Login">
        </form>
        </c:otherwise>
    </c:choose>
    </body>
</html>