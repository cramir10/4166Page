<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>


        <h1 id="head">Products</h1>
        <table>
            <tr id="heading">
                <th>Code</th>
                <th>Description</th>
                <th>Price</th>
                <th>&nbsp;</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach var="element" items="${sessionScope.products}">
            <tr>
                <td><c:out value="${element.code}"/></td>
                <td><c:out value="${element.description}"/></td>
                <td><c:out value="${element.price}"/></td>
                <td>
                    <a title="Edit" href="productManagement?action=displayProducts&productCode=${element.code}">Edit</a>
                </td>
                <td>
                    <a href="productManagement?action=deleteProduct&productCode=${element.code}">Delete</a>
                </td>
            </tr>
            </c:forEach>
        </table>
<!--        <a class="productButton" id="button_add_product" href="/4166Page/productManagement?action=addProduct" >Add Product</a>-->
        <form action="productManagement" method="get">
            <input type="hidden" name="action" value="addProduct">
            <p><input type="submit" value="Add Product"></p>
        </form>
        
<%@ include file="footer.jsp" %>
