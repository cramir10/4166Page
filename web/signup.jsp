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
        <%
            session.invalidate();
            out.print("Session ID: " + session.getId());
            
        %>
        <h1>Sign-up Form</h1>
        <form id="signup" action="/4166Page/membership?action=signup" method="post">
            <div> <label>First Name: </label><input type="text" name="first" required=""></div> 
            <div> <label> Last Name: </label><input type="text" name="last" required></div>
            <div> <label>Email: </label><input type="email" name="email" required></div>
            <div> <label>Username: </label><input type="text" name="user" required></div>
            <div> <label> Password: </label><input type="password" name="pass" minlength="8" required></div>
            <input type="submit" value="Sign Up" >
        </form>
        
    </body>
</html>
