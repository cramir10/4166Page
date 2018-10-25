<%@ include file="header.jsp" %>

        <h1 id="head">Products</h1>
        <table>
            <tr id="heading">
                <th>Code</th>
                <th>Description</th>
                <th>Price</th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <td>8601</td>
                <td>86 (the band) - True Life Songs and Pictures</td>
                <td>$15.95</td>
                <td><a title="Edit" href="product.jsp">Edit</a></td>
                <td><a title="Delete" href="confirmDelete.jsp">Delete</a></td>
            </tr>
            <tr>
                <td>pf01</td>
                <td>Paddlefoot - The first CD</td>
                <td>$12.95</td>
                <td><a title="Edit" href="product.jsp">Edit</a></td>
                <td><a title="Delete" href="confirmDelete.jsp">Delete</a></td>
            </tr>
            <tr>
                <td>pf02</td>
                <td>Paddlefoot - The second CD</td>
                <td>$14.95</td>
                <td><a title="Edit" href="product.jsp">Edit</a></td>
                <td><a title="Delete" href="confirmDelete.jsp">Delete</a></td>
            </tr>
            <tr>
                <td>jr01</td>
                <td>Joe Rut - Genuine Wood Grained Finish</td>
                <td>$14.95</td>
                <td><a title="Edit" href="product.jsp">Edit</a></td>
                <td><a title="Delete" href="confirmDelete.jsp">Delete</a></td>
            </tr>
        </table>
        <a class="productButton" id="button_add_product" href="product.jsp" >Add Product</a>
        
    <%@ include file="footer.jsp" %>
