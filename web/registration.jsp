<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="Messages"/>
<html lang="${language}">
<head>
    <title>Registration</title>
</head>
<style>
    <%@include file='styles/regStyle.css' %>
</style>
<body>
<div class="container">
    <form method="post" action=/registration>
    <p style="color: red;">${errorString}</p>



        <label><fmt:message key="loginPart.login"/></label><br>
        <input type="email" name="email" placeholder="<fmt:message key="loginPart.yourLogin"/>"><br>
        <label><fmt:message key="loginPart.name"/></label><br>
        <input type="text" name="name" placeholder="<fmt:message key="loginPart.yourName"/>"><br>
        <label><fmt:message key="loginPart.pass"/></label><br>
        <input type="password" name="password" placeholder="<fmt:message key="loginPart.yourPass"/>"><br>
        <label><fmt:message key="loginPart.passConf"/></label><br>
        <input type="password" name="password2" placeholder="<fmt:message key="loginPart.yourPassConf"/>"><br>


        <input type="submit" value="<fmt:message key="loginPart.createUser" />" name="Ok" class="ok"><br>
    </form>
</div>
</body>
</html>
