<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 21.11.2019
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <div id="wrapper">
        <div id="header">
            <h2 align="center">Dodaj klienta</h2>
        </div>
    </div>
</head>
<body>
<form:form action="saveClient" modelAttribute="client" method="post">

    <table>
        <tbody>
        <tr>
            <!-- to było trochę trudne do znalezienia dla mnie, czyli umiejscowienie parametru id. Wyjaśnię jak się spotkamy-->
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
            <td><label>E-mail</label></td>
            <td><form:input path="email"/></td>
        </tr>
        <td><label></label></td>
        <td><input type="submit" value="Zapisz"></td>
        </tbody>
    </table>

</form:form>
<p>
    <a href="${pageContext.request.contextPath}/api">Powrót do strony głównej</a>
</p>
</body>
</html>
