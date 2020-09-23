<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet">
    <title>Dodaj/Edytuj klienta.</title>
</head>
<body>
    <div class="registration-container">
        <section class="registration">
            <h2 class="registration-form_header">Załóż nowe konto</h2>
        </section>

        <form:form action="save" modelAttribute="UserDTO" method="post">
            <div class="user-form-input">
                <label for="username">Imię: </label>
                <form:input path="username" placeholder="imię" />
                <form:errors path="username" class="error" />
            </div>
            <div class="user-form-input">
                <label for="lastName">Nazwisko: </label>
                <form:input path="lastName" placeholder="nazwisko" />
                <form:errors path="password" class="error" />
            </div>
             <div class="user-form-input">
                <label for="login">Login: </label>
                <form:input path="login" placeholder="login" />
                <form:errors path="login" class="error" />
             </div>
             <div class="user-form-input">
                <label for="password">Hasło: </label>
                <form:password path="password" placeholder="password" />
                <form:errors path="password" class="error" />
            </div>
            <div class="user-form-input">
                <label for="email">E-mail: </label>
                <form:input path="email" placeholder=" e-mail" />
                <form:errors path="email" class="error" />
            </div>
            <div>
            <label class="check">Akceptuje warunki regulaminu.</label>
            <br><br>
            <form:checkbox path="enabled" class="check" />
            <form:errors path="enabled" class="error" />
            </div>
            <div class="user-form-input">
                <input class="submit-button" type="submit" value="Zatwierdź">
            </div>
        </form:form>
    </div>

    <div class="main-page_link">
        <a href="/main">Powrót do strony głównej</a>
    </div>

</body>
       </html>