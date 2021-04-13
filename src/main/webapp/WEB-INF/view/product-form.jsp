<!DOCTYPE html>

<html lang="pl">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



    <div id="wrapper">
        <div id="add-product-head">
            <h3 id="add-product-header">Dodaj nowy przedmiot</h3>
        </div>

        <form:form action="save" modelAttribute="product"  method="post" enctype="multipart/form-data">
        <div id="product-name">
            <div>Nazwa</div>
                <form:input path="productName" id="add-product-input" name="add-product" type="text"/>
                <form:errors path="productName" class = "error" />
        </div>
        <div id="product-category">
            Wybierz kategorię
                <div id="category-checkbox">
                    <form:select path="category">
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </form:select>
                </div>
        </div>
                <div id="product-description">
                    Opis przedmiotu
                </div>
                <div id="text-area">
                    <form:textarea path="productDescription" id="textarea-product-description"/>
                    <form:errors path="productDescription" class="error"/>
                </div>
                <div id="product-price">
                    <label>Podaj cenę </label>
                        <form:input path="productPrice" type="text"/>
                        <form:errors path="productPrice" class="error"/>
                </div>
                <div id="product-photo-add">
                     Dodaj zdjęcie
                        <input name="image" type="file"/>
                        <p id="product-photo-info">* dodanie zdjęcia zwiększy szansę na sprzedaż przedmiotu.</p>
                </div>
                <div id="add-product-button">
                      <button type="submit" class="login-button">Prześlij</button>
                </div>
            </form:form>
    </div>
</html>

