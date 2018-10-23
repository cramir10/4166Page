<%-- 
    Document   : products
    Created on : Sep 9, 2018, 4:41:58 PM
    Author     : axelarator
--%>
<!--Validate session before continuing -->
<%
    boolean flag = (boolean)session.getAttribute("loginFlag");
    if(!flag) {
        response.sendRedirect("signup.jsp");
        return;
    }
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
        <h1 id="head">Products</h1>
        <table>
            <tr id="heading">
                <th>Code</th>
                <th>Description</th>
                <th>Price</th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <td>8601</td>
                <td>86 (the band) - True Life Songs and Pictures</td>
                <td>$15.95</td>
                <td><a title="Edit" href="product.jsp">Edit</a></td>
                <td><a title="Delete" href="confirmDelete.jsp">Delete</a></td>
            </tr>
            <tr>
                <td>pf01</td>
                <td>Paddlefoot - The first CD</td>
                <td>$12.95</td>
                <td><a title="Edit" href="product.jsp">Edit</a></td>
                <td><a title="Delete" href="confirmDelete.jsp.jsp">Delete</a></td>
            </tr>
            <tr>
                <td>pf02</td>
                <td>Paddlefoot - The second CD</td>
                <td>$14.95</td>
                <td><a title="Edit" href="product.jsp">Edit</a></td>
                <td><a title="Delete" href="confirmDelete.jsp">Delete</a></td>
            </tr>
            <tr>
                <td>jr01</td>
                <td>Joe Rut - Genuine Wood Grained Finish</td>
                <td>$14.95</td>
                <td><a title="Edit" href="product.jsp">Edit</a></td>
                <td><a title="Delete" href="confirmDelete.jsp">Delete</a></td>
            </tr>
        </table>
        <a class="productButton" id="button_add_product" href="product.jsp" >Add Product</a>
        
    </body>
</html>
