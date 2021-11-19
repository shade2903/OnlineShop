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
       .input{
           width: 200px;
           height: 30px;

       }
</style>
<div class="inner">
<h1> Welcome to online shop </h1>

<form  method="post" action="/price" >
        <input class="input" required type="text" name="name" placeholder="Enter your name">
    <div>
        <input type="checkbox"  name="scales" checked>
        <label>I agree with the terms of service</label>
    </div>

       <input class="input" type="submit" value="Enter">

    </form>
</div>

</body>
</html>