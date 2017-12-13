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
        <br /><br /><a href="${pageContext.request.contextPath}/mail/list">Back to mail list</a>
    </body>
</html>