<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<head>
     <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>

<body>
    <div id="loginForm">
        <h1 id="header">Zaloguj sie.</h1>
        <form:form name="login" action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
            <table id="loginTable">
                <tr>
                    <td><label for="username">User: </label></td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td><label for="password">Password: </label></td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr></tr>
                <tr></tr>
                <tr>
                    <td colspan="2" align="center"><input id="submitButton" type="submit" value="Zatwierdź!" ></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>