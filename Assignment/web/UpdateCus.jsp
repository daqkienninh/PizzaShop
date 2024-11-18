<%-- 
    Document   : UpdateCus
    Created on : Jul 9, 2024, 2:39:32 PM
    Author     : admin
--%>

<%@page import="Models.DTO.Order.Customer"%>
<%@page import="Models.DTO.OrderDAO.CustomerDAO"%>
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
            String cusID = request.getParameter("txtCustomerID");
            if(cusID != null){
                CustomerDAO customerDAO = new CustomerDAO();
                Customer customer = (Customer) request.getAttribute("CustomerDetail");
                if(customer != null){
              %>  
        
        <h1>Update Customer</h1>
    <div class="AddCarForm">
        <form action="UpdateCustomerController" method="post">
              CustomerID <br>
              <input type="text"  name="txtCustomerID" readonly="true" value="<%=customer.getCustomerID()%>"><br>
            Password <br>
            <input type="text" name="txtPassword" readonly="true" value="<%=customer.getPassword()%>"><br>
            Contact Name <br>
            <input type="text" name="txtContactName" value="<%=customer.getContactName()%>"><br>
            Address <br>
            <input type="text" name="txtAddress" value="<%=customer.getAddress()%>"><br>
            Phone <br>
            <input type="text" name="Phone" value="<%=customer.getPhone()%>"><br>
            <button type="submit" name="btnAction" id="btn">Save</button>
            <button type="submit" formaction="DisplayListProduct" id="btn">Back</button>
        </form>
    </div>
            <%
           }
            }
        %>
    </body>
</html>
