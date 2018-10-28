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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        
        <c:if test="${message != null}">
            <p><c:out value="${message}"/></p>
        </c:if>
        
        <form class="product" action="/4166Page/productManagement" method="post">
            <input type="hidden" name="action" value="addProduct" />
            <div><label>Code: </label><input type="text" name="code"></div>
            <div><label>Description: </label><textarea name="description" cols="50" rows="4"></textarea></div>
            <div><label>Price: </label><input type="text" name="price"></div>
            <a href="#" onclick="this.parentNode.submit()">Add Product</a>
        </form>
        
    </body>
</html>
