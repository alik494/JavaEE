<%@ page import="logic.Cart" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.09.2020
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Cart cart = (Cart) session.getAttribute("cart");%>
<% String name=cart.getName();%>
<% int quantity=cart.getQuantity();%>
<%="Your order " + name + " " + quantity%>
</body>
</html>
