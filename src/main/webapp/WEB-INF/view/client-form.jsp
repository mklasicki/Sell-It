<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 21.11.2019
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
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
    <h2>Dodaj klienta.</h2>
</div>
<div id="addClientForm">
    <form:form action="saveClient" modelAttribute="client" method="post">
        <table>
            <tbody>
            <tr>
                <form:hidden path="id"/>
                <td><label>Imię</label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>Nazwisko</label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label>Adres</label></td>
                <td><form:input path="adress"/></td>
            </tr>
            <tr>
                <td><label>E-mail (*)</label></td>
                <td><form:input path="email"/>
                    <form:errors path="email" cssClass="error"/></td>
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
