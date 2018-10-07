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
        <h1>Sign-up Form</h1>
        <form id="signup" action="products.jsp" method="post">
            <div> <label>First Name: </label><input type="text" name="first"></div> 
            <div> <label> Last Name: </label><input type="text" name="last"></div>
            <div> <label>Email: </label><input type="email" name="email"></div>
            <div> <label>Username: </label><input type="text" name="user"></div>
            <div> <label> Password: </label><input type="password" name="pass" minlength="8"></div>
            <input type="submit" value="Sign Up" >
        </form>
        
    </body>
</html>
