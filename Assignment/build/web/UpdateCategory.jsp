<%-- 
    Document   : UpdateCategory
    Created on : Jul 8, 2024, 7:15:30 PM
    Author     : admin
--%>

<%@page import="Models.DTO.Product.Category"%>
<%@page import="Models.ProductDAO.CategoryDAO"%>
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
            String categoryID = request.getParameter("txtCategoryID");
            if(categoryID != null){
                CategoryDAO categoryDAO = new CategoryDAO();
                Category category = (Category) request.getAttribute("CategoryDetail");
                if(category != null){
              %>  
        
        <h1>Update Category</h1>
    <div class="AddCarForm">
        <form action="UpdateCategoryController" method="post">
             CategoryID <br>
             <input type="text" readonly="true" name="txtCategoryID" value="<%=category.getCategoryID()%>"><br>
            CategoryName <br>
            <input type="text" name="txtCategoryName" value="<%=category.getCategoryName()%>"><br>
            Description <br>
            <input type="text" name="txtDescription" value="<%=category.getDescription()%>"><br>
            <button type="submit" name="btnAction" id="btn">Save</button>
            <button type="submit" formaction="DisplayListCategory" id="btn">Back</button>
        </form>
    </div>
            <%
           }
            }
        %>
    </body>
</html>
