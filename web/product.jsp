<%-- 
    Document   : product
    Created on : Sep 9, 2018, 4:42:15 PM
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
        <h1 id="head">Product</h1>
        <form id="product" action="products.jsp" method="post">
            Code: <input type="text" name="code"><br>
            Description: <textarea name="description" cols="50" rows="4"></textarea><br>
            Price: <input type="text" name="price"><br>
            <input type="submit" id="productButton" value="Update Product"><br>
            
        </form>
        <form id="product" action="products.jsp">
            <input type="submit" id="productButton" value="View Products">
        </form>
        
    </body>
</html>
