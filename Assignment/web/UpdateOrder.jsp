<%-- 
    Document   : UpdateOrder
    Created on : Jul 10, 2024, 12:32:54 AM
    Author     : admin
--%>

<%@page import="Models.DTO.OrderDAO.OrderDAO"%>
<%@page import="Models.DTO.Order.Order"%>
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
            String ordID = request.getParameter("txtOrderID");
            if(ordID != null){
                OrderDAO categoryDAO = new OrderDAO();
                Order order = (Order) request.getAttribute("OrdDetail");
                if(order != null){
                
              %>  
        
        <h1>Update Order</h1>
    <div class="AddCarForm">
        <form action="UpdateOrderDetailController" method="post">
              OrderID <br>
              <input type="text"  name="txtOrderID" readonly="true" value="<%=order.getOrderID()%>"><br>
            CustomerID <br>
            <input type="text" name="txtCustomerID" readonly="true" value="<%=order.getCustomerID()%>"><br>
            OrderDate <br>
            <input type="text" name="txtOrderDate" value="<%=order.getOrderDate()%>"><br>
            RequiredDate <br>
            <input type="text" name="txtReqDate" value="<%=order.getRequiredDate()%>"><br>
            ShipDate <br>
            <input type="text" name="txtShipDate" value="<%=order.getShippedDate()%>"><br>
            ShipAdress <br>
            <input type="text" name="txtShipAddress" value="<%=order.getShipAddress()%>"><br>
            Freight <br>
            <input type="text" name="Freight" readonly="true" value="<%=order.getFreight()%>"><br>
            <button type="submit" name="btnAction" id="btn">Save</button>
            <button type="submit" formaction="OrderdetailListController" id="btn">Back</button>
        </form>
    </div>
            <%
           }
            }
        %>
    </body>
</html>
