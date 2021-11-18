<%@ page import="java.util.Map" %>
<%@ page import="com.haiduk.entities.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.haiduk.domain.Product" %><%--
  Created by IntelliJ IDEA.
  User: shade2903
  Date: 12.11.2021
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    .inner {
        margin: auto;
        text-align: center}
</style>
<div class="inner">
<h1>Dear <%
    User user = User.getInstance();
    out.print(" "+ user.getName()+ ", ");
    Integer num = 1;

%> you order:</h1>
<%  Double totalPrice = 0.0; %>
    <% ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("mapKey");
    for(Product x : list){
        out.print( "<option >" + num++ +")"  + x + "</option>");
    totalPrice += x.getPrice();}%>
      <%  out.print("<div>" + "Total: $ " + totalPrice + " $</div>");   %>

        </div>
</body>
</html>
