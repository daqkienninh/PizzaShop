<%-- 
    Document   : CreateProduct
    Created on : Jul 8, 2024, 7:02:40 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./AddCateStyle.css">
    </head>
    <body>
        <h1>Add New Product</h1>
    <div class="AddCarForm">
        <form action="CreateProductController" method="post">
            ProductID <br>
            <input type="text" placeholder="ex: 1" name="txtProductID"><br>
            ProductName <br>
            <input type="text" name="txtProductName"><br>
            SupplierID <br>
            <input type="text" name="txtSupplierID"><br>
            CategoryID <br>
            <input type="text" placeholder="ex: 1" name="txtCategoryID"><br>
            Quantity <br>
            <input type="text" name="txtQuantity"><br>
            Price <br>
            <input type="text" name="txtPrice"><br>
            Image <br>
            <input type="text" name="txtImg"><br>
            <button type="submit" name="btnAction" id="btn">Create</button>
            <button type="submit" formaction="DisplayListCategory" id="btn">Back</button>
        </form>
    </div>
    </body>
</html>
