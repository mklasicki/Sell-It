<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<head>
    <title>Dodaj produkt</title>
    <link href="<c:url value="/resources/css/styleTabeli.css" />" rel="stylesheet">
</head>
<body>
    <div id="addProduct-wrapper">
        <div id="header">
            <h2>Dodaj przemiot.</h2>
        </div>
        <div>
         <form:form action="saveProduct" modelAttribute="product" method = "post">
            <table id="add-product-table">
                <tbody>
                    <tr>
                        <td>Nazwa przedmiotu:</td>
                    </tr>
                    <tr>
                        <td><form:input path="productName"/></td>
                    </tr>
                    <tr>
                        <td>Opis przedmiotu:</td>
                    </tr>
                    <tr>
                        <td><form:textarea path="productDescription" placeholder=" Opisz sprzedawany przedmiot." cols="45" rows="8"/></td>
                    </tr>
                    <tr>
                        <td>Cena:</td>
                    </tr>
                    <tr>
                        <td><form:input path="productPrice" placeholder="zł"/></td>
                    </tr>
                    <tr>
                        <td><Dodaj zdjęcie</td>
                    </tr>
                    <tr>
                        <td><form:input path="image"/></td>
                    </tr>
                    <tr>
                        <td><button type="submit">Zatwierdź</button><button type="reset">Resetuj</button></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            </form:form>
        </div>
    </div>
</body>