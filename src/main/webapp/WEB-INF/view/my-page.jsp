<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<<<<<<< HEAD
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
=======
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed

<html lang="pl">

<head>
    <meta charset="UTF-8">
    <title>Strona główna.</title>
<<<<<<< HEAD
    <meta name="Twoja strona" content="Zarządzaj ogłoszeniami">
=======
    <meta name="Twoja strona" content="zZarządzaj ogłoszeniami">
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
    <meta name="keywords" content="strona, www, ćwiczenia" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,400;1,700&display=swap" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/fontello.css" />" rel="stylesheet">

</head>
<body>
    <div id="container">
        <div id="menu">
<<<<<<< HEAD
         <security:authorize access="isAuthenticated()">
                    Zalogowany jako: <security:authentication property="principal.username" />
                </security:authorize>
         <form:form action="searchProduct" modelAttribute="products"  method="get">
            <ol>
                <li><a href="/logout">Wyloguj się</a></li>
                <li><a href="/showFormForAddUser">Edytuj Profil</a></li>
                <li><a href="/addProduct">Dodaj nowy</a></li>
                <li><input type="text" placeholder=" Szukaj przedmiotu" name="productName"></li>
                <li><button id="search-button" type="submit" name="name">Szukaj</button></li>
                <li><a href="/showMyProducts">Twoje ogloszenia</a><li>
            </ol>
    </form:form>
=======
            <ol>
                <li><a href="/main">Wyloguj się</a></li>
                <li><a href="/showFormForAddUser">Edytuj Profil</a></li>
                <li><a href="/addProduct">Dodaj nowy</a></li>
                <li><input type="text" placeholder=" Szukaj przedmiotu"></li>
                <li><button id="search-button" type="submit" name="name">Szukaj</button></li>
            </ol>
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
        </div>
        <div id="content">
         <h5>Twoje Ogłoszenia</h5>
            <h3 id="category-header">Kategorie przedmiotów</h3>
                <ol>
                    <li><i class="icon-laptop"></i> Elektronika</li>
                    <li><i class="icon-home"></i> Nieruchomości</li>
                    <li><i class="icon-cab"></i> Motoryzacja</li>
                    <li><i class="icon-award"></i> Sport</li>
                    <li><i class="icon-leaf"></i> Dom i Ogród</li>
                </ol>
            <div id="content-list">
                <h3 id="content-list-header">Ostatnio dodane ogłoszenia</h3>
                    <c:forEach var="temp" items="${products}">
<<<<<<< HEAD
                        <c:url var="deleteLink" value="/deleteProduct">
                            <c:param name="productId" value="${temp.id}"/>
                        </c:url>
                        <div class="product-tile">
                            <div id="photo-tile"><img class="product-photo" src="images/${temp.image}" alt="${productName}"></div>
                            <div id="name-tile">${temp.productName}</div>
                            <div id="description-tile">${temp.productDescription}</div>
                            <div id="price-tile">${temp.productPrice}</div>
                            <div id="action-tile">Edytuj /
                               <a href="${deleteLink}"
                                onclick="if(!(confirm('Czy napewno usunąć ten produkt z listy??')))return false">Usuń</a></div>
=======
                        <div class="product-tile">
                            <div id="photo-tile"><img class="product-photo" src= "${temp.image}"></div>
                            <div id="name-tile">${temp.productName}</div>
                            <div id="description-tile">${temp.productDescription}</div>
                            <div id="price-tile">${temp.productPrice}</div>
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
                        </div>
                    </c:forEach>
            </div>
        </div>
</body>

</html>