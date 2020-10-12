
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
    <label><fmt:message key="email" /></label><br>
    <input name="email"/><br><br>
    <label><fmt:message key="password" /></label><br>
    <input name="password"/><br><br>
    <input type="submit" value='<fmt:message key="send"/>'>
</form>
</div>
<a href='<c:url value="/" />'><fmt:message key="home"/></a>
</body>
</html>
