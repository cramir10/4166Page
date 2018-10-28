<%-- 
    Document   : delete
    Created on : Sep 9, 2018, 4:42:27 PM
    Author     : axelarator
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<%@ include file="header.jsp" %>
        <p>User <a title="logout" href="login.jsp">Logout</a></p>
        <h1 id="head">Are you sure you want to delete this product?</h1>
        <h3 id="deleteProduct">Code: </h3>${deleteProduct.code}<br>
        <h3 id="deleteProduct">Description: </h3>${deleteProduct.description}<br>
        <h3 id="deleteProduct">Price: </h3>${deleteProduct.price}<br>
        
        <form class="product" action="/4166Page/productManagement" method="post">
            <input type="hidden" name="action" value="confirmDelete" />
            <a type="button" onclick="this.parentNode.submit()">Yes</a>
        </form>
        
        <a class="deleteButtons" type="button" action="/4166Page/productManagement?action=displayProducts">No</a>
<%@ include file="footer.jsp" %>