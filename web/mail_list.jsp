<%--
  Created by IntelliJ IDEA.
  User: bastienwcs
  Date: 12/12/17
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Your emails</title>
    </head>
    <body>
        <ul>
        <c:forEach items="${requestScope.mailList}" var="mail">
            <li>
                <span><strong>To :</strong> ${mail.to}</span>
                <span><strong>Subject :</strong> ${mail.subject}</span>
                <a href="${pageContext.request.contextPath}/mail/content?id=${mail.id}">Open</a>
            </li>
        </c:forEach>
        </ul>
        <form action="${pageContext.request.contextPath}/mail/create" method="get">
            <input type="submit" value="Send a new mail" />
        </form>
    </body>
</html>
