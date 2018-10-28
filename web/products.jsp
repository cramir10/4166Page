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
                <td><a title="Edit" href="productManagement?action=">Edit</a>
                <form class="product" action="/4166Page/productManagement" method="post">
                    <input type="hidden" name="action" value="editProduct" />
                    <a href="#" onclick="this.parentNode.submit()">Edit Product</a>
                </form>
                </td>
                <td><a title="Delete" href="confirmDelete.jsp">Delete</a>
                <form class="product" action="/4166Page/productManagement" method="post">
                    <input type="hidden" name="action" value="deleteProduct" />
                    <a href="#" onclick="this.parentNode.submit()">Delete Product</a>
                </form>
                </td>
            </tr>
            </c:forEach>
        </table>
        <a class="productButton" id="button_add_product" href="/4166Page/productManagement?action=addProduct" >Add Product</a>
        
<%@ include file="footer.jsp" %>
