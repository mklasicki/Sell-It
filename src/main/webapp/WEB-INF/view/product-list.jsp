<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <title>Lista przedmiotów</title>
        <link href="<c:url value="/resources/css/styleTabeli.css" />" rel="stylesheet">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h2>Lista produktów</h2>
            </div>
        <div id="container">
            <div id="addAndSearchBar">
                <table id="searchTable">
                    <tbody>
                        <tr><input id="addButton" type="button" value="Dodaj"
                            onclick="window.location.href='addProduct'"/>
                        </tr>
                        <tr>
                            <form:form action="searchClient" method="get">
                                <input type="text" name="clientId">
                                <input id="searchButton" type="submit" value="Szukaj">
                            </form:form>
                        </tr>
                    </tbody>
                </table>
            </div>
                <br><br>
                                 <!-- table for customers -->
                <table id="product-table">
                    <thead>
                        <tr>
                            <th>Zdjęcie</th>
                            <th>Nazwa</th>
                            <th>Cena</th>
                            <th>Opis</th>
                            <th>Akcja</th>
                        </tr>
                    </thead>
                     <tbody>
                        <c:forEach var="temp" items="${products}">
                            <c:url var="updateLink" value="/showFormForUpdate">
                            </c:url>
                             <c:url var="deleteLink" value="/deleteClient">
                            <c:param name="productId" value="${temp.id}"/>
                            </c:url>
                                <tr id="product-table-tr">
                                    <td><img src= "${temp.image}"></td>
                                    <td>${temp.productName}</td>
                                    <td>${temp.productPrice}</td>
                                    <td>${temp.productDescription}</td>
                                    <td><a href="${updateLink}">Edytuj</a>
                                            |
                                        <a href="${deleteLink}"
                                            onclick="if(!(confirm('Czy napewno usunąć tego klienta z listy?')))return false">Usuń</a>
                                    </td>
                                </tr>
                        </c:forEach>
                </table>
            <p>
                <a href=" ">Powrót do strony głównej</a>
            </p>
            <p>
                <a href=" ">Wyloguj.</a>
            </p>
             </div>
        </div>
        <br><br>
    </body>
</html>