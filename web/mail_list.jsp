<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Your emails</title>
    </head>
    <body>
        <ul>
            <%-- TODO : afficher la liste des mails à partir de la session --%>
        </ul>
        <form action="${pageContext.request.contextPath}/mail/create" method="get">
            <input type="submit" value="Send a new mail" />
        </form>
    </body>
</html>
