<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<security:authorize access="!isAuthenticated()">
    <div class="registration-container">
        <section class="registration">
            <h2 class="registration-form_header">Załóż nowe konto</h2>
        </section>
        <form:form action="save" modelAttribute="UserDTO" method="post">
            <div class="user-form-input">
                <p class="error"><form:errors path="username"/></p>
                <label for="username">Imię: </label>
                <form:input path="username" placeholder="imię.." cssErrorClass="error"/>
            </div>
            <div class="user-form-input">
                <p class="error">  <form:errors path="lastName" class="error" /></p>
                <label for="lastName">Nazwisko: </label>
                <form:input path="lastName" placeholder="nazwisko.." cssErrorClass="error" />
            </div>
            <div class="user-form-input">
                <p class="error"><form:errors path="login" class="error" /></p>
                <label for="login">Login: </label>
                <form:input path="login" placeholder="login.." cssErrorClass="error" />
            </div>
            <div class="user-form-input">
                <p class="error"><form:errors path="password" class="error" /></p>
                <label for="password">Hasło: </label>
                <form:password path="password" placeholder="hasło.." cssErrorClass="error" />
            </div>
            <div class="user-form-input">
                <p class="error"><form:errors path="email" class="error" /></p>
                <label for="email">E-mail: </label>
                <form:input path="email" placeholder=" e-mail.." cssErrorClass="error" />
            </div>
            <div>
                <p class="error"> <form:errors path="enabled" class="error" /></p>
                <label class="check">Akceptuje warunki regulaminu.</label>
                <form:checkbox path="enabled" class="check" />
            </div>
            <div class="user-form-input">
                <input class="submit-button" type="submit" value="Zatwierdź">
            </div>
        </form:form>
    </div>
    <div class="main-page_link">
        <a href="/main">Powrót do strony głównej</a>
    </div>
</security:authorize>

<security:authorize access="isAuthenticated()">
    <div class="registration-container">
        <section class="registration">
            <h2 class="update-user-header">Edytuj dane konta</h2>
        </section>
        <form:form class="user-form-input" action="update" modelAttribute="UserDTO" method="post">
            <form:hidden path="id" />
                <div class="user-form-input">
                    <span class="user_form_input-label"><label for="username">Imię</label></span>
                    <form:input path="username" placeholder="Imię" />
                    <form:errors path="username" class="error" cssErrorClass="error" />
                </div>
                <div class="user-form-input">
                    <span class="user_form_input-label"><label for="lastName">Nazwisko</label></span>
                    <form:input path="lastName" placeholder="Nazwisko" />
                    <form:errors path="lastName" class="error" cssErrorClass="error" />
                </div>
                <div class="user-form-input">
                    <span class="user_form_input-label"><label for="password">Hasło</label></span>
                    <form:password path="password" placeholder="password" />
                    <form:errors path="password" class="error" cssErrorClass="error" />
                </div>
                <div class="user-form-input">
                    <span class="user_form_input-label"><label for="email">E-mail</label></span>
                    <form:input path="email" placeholder=" e-mail" />
                    <form:errors path="email" class="error" cssErrorClass="error" />
                </div>
                <div class="user-form-input">
                    <input class="submit-button" type="submit" value="Zatwierdź">
                </div>
        </form:form>
    </div>
    <div id="main-page-link">
        <a href="/my-page">Wróc do swojej strony.</a>
    </div>
</security:authorize>


