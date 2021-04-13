<html lang="pl">

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<body>
    <div id="login-head">
        <h3 id="login-header"><i class="icon-user-male"></i> Zaloguj się</h3>
    </div>
    <div id="login-container">
        <div id="login-form">
            <form:form name="login" action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
                <label for="username-input">Nazwa uzytkowka</label>
                <br /><br />
                <input id="username-input" name="username" type="text">
                <br /><br />
                <label for="user-password">Hasło</label>
                <br /><br />
                <input id="user-password" name="password" type="password">
                <br /><br />
                <button class="login-button" name="submit" type="submit">Zatwierdź</button>
            </form:form>
        </div>
    <br><br>
        <div id="main-page-link-on-login-page">
            <a href="/main">Wróć na stronę główną</a>
        </div>
</body>