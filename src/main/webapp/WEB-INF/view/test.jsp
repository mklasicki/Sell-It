<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    </head>
    <body>
        <div id="container">
                <div id="menu">
                    <form:form action="searchProduct" modelAttribute="products"  method="get">
                        <ol>
                            <li><a href="/loginPage">Zaloguj się</a></li>
                            <li><a href="/showFormForAddUser">Załóż konto</a></li>
                            <li>Kontakt</li>
                            <li><input type="text" placeholder=" Szukaj przedmiotu" name="productName"/></li>
                            <li><button id="search-button" type="submit" name="name">Szukaj</button></li>
                        </ol>
                    </form:form>
                </div>
          <div id="content-list">
                <h3 id="content-list-header">Wyniki wyszukiwania</h3>
                    <p><a href="/main">Powrót do strony głównej</a></p>
                    <c:forEach var="temp" items="${products}">
                        <div class="product-tile">
                            <div id="photo-tile"><img class="product-photo" src= "${temp.image}" alt="product-photo"></div>
                            <div id="name-tile">${temp.productName}</div>
                            <div id="description-tile">${temp.productDescription}</div>
                            <div id="price-tile">${temp.productPrice}</div>
                        </div>
                    </c:forEach>
            </div>
        </div>
</body>
=======

<html>
<head>

</head>
<body>
<h1>Działa</h1>


${product.productName}
${product.productPrice}
${product.productDescription}



</body>


>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
</html>