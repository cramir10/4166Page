<%-- 
    Document   : signup
    Created on : Sep 9, 2018, 4:43:16 PM
    Author     : axelarator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Product Management</title>
    </head>
    <body>
        <h1 id="head">Sign-up Form</h1>
        <form id="signup" action="products.jsp" method="post">
            First Name: <input type="text" name="first"><br>
            Last Name: <input type="text" name="last"><br>
            Email: <input type="text" name="email"><br>
            Username: <input type="text" name="user"><br>
            Password: <input type="password" name="pass"><br>
            <input type="submit" value="Sign Up" >
        </form>
        
    </body>
</html>
