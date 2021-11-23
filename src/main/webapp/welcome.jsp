<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSP</title>
    <style>
        <%@include file="WEB-INF/css/style.css"%>>
    </style>
</head>
<body>
<div class="inner">
<h1> Welcome to online shop </h1>

<form  method="post" action="/price" >
        <input class="input" required type="text" name="name" placeholder="Enter your name">
    <div>
        <input type="checkbox"  name="filter" value="true">
        <label>I agree with the terms of service</label>
    </div>

       <input class="input" type="submit" value="Enter">

    </form>
</div>

</body>
</html>