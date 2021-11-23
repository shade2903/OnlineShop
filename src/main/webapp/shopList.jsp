<%@ page import="java.util.Map" %>
<%@ page import="com.haiduk.entities.User" %>
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
<h1>Dear <% out.print(" "+ request.getSession().getAttribute("name")+ ", ");
Integer num = 1;%> you order:</h1>
<%  Double totalPrice = 0.0; %>
    <% ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("mapKey");
    for(Product x : list){
        out.print( "<option >" + num++ +")"  + x + "</option>");
    totalPrice += x.getPrice();}%>
      <%  out.print("<div>" + "Total: $ " + totalPrice + " $</div>");   %>
</div>
</body>
</html>
