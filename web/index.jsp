<%-- 
    Document   : index
    Created on : Sep 9, 2018, 4:41:39 PM
    Author     : axelarator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
        <link rel="stylesheet" href="style.css"> 
    </head>
    <body>
        <%
            session.invalidate();
            out.print("Session ID: " + session.getId());
            
        %>
        <h1 id="head">Product Management</h1>
        <a title="View Products" href="products.jsp">View Products</a>
    </body>
</html>
