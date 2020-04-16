<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Dodaj/Edytuj klienta.</title>
</head>
<body>
    <div id="addUserForm">
        <div id="header">
            <h2>Aby założyć nowe konto wypełnij formularz i zatwierdź.</h2>
        </div>

        <form:form id="userFormTable" action="saveUser" modelAttribute="user" method="post">
            <table id="userTable">
                <tbody>
                    <tr>
                        <td><label for="username">Login: </label></td>
                        <td><form:input path="username" placeholder=" login"/></td>
                    </tr>
                    <tr>
                        <td><label for="password">Hasło: </label></td>
                        <td><form:password path="password" placeholder=" password"/></td>
                    </tr>
                    <tr>
                        <td><label for="email">E-mail: </label></td>
                        <td><form:input path="email" placeholder=" e-mail"/></td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <td colspan="2" align="center"><input id="submitButton" type="submit" value="Zatwierdź"></td>
                    <td></td>
                </tbody>
            </table>
        </form:form>
    </div>

    <div id="mainPageLink">
        <a href="${pageContext.request.contextPath}/">Powrót do strony głównej</a>
    </div>
</body>
</html>