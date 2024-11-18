<%-- 
    Document   : AdminManger
    Created on : Jun 27, 2024, 4:20:57 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="DisplayListAccount">Manger User</a> <br>
        <a href="DisplayListCategory">Manage Category</a> <br>
        <a href="DisplayProductAdmin">Manage Product</a> <br>
        <a href="OrderdetailListController">Manage Order</a> <br>
        <form action="LogoutController" method="post">
            <input type="submit" name="action" value="Logout"/>
        </form>
    </body>
</html>
