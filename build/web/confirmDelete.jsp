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
        <h3 id="deleteProduct">Code: </h3><br>
        <h3 id="deleteProduct">Description: </h3><br>
        <h3 id="deleteProduct">Price: </h3>
        <button class="deleteButtons"type="button">Yes</button>
        <button class="deleteButtons"type="button">No</button>
<%@ include file="footer.jsp" %>