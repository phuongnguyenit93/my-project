<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <spring:url value="/resources/css/css2.css" var="mainCss" />
	<spring:url value="/resources/js/js2.js" var="jqueryJs" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value="/resources/css/css1.css" />" rel="stylesheet">
    <link href="${mainCss}" rel="stylesheet">
    <script src="<c:url value="/resources/js/js1.js" />"></script>
    <script src="${jqueryJs}"></script>
    <title>Document</title>
</head>
<body>
    <h1 class="new-h1">Hello ${msg}</h1>
    <h2>Me</h2>
</body>
</html>