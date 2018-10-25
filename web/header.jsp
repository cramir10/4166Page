<%-- 
    Document   : header.jsp
    Created on : Oct 24, 2018, 8:37:46 PM
    Author     : trey
--%>
<%
    if(session.getAttribute("loginFlag")== null) {

        response.sendRedirect("signup.jsp");
        return;
    }
    out.print("Session ID: " + session.getAttribute("loginFlag"));

%>
<c:choose>
    <c:when test="${user.firstName != null}">
        <p>You are currently logged in as: <c:out value="${user.lastName}"/></p>
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
        <title>Web App</title>
    </head>
    <body>
        <%
            out.print("Session ID: " + session.getId());
            
        %>
    <form action="/4166Page/membership" method="POST">
        <input type="hidden" name="action" value="logoff" />
        <a href="#" onclick="this.parentNode.submit()">Logoff</a>
    </form>
    
