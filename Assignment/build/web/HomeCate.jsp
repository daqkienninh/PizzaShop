<%-- 
    Document   : HomeCate
    Created on : Jul 4, 2024, 9:25:17 PM
    Author     : admin
--%>

<%@page import="Models.DTO.Product.Category"%>
<%@page import="java.util.List"%>
<%@page import="Models.ProductDAO.CategoryDAO"%>
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
                <h1>Category List</h1>
            </div>

            <div class="createNew">
                <a href="CreateCate.jsp">Create New</a>
            </div>
        </div>
        <%
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Category> cateList = (List<Category>) request.getAttribute("CateList");
            if (cateList != null) {
        %>   


        <div> <!--table-->
            <table class="car">
                <thead>
                    <tr>
                        <th>CateID</th>
                        <th>CateName</th>
                        <th>Description</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <%
                        for (Category category : cateList) {
                    %>
                    <tr>
                        <td><%=category.getCategoryID()%></td>
                        <td><%=category.getCategoryName()%></td>
                        <td><%=category.getDescription()%></td>
                        <td><a href='CategoryController?action=Details&txtCategoryID=<%=category.getCategoryID()%>'>Edit |</a><a href=CategoryController?action=Delete&txtCategoryID=<%=category.getCategoryID()%>> Delete</a></td>
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
