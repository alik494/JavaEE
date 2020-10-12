<%--
  Created by IntelliJ IDEA.
  User: Liza
  Date: 09.04.2020
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<%@ page isELIgnored="false" %>

<html lang="${language}">
  <head>
    <title>Main page</title>
  </head>
  <body>
  <div class = "container">
  <button onclick="location.href='/login.jsp'"><fmt:message key="loginPart.login" />  </button>
    <button onclick="location.href='/registration'"><fmt:message key="loginPart.linkToRegisterForm" /></button>
      <form>
          <select id="language" name="language" onchange="submit()">
              <option value="uk" ${language == 'uk' ? 'selected' : ''}>Ukrainian</option>
              <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
          </select>
      </form>
  </div>
  </body>
</html>
