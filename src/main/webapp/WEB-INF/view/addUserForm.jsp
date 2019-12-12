<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Dodaj/Edytuj klienta.</title>
</head>
<body>
<div id="header">
    <h2>Załóż nowe konto, wypełnij formularz.</h2>
</div>
<div id="addClientForm">
    <form:form action="saveUser" modelAttribute="user" method="post">
        <table>
            <tbody>
            <tr>
                <td><label>Imię</label></td>
                <td><form:input path="username" placeholder="user name"/></td>
            </tr>
            <tr>
                <td><label>Hasło</label></td>
                <td><form:password path="password" placeholder="password"/></td>
            </tr>
            <td><input type="submit" value="Zapisz"></td>
            </tbody>
        </table>
    </form:form>
</div>
<p>
    <a href="${pageContext.request.contextPath}/api">Powrót do strony głównej</a>
</p>
</body>
</html>