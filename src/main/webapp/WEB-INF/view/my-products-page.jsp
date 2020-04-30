<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
</head>
<body>
<h2>To jest strona z moimi przedmiotami!</h2>
    <c:forEach var="temp" items="${userProducts}">
                            <div id="name-tile"> Nazwa :${temp.productName}</div>
                            <div id="description-tile"> Opis :${temp.productDescription}</div>
                            <div id="price-tile">Cena:  ${temp.productPrice}</div>
                    </c:forEach>
</body>