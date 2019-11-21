<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 21.11.2019
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
            <td><label>Imię</label></td>
            <td><form:input path="firstName" /></td>
        </tr>
        </tbody>
    </table>

</form:form>
</body>
</html>
