
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="Messages"/>
<html lang="${language}">
<head>
    <title>Registration</title>
</head>

<body>
<div class = "container">
    <form method="post" action=/registration>


        <label><fmt:message key="loginPart.yourLogin" /></label><br>
        <input type="text" name="name">
        <label><fmt:message key="loginPart.yourPass" /></label><br>
        <input type="text" name="password">

        <input type="submit" value="<fmt:message key="loginPart.createUser" />" name="Ok" class = "ok"><br>
    </form>
</div>
</body>
</html>
