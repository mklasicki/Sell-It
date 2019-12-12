<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<head>
    <title>Strona główna</title>
</head>
<body>
<div id="container">
    <div id="label">
        <h1>Strona glówna.</h1>
    </div>
    <div id="link">
        <p><a href="${pageContext.request.contextPath}/showFormForAddUser">Załóż nowe konto.</a></p>
        <p><a href="${pageContext.request.contextPath}/list">Zaloguj się</a></p>
    </div>
</div>
</body>