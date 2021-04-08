<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
<title><tiles:getAsString name="title" /></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,400;1,700&display=swap" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"></link>
    <link href="<c:url value="/resources/css/fontello.css" />" rel="stylesheet"></link>
</head>

<body>
    <div>
        <tiles:insertAttribute name="menu" />
        <article class="article">
		    <tiles:insertAttribute name="body" />
        </article>
    <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>