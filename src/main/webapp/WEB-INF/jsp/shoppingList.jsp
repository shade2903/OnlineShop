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
    <% AnnotationConfigApplicationContext context = SpringContext.getApplicationContext();
        DataService service = (DataService) context.getBean("dataService");
        UserRepository userRepository = (UserRepository) context.getBean("userRepository");
        ProductService productService = (ProductService) context.getBean("productService");
        OrderRepository orderRepository = (OrderRepository) context.getBean("orderRepository");
        ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");

        userRepository.addUser((String) session.getAttribute("userName"));
        ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("selectList");
        int userId = userRepository.getIDbyName(session.getAttribute("userName").toString());
        Integer num = 1;
        Double total = productService.getTotalPrice(list);
        orderRepository.addOrder(userId, total);
        for (Product str : list) {
            orderRepository.saveOrderPrice(orderRepository.getIdByUSerId(userId), str);
        }
    %>
    <h1>Dear <%out.print(" " + session.getAttribute("userName") + ", ");%>you order:</h1>

    <c:forEach var="product" items="${selectList}">
        <option><%=num++%>) ${product.name} (${product.price}$)</option>

        <input type="hidden" name=selectList value="${product.name}">
    </c:forEach>
    <% out.print("<div>" + "Total: $ " + total + " $</div>"); %>


</div>
</body>
</html>
