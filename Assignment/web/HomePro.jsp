<%-- 
    Document   : HomePro
    Created on : Jul 4, 2024, 9:32:25 PM
    Author     : admin
--%>

<%@page import="Models.DTO.Product.Product"%>
<%@page import="java.util.List"%>
<%@page import="Models.ProductDAO.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./HomeStyle.css">
    </head>
    <body>
        <div> <!--Body-->
            <div class="carlist">
                <h1>Account List</h1>
            </div>

            <div class="createNew">
                <a href="CreateProduct.jsp">Create New</a>
            </div>
        </div>
        <%
            ProductDAO productDAO = new ProductDAO();
            List<Product> productList = (List<Product>) request.getAttribute("ProdList");
            if (productList != null) {
        %>   


        <div> <!--table-->
            <table class="car">
                <thead>
                    <tr>
                        <th>ProductID</th>
                        <th>ProductName</th>
                        <th>SupplierID</th>
                        <th>CategoryId</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Img</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <%
                        for (Product product : productList) {
                    %>
                    <tr>
                        <td><%=product.getProductID()%></td>
                        <td><%=product.getProductName()%></td>
                        <td><%=product.getSupplierID()%></td>
                        <td><%=product.getCategoryID()%></td>
                        <td><%=product.getQuantityPerUnit()%></td>
                        <td><%=product.getUnitPrice()%></td>
                        <td><%=product.getProductImage()%></td>
                        <td><a href='ProductController?action=Details&txtProductID=<%=product.getProductID()%>'>Edit<a href=ProductController?action=Delete&txtProductID=<%=product.getProductID()%>> Delete</a></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
                <a href="AdminManger.jsp">Back</a>
            </table>
        </div>
        <%
        } else {
        %>
        <h3>Something went wrong</h3>
        <%
            }
        %>
    </body>
</html>
