<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Dodaj/Edytuj klienta.</title>
</head>
<body>
    <div id="addUserForm">
        <div id="header">
            <h2>Załóż nowe konto</h2>
        </div>

        <form:form id="userFormTable" action="saveUser" modelAttribute="userDTO" method="post">
            <div class="user-form-input">
                <label for="username">Login: </label>
                <form:input path="username" placeholder=" login" />
            </div>
            <div class="user-form-input">
                <label for="password">Hasło: </label>
                <form:password path="password" placeholder="password" />
            </div>
            <div class="user-form-input">
                <label for="email">E-mail: </label>
                <form:input path="email" placeholder=" e-mail" />
            </div>
            <div class="user-form-input">
                <input id="submitButton" type="submit" value="Zatwierdź">
            </div>
        </form:form>
    </div>

    <div id="main-page-link">
        <a href="${pageContext.request.contextPath}/">Powrót do strony głównej</a>
    </div>



</body>
       </html>