<%@ page import="java.util.List" %>

<%@ page import="java.util.Map" %>
<%@ page import="com.haiduk.domain.PriceList" %><%--
  Created by IntelliJ IDEA.
  User: shade2903
  Date: 12.11.2021
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>

<body>
<h1> Welcome <%
    String name = (String) request.getAttribute("userName");
    out.print(name);

%> </h1>

<form  method="post" action="/totalPrice">
    <br />

    <div>Make you order </div>

    <select multiple name="mapKey">
        <% Map<String,Double> priceList = PriceList.getPRODUCTS();
        for(Map.Entry entry : priceList.entrySet()){
            out.print( "<option value=\"" + entry.getKey()+"\">" +entry.getKey() + " " + entry.getValue() + "$</option>");
        }
        %>




    </select>

    <br>
    <input type="submit" value="Enter">
</form>

</body>
</html>
