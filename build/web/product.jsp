<%-- 
    Document   : product
    Created on : Sep 9, 2018, 4:42:15 PM
    Author     : axelarator
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
        
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
<%@ include file="footer.jsp" %>
