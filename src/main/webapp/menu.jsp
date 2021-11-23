<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="var" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.haiduk.domain.PriceList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.haiduk.domain.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="WEB-INF/css/style.css"%>>
    </style>
</head>

<body>

<div class="inner">
<h1> Welcome <%out.print(request.getSession().getAttribute("name")+ " !");%> </h1>

<form  method="post" action="/price ">
    <br />
    <div>Make you order </div>
    <select  name="mapKey">
        <% ArrayList<Product> priceList = PriceList.getListProduct();
            for(Product o : priceList){
                out.print( "<option value=\"" + o.getName() +"\">" + o + "</option>");
            }
        %>
    </select>
    <br>
    <input type="button" value="Add Item" onclick=""/>
    <input type="submit" value="Submit">
</form>
    <form>
        <c:forEach var="product" items= "${requestScope.selectList}" >
            <ul>
                <li><c:out value="${product.name}"/></li>
                <li><c:out value="${product.price}"/></li>
            </ul>
        </c:forEach>
    </form>
    </div>
</body>
</html>
