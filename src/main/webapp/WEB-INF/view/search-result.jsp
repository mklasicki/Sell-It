<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
 <c:forEach var="temp" items="${products}">
    <div class="product-tile">
    <div id="photo-tile"><img class="product-photo" src= "images/${temp.imageName}" alt="product-photo"></div>
    <div id="name-tile">${temp.productName}</div>
    <div id="description-tile">${temp.productDescription}</div>
    <div id="price-tile">${temp.productPrice} PLN</div>
    <div id='category-tile'>${temp.category}</div>
    </div>
 </c:forEach>
</body>


</html>