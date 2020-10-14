
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="Messages" scope="session"/>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<%@ page isELIgnored="false" %>

<html lang="${language}">
  <head>
    <title>Main page</title>
  </head>
  <style>
      <%@include file='styles/regStyle.css' %>
  </style>
  <body>

  <div class = "container">
  <button onclick="location.href='/login.jsp'"><fmt:message key="loginPart.signInUser" />  </button><p>
    <button onclick="location.href='/registration'"><fmt:message key="loginPart.linkToRegisterForm" /></button><p>
      <form>
          <select id="language" name="language" onchange="submit()">
              <option value="uk" ${language == 'uk' ? 'selected' : ''}>Ukrainian</option>
              <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
          </select>
      </form>
  </div>
  </body>
</html>
