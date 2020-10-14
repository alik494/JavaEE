<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="Messages"/>
<html lang="${language}">
<head>
    <title>Log in</title>
</head>

<body>
<div class = "container">
<form method="post" action=/login>
    <label><fmt:message key="loginPart.yourLogin" /></label><br>
    <input name="email"/><br><br>
    <label><fmt:message key="loginPart.pass" /></label><br>
    <input name="password"/><br><br>
    <input type="submit" value='<fmt:message key="loginPart.signInUser"/>'>
</form>
</div>
</body>
</html>
