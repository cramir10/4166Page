<%-- 
    Document   : header.jsp
    Created on : Oct 24, 2018, 8:37:46 PM
    Author     : trey
--%>

<c:choose>
    <c:when test="${User.firstName != null}">
        <p>You are currently logged in as: <c:out value="${User.lastName}"/></p>
    </c:when>
    <c:otherwise>
        <c:redirect url="/login.jsp"/>
    </c:otherwise>
</c:choose>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products Website</title>
    </head>
    <body>
        
    <form action="/4166Page/membership" method="get">
        <input type="hidden" name="action" value="logout" />
        <a href="#" onclick="this.parentNode.submit()">Logout</a>
    </form>
    
