<!DOCTYPE html>
<html lang="pl">
<%@ page contentType="text/html;charset=UTF-8" %>

<head>
    <title>Potwierdzenie założenia konta</title>
    <META http-equiv="refresh" content="5;URL=http://localhost:8080/main">
     <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,400;1,700&display=swap" rel="stylesheet">
    <link href="/resources/css/registrationSuccess.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="main-header">Witaj ${registerUserDTO.username}!</h1>
        <section class="login-credentials">
            <p>Twoje dane to:</p>
            <p>Login: ${registerUserDTO.username}</p>
            <p>Adres mail: ${registerUserDTO.email}</p>
        </section>
        <section class="mail-info_message">
            <p>Na Twojego maila zostało wysłane potwierdzenie rejestracji oraz dane do logowania.</p>
        </section>
        <h2 class="redirect-info">Zostaniesz automatycznie przekierowany na stronę główna za 5 sekund...</h2>
</body>