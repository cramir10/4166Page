<%-- 
    Document   : delete
    Created on : Sep 9, 2018, 4:42:27 PM
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
        <p>User <a title="logout" href="login.jsp">Logout</a></p>
        <h1 id="head">Are you sure you want to delete this product?</h1>
        <h3 id="deleteProduct">Code: </h3><br>
        <h3 id="deleteProduct">Description: </h3><br>
        <h3 id="deleteProduct">Price: </h3>
        <button class="deleteButtons"type="button">Yes</button>
        <button class="deleteButtons"type="button">No</button>
    </body>
</html>
