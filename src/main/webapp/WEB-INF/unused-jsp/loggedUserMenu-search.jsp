<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<div id="menu">
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
<div id="main-page-search-item-form">
    <form:form action="/product/search" modelAttribute="products"  method="get">
        <input type="text"  name="productName" placeholder="Szukaj.."/>
        <button id="search-button" type="submit">Szukaj</button>
    </form:form>
</div>