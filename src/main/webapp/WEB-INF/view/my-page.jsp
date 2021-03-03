<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="pl">

<head>
    <meta charset="UTF-8">
    <title>Twoja strona.</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,400;1,700&display=swap" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/fontello.css" />" rel="stylesheet">
</head>
<body>
     <div id="menu">
         <div class="search-product-form">
            <form:form action="searchProduct" modelAttribute="products"  method="get">
                <input type="text" placeholder=" Szukaj przedmiotu" name="productName">
                <button id="search-button" type="submit" name="name">Szukaj</button>
            </form:form>
         </div>
         <div>
            <ol>
                <li>
                      <a href="#">
                        <security:authorize access="isAuthenticated()">
                        Witaj <security:authentication property="principal.username" /> !
                        </security:authorize>
                      </a>
                        <ul>
                            <li><a href="/product/add-form">Dodaj ogłoszenie</a></li>
                            <li><a href="/my-products">Twoje ogłoszenia</a></li>
                            <li>
                                <c:url var="updateLink" value="/user/update-form">
                                <c:param name="userId" value="${user.id}"/>
                                </c:url>
                                <a href ="${updateLink}">Edytuj profil</a>
                            </li>
                            <li><a href="/logout">Wyloguj</a></li>
                        </ul>
                 </li>
            </ol>
         </div>
     </div>
     <div style="clear:both;"></div>
        <div id="content">
            <h3 id="category-header">Kategorie przedmiotów</h3>
                <ol>
                    <li><a href="/product/Elektronika"><i class="icon-laptop"></i> Elektronika</a></li>
                    <li><a href="/product/Nieruchomosci"><i class="icon-home"></i> Nieruchomości</a></li>
                    <li><a href="/product/Motoryzacja"><i class="icon-cab"></i> Motoryzacja</a></li>
                    <li><a href="/product/Sport"><i class="icon-award"></i> Sport</a></li>
                    <li><a href="/product/Dom i Ogród"><i class="icon-leaf"></i> Dom i Ogród</a></li>
                </ol>
                 <div style="clear:both;"></div>
            <div id="content-list">
                <h3 id="content-list-header">Ostatnio dodane ogłoszenia</h3>
                    <c:forEach var="temp" items="${products}">
                        <div class="product-tile">
                            <div id="photo-tile"><img class="product-photo" src="images/${temp.imageName}" alt="${productName}"></div>
                            <div id="name-tile">${temp.productName}</div>
                            <div id="description-tile">${temp.productDescription}</div>
                            <div id="price-tile">${temp.productPrice}</div>
                            <div id='category-tile'>${temp.category}</div>
                         </div>
                    </c:forEach>
            </div>

</body>

</html>