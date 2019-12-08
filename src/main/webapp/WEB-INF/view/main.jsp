<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<head>
    <title>Strona główna</title>
</head>
<body>
<div id="container">
    <div id="label">
        <h1>Siemanko na pierwszej stronie!!</h1>
    </div>
    <div id="link">
        <p><a href="${pageContext.request.contextPath}/list">Lista klientów.</a></p>
        <p><a href="${pageContext.request.contextPath}/showFormForAdd">Dodaj klienta.</a></p>
    </div>
</div>
</body>