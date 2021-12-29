<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="var" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.haiduk.domain.Product" %>
<%@ page import="com.haiduk.service.ProductService" %>
<%@ page import="com.haiduk.repository.UserRepository" %>
<%@ page import="com.haiduk.repository.OrderRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="com.haiduk.repository.ProductRepository" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="com.haiduk.config.SpringContext" %>
<%@ page import="com.haiduk.service.DataService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="../css/style.css"%>
        >
    </style>
</head>
<body>
<div class="inner">
    <% Integer num = 1; %>
    <h1>Dear <%out.print(" " + request.getAttribute("userName") + ", ");%>you order:</h1>

    <c:forEach var="product" items="${selectList}">
        <option><%=num++%>) ${product.name} (${product.price}$)</option>
    </c:forEach>
    <% out.print("<div>" + "Total: $ " + request.getAttribute("totalPrice") + " $</div>"); %>


</div>
</body>
</html>
