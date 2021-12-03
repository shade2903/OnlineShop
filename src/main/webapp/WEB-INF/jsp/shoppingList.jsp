<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="var" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.haiduk.domain.Product" %>
<%@ page import="com.haiduk.service.ProductService" %>
<%@ page import="com.haiduk.repository.UserRepository" %>
<%@ page import="com.haiduk.repository.OrderRepository" %>
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
    <% UserRepository.addUser((String) session.getAttribute("userName"));%>
    <%Integer num = 1; %>
    <% ProductService productService = new ProductService();
        Double total = productService.getTotalPrice((ArrayList<Product>) session.getAttribute("selectList")); %>
    <h1>Dear <%out.print(" " + session.getAttribute("userName") + ", ");%>you order:</h1>

    <c:forEach var="product" items="${selectList}">
        <option><%=num++%>) ${product.name} (${product.price}$)</option>
        <input type="hidden" name=selectList value="${product.name}">
    </c:forEach>
    <% out.print("<div>" + "Total: $ " + total + " $</div>"); %>
    <% OrderRepository.addOrder(UserRepository.getIDbyName(session.getAttribute("userName").toString()),total);%>

</div>
</body>
</html>
