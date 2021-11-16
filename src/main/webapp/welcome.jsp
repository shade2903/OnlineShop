<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
<style>
       .inner {
            margin: auto;
            text-align: center}
</style>
<div class="inner">
<h1> Welcome to online shop </h1>

<form  method="post" action="/price" >
        <input  required type="text" name="name" placeholder="Enter your name">
    <br>
       <input type="submit" value="Enter">
    </form>
</div>

</body>
</html>