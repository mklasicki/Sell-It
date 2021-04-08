<%@ page contentType="text/html;charset=UTF-8" %>
<div id="menu">
    <ol>
        <li><a href="/product/add-form">Nowe Ogłoszenie</a></li>
        <li><a href="/login">Zaloguj się</a></li>
        <li><a href="/user/register">Załóż konto</a></li>
    </ol>
</div>
<div id="main-page-search-item-form">
    <form:form action="product/search" modelAttribute="products"  method="get">
        <input type="text"  name="productName" placeholder="Szukaj.."/>
        <button id="search-button" type="submit">Szukaj</button>
    </form:form>
</div>