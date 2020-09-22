<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>

<head>
<title>Potwierdzenie edycji danych</title>
<META http-equiv="refresh" content="5;URL=http://localhost:8080/main">
<html lang="pl">
</head>
<body>
    <div align = "center">
        <h1>Udało się zmodyfikować dane</h1>
        <hr>
        <p>Twoje dane to:</p>
        <p>Login: ${userDTO.username}</p>
        <p>Adres mail: ${userDTO.email}</p>
        <br>
        <h2>Zostaniesz automatycznie przekierowany na stronę główna za 5 sekund...</h2>
</body>