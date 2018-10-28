<%-- 
    Document   : login
    Created on : Sep 9, 2018, 4:43:07 PM
    Author     : axelarator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <%
            out.print("Session ID: " + session.getId());
        %>
        <c:if test="${message != null}">
            <p><c:out value="${message}"/></p>
        </c:if>
        <h1 id="head">Login</h1>
        <form id="login" action="/4166Page/membership?action=login" method="post">
            <div> <label> Username: </label><input type="text" name="user" required></div>
           <div> <label> Password: </label><input type="password" name="pass" required></div>
            <input type="submit" value="Login">
        </form>
        
        <a href="/4166Page/membership?action=signup">New user? Click here to register</a>   
    </body>
</html>
