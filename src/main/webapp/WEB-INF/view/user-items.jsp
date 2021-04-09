  <%@ page contentType="text/html;charset=UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


  <div id="content">
                <h3 id="category-header">Twoje ogłoszenia</h3>
                    <p><a href="/my-page">Wszystkie ogłoszenia</a></p>
                    <c:forEach var="temp" items="${products}">
                        <c:url var="deleteLink" value="/product/delete">
                            <c:param name="productId" value="${temp.id}"/>
                        </c:url>
                        <div class="product-tile">
                            <div id="photo-tile"><img class="product-photo" src="images/${temp.imageName}" alt="${name}"></div>
                            <div id="name-tile">${temp.productName}</div>
                            <div id="description-tile">${temp.productDescription}</div>
                            <div id="price-tile">${temp.productPrice}</div>
                            <div id="action-tile">
                                Edytuj /
                                <a href="${deleteLink}"
                                onclick="if(!(confirm('Czy napewno usunąć ten produkt z listy??')))return false">Usuń</a></div>
                            </div>
                    </c:forEach>
            </div>