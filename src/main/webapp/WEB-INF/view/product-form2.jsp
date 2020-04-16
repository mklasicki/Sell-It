<!DOCTYPE html>

<html lang="pl">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<head>
    <meta charset="UTF-8">
    <title>Strona główna.</title>
    <meta name="description" content="Stronka do ćwiczeń, mam nadzieje, że bedzie się szybko rozwijała.">
    <meta name="keywords" content="strona, www, ćwiczenia" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,400;1,700&display=swap" rel="stylesheet">
     <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/fontello.css" />" rel="stylesheet">


</head>
<body>
    <div id="wrapper">
        <div id="add-product-head">
            <h3 id="add-product-header">Dodaj nowy przedmiot</h3>
        </div>
        <form:form action="saveProduct" modelAttribute="product" method="post">
        <div id="product-name">
            <div>Nazwa</div>
                <form:input path="productName" id="add-product-input" name="add-product" type="text"/>
        </div>
        <div id="product-category">
            Wybierz kategorię
                <div id="category-checkbox">
                    <ol>
                        <li><i class="icon-laptop" ></i>Elektronika</li>
                        <li><i class="icon-home" ></i> Nieruchomości</li>
                        <li><i class="icon-cab" ></i> Motoryzacja</li>
                        <li><i class="icon-award" ></i> Sport</li>
                        <li><i class="icon-leaf" ></i> Dom i Ogród</li>
                    </ol>
                </div>
        </div>
                <div id="product-description">
                    Opisz przedmiot
                </div>
                <div id="text-area">
                    <form:textarea path="productDescription" id="textarea-product-description"/>
                </div>
                <div id="product-price">
                    <label>Podaj cenę </label>
                        <form:input path="productPrice" type="text"/>
                </div>
                <div id="product-photo-add">
                     Dodaj zdjęcie
                        <form:input path="image" type="text"/>
                </div>
                <div id="add-product-button">
                      <button type="submit" class="login-button">Prześlij</button>
                </div>
            </form:form>
    </div>
</body>

</html>