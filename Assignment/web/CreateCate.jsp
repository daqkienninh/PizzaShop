<%-- 
    Document   : CreateCate
    Created on : Jul 8, 2024, 6:49:05 PM
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
           <h1>Add New Category</h1>
    <div class="AddCarForm">
        <form action="CreateCategoryController" method="post">
            CategoryID <br>
            <input type="text" placeholder="ex: 1" name="txtCategoryID"><br>
            CategoryName <br>
            <input type="text" name="txtCategoryName"><br>
            Description <br>
            <input type="text" name="txtDescription"><br>
            <button type="submit" name="btnAction" id="btn">Create</button>
            <button type="submit" formaction="DisplayListCategory" id="btn">Back</button>
        </form>
    </div>
    </body>
</html>
