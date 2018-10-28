<%-- 
    Document   : header.jsp
    Created on : Oct 24, 2018, 8:37:46 PM
    Author     : trey
--%>
<% System.out.println("The products page" + session.getId());
%>
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
        <%
            out.print("Session ID: " + session.getId());
            
        %>
    <form action="/4166Page/membership?action=logoff" method="get">
        <input type="hidden" name="action" value="logoff" />
        <a href="#" onclick="this.parentNode.submit()">Logoff</a>
    </form>
    
