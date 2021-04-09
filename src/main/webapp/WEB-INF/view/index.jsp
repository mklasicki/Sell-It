<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
                    <div id="photo-tile"><img class="product-photo" src= "/images/${temp.imageName}" alt="product-photo"></div>
                    <div id="name-tile">${temp.productName}</div>
                    <div id="description-tile">${temp.productDescription}</div>
                    <div id="price-tile">${temp.productPrice} PLN</div>
                    <div id='category-tile'>${temp.category}</div>
                </div>
            </c:forEach>
    </div>
</div>
