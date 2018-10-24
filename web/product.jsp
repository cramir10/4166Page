<%-- 
    Document   : product
    Created on : Sep 9, 2018, 4:42:15 PM
    Author     : axelarator
--%>
<%
    if(session.getAttribute("loginFlag")== null) {

        response.sendRedirect("signup.jsp");
        return;
    }
    out.print("Session ID: " + session.getAttribute("loginFlag"));

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <p>User <a title="logout" href="Membership?action=logoff">Logout</a></p>
        <h1 id="head">Product</h1>
        <form class="product" action="products.jsp" method="post">
            <div><label>Code: </label><input type="text" name="code"></div>
            <div><label>Description: </label><textarea name="description" cols="50" rows="4"></textarea></div>
            <div><label>Price: </label><input type="text" name="price"></div>
            <div id="buttons">
                <input type="submit" class="productButton" value="Update Product">
                <a class="productButton" href="products.jsp" >View Products</a>
            </div>
        </form>
        
    </body>
</html>
