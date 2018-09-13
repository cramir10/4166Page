<%-- 
    Document   : login
    Created on : Sep 9, 2018, 4:43:07 PM
    Author     : axelarator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1 id="head">Login</h1>
        <form action="" method="post">
            Username: <input type="text" name="user"><br>
            Password: <input type="password" name="pass"><br>
        </form>
        <input id="login" type="submit" value="Login" ><br>
        <a href="signup.jsp">New user? Click here to register</a>   
    </body>
</html>
