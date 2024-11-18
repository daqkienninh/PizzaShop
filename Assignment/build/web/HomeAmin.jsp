<%-- 
    Document   : HomeAmin
    Created on : Jun 28, 2024, 9:40:48 PM
    Author     : admin
--%>

<%@page import="java.util.List"%>
<%@page import="Models.DTO.Account.Account"%>
<%@page import="Models.AccountDAO.Service.AccountService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./HomeStyle.css">
    </head>
    <body>
        <h2 class="titleHearder">Home page</h2>
        <div class="header"> <!--Header-->
            <div class="AutomobileWebApp">
                <h3>AutomobileWebApp</h3>
            </div>

            <div class="HomeHeader">
                <p>Home</p>
            </div>

            <div class="PrivacyHeader">
                <p>Privacy</p>
            </div>
        </div>

        <div> <!--Body-->
            <div class="carlist">
                <h1>Account List</h1>
            </div>

            <div class="createNew">
                <a href="CreateAccount.jsp">Create New</a>
            </div>
        </div>
        <%
            AccountService accountService = new AccountService();
            List<Account> accountList = (List<Account>) request.getAttribute("AccountList");
            if (accountList != null) {
        %>   


        <div> <!--table-->
            <table class="car">
                <thead>
                    <tr>
                        <th>AccountID</th>
                        <th>UserName</th>
                        <th>Password</th>
                        <th>FullName</th>
                        <th>Type</th>
                    </tr>
                </thead>

                <tbody>
                    <%
                        for (Account account : accountList) {
                    %>
                    <tr>
                        <td><%=account.getAccountID()%></td>
                        <td><%=account.getUserName()%></td>
                        <td><%=account.getPassword()%></td>
                        <td><%=account.getFullName()%></td>
                        <td><input type="checkbox" <% if (account.isType()) {%> checked <%}%> readonly="true"></td>
                        <td><a href='AccountController?action=Details&txtAccountID=<%=account.getAccountID()%>'>Edit<a href=AccountController?action=Delete&txtAccountID=<%=account.getAccountID()%>> Delete</a></td>
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
