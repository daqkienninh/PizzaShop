<%-- 
    Document   : ViewCart
    Created on : Jul 3, 2024, 8:03:03 PM
    Author     : admin
--%>

<%@page import="Models.DTO.OrderDAO.CustomerDAO"%>
<%@page import="Models.DTO.Order.Customer"%>
<%@page import="Models.DTO.Account.Account"%>
<%@page import="Models.Cart.CartProduct"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your Cart</h1>
        <%
            float totalAmount = 0;
            int numberOfPro = 0;
            List<CartProduct> productInCart = (List<CartProduct>)request.getAttribute("Cart");
        %>
            <%
                if(productInCart == null || productInCart.size() == 0){
            %>
            <h3>Empty</h3>
            <%
            } else if (productInCart != null) {
            %>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
            <%
               for(CartProduct product:productInCart){
               totalAmount += product.getTotal();
               numberOfPro += product.getQuantity();
                
            %>
                <form action="CartController" method="post">
                    <tr>
                        <td>
                            <input type="hidden" value="<%=product.getProductID()%>" name="txtProductID">
                        </td>  
                        <td><%=product.getProductName()%></td>  
                        <td><%=product.getPrice()%></td>  
                        <td>
                            <input type="number" min="1" name="txtQuantity" value="<%=product.getQuantity()%>">
                        </td>  
                        <td><%=product.getTotal()%></td> 
                        <td>
                            <input type="submit" value="Remove" name="action">
                        </td>
                        <td>
                            <input type="submit" value="Update" name="action">
                        </td>
                    </tr>
                </form>
                        <tr>
                            <td>
                                <%
            Account accountLog = (Account) session.getAttribute("UserLoggedIn");
            if(accountLog != null){
                CustomerDAO customerDAO = new CustomerDAO();
                Customer customer = customerDAO.getCusbyID(accountLog.getAccountID());
                
                
              %> 
              <form action="CreateOderController" method="post">
                  <input type="hidden" value="<%=accountLog.getAccountID()%>" name="txtCustomerID">
                  <input type="hidden" value="<%=customer.getAddress()%>" name="txtShippAddress">
                  <input type="hidden" value="<%=product.getProductID()%>" name="txtProductID">
                  <input type="hidden" value="<%=totalAmount%>" name="txtFreight">
                  <input type="hidden" value="<%=product.getQuantity()%>" name="txtQuantity">
                  <input value="<%=product.getProductName()%>">
                  <input type="submit" value="Buy" name="action">
              </form>
              
              <%
           }
            
        %> 
                            </td>
                        </tr>
                        
     
            <%
                }  
            %>
            <tr>
                <td><b>Total Amount</b></td>
                <td><%=totalAmount%></td>
            </tr>
            </tbody>
    </table>
            <h3>Number of Product: <%=numberOfPro%></h3>
            
            <%
                }  
            %>
            <form method="post">
                <input type="submit" formaction="DisplayListProduct" value="Continue">
                <input type="submit" formaction="CartController?action=Save" value="Save Cart">
            </form>
            
    
            <%
                if(request.getAttribute("Message") != null){%>
                <%=request.getAttribute("Message")%>
                <%}
            %>
    </body>
</html>
