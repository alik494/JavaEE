<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.09.2020
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Testing JSP</h1>

<%--    <%@page import="java.util.Date, logic.TestClass" %>--%>
<%--    <% TestClass testClass= new TestClass(); %>--%>
<%--    <%= testClass.getInfo() %>--%>

        <% String name=request.getParameter("name");%>
        <% String surname=request.getParameter("surname");%>
        <%="Hello world "+name+" " + surname%>
</body>
</html>
