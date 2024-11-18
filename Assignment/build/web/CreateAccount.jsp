<%-- 
    Document   : CreateAccount
    Created on : Jul 1, 2024, 2:33:40 PM
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
        <form action="CreateAccountController" method="post">
            UserName <input type="text" placeholder="Enter user name" name="txtUserName"> <br>
            Password <input type="password" placeholder="Enter password" name="txtPassword"> <br>
            FullName <input type="text" placeholder="Enter last name" name="txtFullName"> <br>
            <button type="submit" name="btnAction" id="btn">Create</button>
            <button type="submit" formaction="DisplayListCategory" id="btn">Back</button>
        </form>
    </div>
    </body>
</html>
