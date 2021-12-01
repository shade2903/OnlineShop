<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="var" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1> Welcome <%out.print(session.getAttribute("userName") + " !");%></h1>

    <form method="post" action="/priceList">
        <br/>
        <h3>Make you order</h3>
        <select class="input" name="mapKey">

            <c:forEach var="product" items="${products}">
                <option value="${product.name}">${product.name} (${product.price}$)</option>
            </c:forEach>
            <input type="hidden" name="filter" value="true">

        </select>
        <br>
        <input class="input" type="submit" value="Add Item"/>

    </form>

    <form method="post" action="/totalPriceList">

        <input class="input" type="submit" value="Submit">
        <p>You have already chosen:</p>
        <c:forEach var="product" items="${clickList}">
        <option value="${product.name}">${product.name} (${product.price}$)</option>
        <input type="hidden" name=selectList value="${product.name}">
        </c:forEach>
</div>

</form>


</div>
</body>
</html>
