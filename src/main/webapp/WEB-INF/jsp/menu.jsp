<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="var" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.haiduk.domain.PriceList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.haiduk.domain.Product" %>
<%@ page import="com.haiduk.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<% User user = new User(session.getAttribute("userName").toString()); %>--%>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="../css/style.css"%> >
    </style>
</head>

<body>

<div class="inner">
    <h1> Welcome <%out.print(session.getAttribute("userName") + " !");%></h1>
<%--    <h1> Welcome <%out.print(user.getName()+ " !");%></h1>--%>

    <form method="post" action="/price">
        <br/>
        <div>Make you order</div>
        <select name="mapKey">

            <c:forEach var="product" items="${products}">
                <option value="${product.name}">${product.name} (${product.price}$)</option>
            </c:forEach>
            <input type="hidden" name="filter" value="true">
<%--            <input type="hidden" name="userName" value="${session.getAttribute("userName").toString()}">--%>

        </select>
        <br>
        <input type="submit" value="Add Item"/>

    </form>

    <form method="post" action="/totalPrice">

        <input type="submit" value="Submit">
        <p>You have already chosen:</p>

        <c:forEach var="product" items="${selectList}">
        <option value="${product.name}">${product.name} (${product.price}$)</option>
        <input type="hidden" name=selectList value="${product.name}">

        </c:forEach>
</div>

</form>


</div>
</body>
</html>
