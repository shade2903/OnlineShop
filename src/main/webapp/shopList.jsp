<%@ page import="java.util.Map" %>
<%@ page import="com.haiduk.entities.User" %><%--
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
<div>Shopping LIST<%
    User user = User.getInstance();
    out.print(" "+ user.getName());

%></div>
<%  Double totalPrice = 0.0;
    Map<String,Double> priceList = (Map<String, Double>) request.getAttribute("data");
    for(Map.Entry<String,Double> entry : priceList.entrySet()){
        out.print( "<option value=\"" + entry.getKey()+"\">" +entry.getKey() + " " + entry.getValue() + " $</option>");
        totalPrice += entry.getValue();
    }

    out.print("<div>" + totalPrice + " $<div>");
%>

</body>
</html>
