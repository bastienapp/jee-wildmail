<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <%-- TODO : si l'email de l'utilisateur est en session, afficher un lien vers /mail/list --%>
        <p>Welcome ${sessionScope.userEmail}</p>
        <p><a href="${pageContext.request.contextPath}/mail/list">Check your emails</a></p>

        <%-- TODO : sinon afficher le formulaire --%>
        <form method="get" action="${pageContext.request.contextPath}/user/login">
            <label for="loginEmail">Email : </label>
            <input required type="email" name="loginEmailValue" id="loginEmail" placeholder="Your login email here..." />
            <br />
            <input type="submit" value="Login">
        </form>
    </body>
</html>