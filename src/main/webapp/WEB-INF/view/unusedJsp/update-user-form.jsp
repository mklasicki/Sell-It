<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Edytuj profil</title>
</head>
<body>
    <div id="addUserForm">
        <div id="header">
            <h2 class="update-user-header">Edytuj dane konta</h2>
        </div>
        <form:form id="userFormTable" action="update" modelAttribute="userDTO" method="post">
                <form:hidden path="id" />
            <div class="user-form-input">
                <span class="user_form_input-label"><label for="username">Imię</label></span><br/>
                <form:input path="username" placeholder="Imię" />
                <form:errors path="username" class="error" />
            </div>
            <div class="user-form-input">
                <span class="user_form_input-label"><label for="lastName">Nazwisko</label></span><br/>
                <form:input path="lastName" placeholder="Nazwisko" />
                <form:errors path="lastName" class="error" />
            </div>
            <div class="user-form-input">
                <span class="user_form_input-label"><label for="password">Hasło</label></span><br/>
                <form:password path="password" placeholder="password" />
                <form:errors path="password" class="error" />
            </div>
            <div class="user-form-input">
                <span class="user_form_input-label"><label for="email">E-mail</label></span><br/>
                <form:input path="email" placeholder=" e-mail" />
                <form:errors path="email" class="error" />
            </div>
             <div class="user-form-input">
                <input id="submitButton" type="submit" value="Zatwierdź">
            </div>
        </form:form>
    </div>

    <div id="main-page-link">
        <a href="/my-page">Wróc do swojej strony.</a>
    </div>

</body>
       </html>