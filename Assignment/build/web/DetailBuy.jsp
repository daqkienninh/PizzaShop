<%-- 
    Document   : DetailBuy
    Created on : Jul 9, 2024, 10:56:09 PM
    Author     : admin
--%>

<%@page import="Models.Cart.CartProduct"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Models.DTO.Account.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Account accountLog = (Account) session.getAttribute("UserLoggedIn");
            if(accountLog != null){
                String proID;
              %> 
              <%
            float totalAmount = 0;
            int numberOfPro = 0;
            List<CartProduct> productInCart = (List<CartProduct>)request.getAttribute("Cart");
        %>
         <%
               for(CartProduct product:productInCart){
               totalAmount += product.getTotal();
               numberOfPro += product.getQuantity();
                
            %>
            <h2><%=product.getProductID()%></h2>
            <%
                }  
            %>
              <h2>Welcome: <%=accountLog.getFullName()%></h2>
              <%
           }
            
        %> 
    </body>
</html>
