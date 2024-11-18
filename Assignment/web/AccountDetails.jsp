<%-- 
    Document   : AccountDetails
    Created on : Jun 28, 2024, 11:02:02 PM
    Author     : admin
--%>

<%@page import="Models.DTO.Account.Account"%>
<%@page import="Models.AccountDAO.Service.AccountService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String accountid = request.getParameter("txtAccountID");
            if(accountid != null){
                AccountService accountService = new AccountService();
                Account account = (Account) request.getAttribute("AccountDetails");
                if(account != null){
              %>  
        
        <h1>Update Car</h1>
    <div class="AddCarForm">
        <form action="AccountController" method="post">
            AccountID <br>
            <input type="type" readonly="true" name="txtAccountID" value=<%=account.getAccountID()%>><br>
            UserName <br>
            <input type="text" name="txtUserName" value=<%=account.getUserName()%>><br>
            Password <br>
            <input type="password" name="txtPassword" value=<%=account.getPassword()%>><br>
            FullName <br>
            <input type="text"name="txtFullName" value=<%=account.getFullName()%>><br>
            <input type="checkbox" name="chkIsType" <% if (account.isType()) {%> checked <%}%>>isType <br>
            <input type="submit" name="action" value="Update">
            <a href="DisplayListAccount">Back</a>
        </form>
    </div>
            <%
           }
            }
        %>
    </body>
</html>
