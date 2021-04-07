<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="pl">

<head>
    <meta charset="UTF-8">
    <title>Strona główna.</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,400;1,700&display=swap" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/fontello.css" />" rel="stylesheet">
</head>
<body>
        <div id="menu">
            <ol>
                <li><a href="/product/add-form">Nowe Ogłoszenie</a></li>
                <li><a href="/login">Zaloguj się</a></li>
                <li><a href="/user/register">Załóż konto</a></li>
            </ol>
        </div>
        <div id="main-page-search-item-form">
            <form:form action="product/search" modelAttribute="products"  method="get">
                <input type="text" placeholder="Szukaj" name="productName"/>
                <button id="search-button" type="submit">Szukaj</button>
            </form:form>
        </div>
        <div id="content">
            <h3 id="category-header">Kategorie przedmiotów</h3>
           <ol>
               <li><a href="/product/Elektronika"><i class="icon-laptop"></i> Elektronika</a></li>
               <li><a href="/product/Nieruchomosci"><i class="icon-home"></i> Nieruchomości</a></li>
               <li><a href="/product/Motoryzacja"><i class="icon-cab"></i> Motoryzacja</a></li>
               <li><a href="/product/Sport"><i class="icon-award"></i> Sport</a></li>
               <li><a href="/product/Dom i Ogród"><i class="icon-leaf"></i> Dom i Ogród</a></li>
            </ol>
            <div id="content-list">
                <h3 id="content-list-header">Ostatnio dodane ogłoszenia</h3>
                    <c:forEach var="temp" items="${products}">
                        <div class="product-tile">
                            <div id="photo-tile"><img class="product-photo" src= "images/${temp.imageName}" alt="product-photo"></div>
                            <div id="name-tile">${temp.productName}</div>
                            <div id="description-tile">${temp.productDescription}</div>
                            <div id="price-tile">${temp.productPrice} PLN</div>
                             <div id='category-tile'>${temp.category}</div>
                        </div>
                    </c:forEach>
            </div>
</body>

</html>