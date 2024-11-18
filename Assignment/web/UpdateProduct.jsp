<%-- 
    Document   : UpdateProduct
    Created on : Jul 8, 2024, 10:05:30 PM
    Author     : admin
--%>

<%@page import="Models.DTO.Product.Product"%>
<%@page import="Models.ProductDAO.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./AddCateStyle.css">
    </head>
    <body>
        <%
            String prodID = request.getParameter("txtProductID");
            if(prodID != null){
                ProductDAO productDAO = new ProductDAO();
                Product product = (Product) request.getAttribute("ProductDetail");
                if(product != null){
                
              %>  
        
        <h1>Update Product</h1>
    <div class="AddCarForm">
        <form action="UpdateProductController" method="post">
              ProductID <br>
            <input type="text" placeholder="ex: 1" name="txtProductID" value="<%=product.getProductID()%>"><br>
            ProductName <br>
            <input type="text" name="txtProductName" value="<%=product.getProductName()%>"><br>
            SupplierID <br>
            <input type="text" name="txtSupplierID" value="<%=product.getSupplierID()%>"><br>
            CategoryID <br>
            <input type="text" placeholder="ex: 1" name="txtCategoryID" value="<%=product.getCategoryID()%>"><br>
            Quantity <br>
            <input type="text" name="txtQuantity" value="<%=product.getQuantityPerUnit()%>"><br>
            Price <br>
            <input type="text" name="txtPrice" value="<%=product.getUnitPrice()%>"><br>
            Image <br>
            <input type="text" name="txtImg" value="<%=product.getProductImage()%>"><br>
            <button type="submit" name="btnAction" id="btn">Save</button>
            <button type="submit" formaction="DisplayProductAdmin" id="btn">Back</button>
        </form>
    </div>
            <%
           }
            }
        %>
    </body>
</html>
