<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<security:authorize access="!isAuthenticated()">
<div id="menu">
    <ol>
        <li><a href="/product/add-form">Nowe Ogłoszenie</a></li>
        <li><a href="/login">Zaloguj się</a></li>
        <li><a href="/user/register">Załóż konto</a></li>
    </ol>
</div>
</security:authorize>

<security:authorize access="isAuthenticated()">
<div id="menu">
    <div>
        <ol>
            <li>
                <a href="#">
                    Witaj <security:authentication property="principal.username" /> !
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
</security:authorize>

<div id="main-page-search-item-form">
    <form:form action="/product/search" modelAttribute="products"  method="get">
        <input type="text"  name="productName" placeholder="Szukaj.."/>
        <button id="search-button" type="submit">Szukaj</button>
    </form:form>
</div>