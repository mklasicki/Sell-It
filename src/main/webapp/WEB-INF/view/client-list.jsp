<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Lista klientów</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Lista klientów.</h2>
    </div>
    <div id="container">
        <!-- add button and search bar -->
        <div id="addAndSearchBar">
            <!-- button for adding new customer -->
            <div id="addButton">
                <input type="button" value="Dodaj klienta"
                       onclick="window.location.href='showFormForAdd'"/>
                <!-- form for searching client -->
                <div id="searchBar">
                    <form:form action="searchClient" method="get">
                        <input type="text" name="clientId">
                        <input type="submit" value="Szukaj">
                    </form:form>
                </div>
            </div>
        </div>
        <br><br>
        <!-- table for customers -->
        <table id="clientTable">
            <thead>
            <tr id="clientTableRow">
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Adres</th>
                <th>E-Mail</th>
                <th>Akcja</th>
            </tr>
            </thead>
            <c:forEach var="temp" items="${clients}">
                <c:url var="updateLink" value="/showFormForUpdate">
                    <c:param name="clientId" value="${temp.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/deleteClient">
                    <c:param name="clientId" value="${temp.id}"/>
                </c:url>
                <tr>
                    <td>${temp.firstName}</td>
                    <td>${temp.lastName}</td>
                    <td>${temp.adress}</td>
                    <td>${temp.email}</td>
                    <td><a href="${updateLink}">Edytuj</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if(!(confirm('Czy napewno usunąć tego klienta z listy?')))return false">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p>
            <a href="${pageContext.request.contextPath}/api">Powrót do strony głównej</a>
        </p>
        <p>
            <a href="<c:url value="/logout" />">Wyloguj.</a>
        </p>
    </div>
</div>
<br><br>
</body>
</html>