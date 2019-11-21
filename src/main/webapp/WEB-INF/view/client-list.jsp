<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Lista klientów</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">Lista klientów</h2>
    </div>
</div>
<div id="container">
    <div id="content">
 <!-- button for adding new customer -->
  <input type="button" value="Dodaj klienta"
  onclick="window.location.href='showFormForAdd'"
  />
<br><br>
 <!-- table for customers -->
    <table style="width:100%" border="1px solid">
        <thead >
        <tr>
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
        <tr>
            <td>${temp.firstName}</td>
            <td>${temp.lastName}</td>
            <td>${temp.adress}</td>
            <td>${temp.email}</td>
            <td><a href="${updateLink}">Edytuj</a></td>
        </tr>
        </c:forEach>
    </table>
</div>
</div>
<br><br>
</body>
</html>