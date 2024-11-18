<%-- 
    Document   : HomeOrder
    Created on : Jul 10, 2024, 12:04:12 AM
    Author     : admin
--%>

<%@page import="Models.DTO.Order.Order"%>
<%@page import="Models.DTO.OrderDAO.OrderDAO"%>
<%@page import="Models.DTO.Order.OrderDetails"%>
<%@page import="java.util.List"%>
<%@page import="Models.DTO.OrderDAO.OrderDetailsDAO"%>
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
                <h1>Order List</h1>
            </div>
        </div>
        <%
            OrderDAO orderDAO = new OrderDAO();
            List<Order> orderList = (List<Order>) request.getAttribute("OrderList");
            if (orderList != null) {
        %>   


        <div> <!--table-->
            <table class="car">
                <thead>
                    <tr>
                        <th>OrderID</th>
                        <th>CustomerID</th>
                        <th>OrderDate</th>
                        <th>RequiredDate</th>
                        <th>ShippedDate</th>
                        <th>Freight</th>
                        <th>ShipAddress</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <%
                        for (Order order : orderList) {
                        
                    %>
                    <tr>
                        <td><%=order.getOrderID()%></td>
                        <td><%=order.getCustomerID()%></td>
                        <td><%=order.getOrderDate()%></td>
                        <td><%=order.getRequiredDate()%></td>
                        <td><%=order.getShippedDate()%></td>
                        <td><%=order.getFreight()%></td>
                        <td><%=order.getShipAddress()%></td>
                        <td><a href='OderController?action=Detail&txtOrderID=<%=order.getOrderID()%>'>Update</a></td>
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
