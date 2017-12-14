<jsp:useBean id="mailBean" scope="request" type="fr.wildcodeschool.wildmail.MailBean"/>
<%--
  Created by IntelliJ IDEA.
  User: wilder
  Date: 10/12/17
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Email content</title>
    </head>
    <body>
        <p><strong>From : </strong>${sessionScope.userEmail}</p>
        <p><strong>To : </strong>${mailBean.to}</p>
        <p><strong>Subject : </strong>${mailBean.subject}</p>
        <p><strong>Content : </strong>${mailBean.content}</p>
        <br /><a href="${pageContext.request.contextPath}/mail/list">Back to mail list</a>
    </body>
</html>