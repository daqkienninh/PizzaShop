<%-- 
    Document   : SearchProduct
    Created on : Jun 27, 2024, 3:39:07 PM
    Author     : admin
--%>

<%@page import="Models.DTO.Order.Customer"%>
<%@page import="Models.DTO.OrderDAO.CustomerDAO"%>
<%@page import="Models.DTO.Account.Account"%>
<%@page import="Models.AccountDAO.Service.AccountService"%>
<%@page import="Models.DTO.Product.ProductDetails"%>
<%@page import="java.util.List"%>
<%@page import="Models.ProductDAO.ProductDeteilDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./searchStyle.css"/>
    </head>
    <body>
        <div class="header"> <!--header-->
            <div class="header_title"> <!--Header title-->
                <h1>PizzaStore</h1>
            </div>

            <div class="header_menu"> <!--Header menu-->
                <div class="text">
                    <a href="DisplayListProduct">Pizzas</a>
                </div>

                <div class="categories">
                    <ul>
                        <li>
                            <a href="#">Categories</a>
                            <ul>
                                <li><a href="#">Salad</a></li>
                                <li><a href="#">Drink</a></li>
                                <li><a href="#">Deserts</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>

                <div class="text">
                    <a href="#">Reiview</a>
                </div>
            </div>

            <div class="header_login"> <!--Header Login-->
                <div>
                    <a href="CartController?action=View Cart">View Cart</a>
                </div>
                <div class="logountbtn">
                    <form action="LogoutController" method="post">
                        <input type="submit" name="action" value="Logout" />
                    </form>
                </div>
            </div>
        </div> <!--Finnish Header-->
        <%
            Account accountLog = (Account) session.getAttribute("UserLoggedIn");
            if(accountLog != null){
            
              %> 
              <h2>Welcome: <%=accountLog.getFullName()%></h2>
              <a href="CustomerController?action=Details&txtCustomerID=<%=accountLog.getAccountID()%>">Setting</a>
              <%
           }
            
        %> 
        <h2>Pizza Menu</h2>
        
        <div class="search">
  <form action="SearchbyNameController" method="post">
    <h3>Search</h3><br>
    <input type="text" name="txtSearchValue" class="searchbar"> <br>
    <input type="submit" value="Search" name="btnAction" class="searchbtn">
</form>
</div>
        <%
            String searchValue = request.getParameter("txtSearchValue");
            if (searchValue == null) {
        %>
        <div class="product">
            <%
                ProductDeteilDAO productDetails = new ProductDeteilDAO();
                List<ProductDetails> productList = (List<ProductDetails>) request.getAttribute("ProductList");
                if (productList != null) {
                    for (ProductDetails product : productList) {
            %>
            <div class="card">
                <img src="<%=product.getProductImage()%>" alt="Avatar" style="width:100%">
                <div class="container">
                    <h4><b><%=product.getProductName()%></b></h4> 
                    <p><%=product.getDescription()%></p> 
                    <h5>Category: <%=product.getCategoryName()%></h5>
                    <p>Price: <%=product.getProductPrice()%>$</p>
                </div>
                <a href="CartController?action=Add&&txtProductID=<%=product.getProductID()%>" class="buybtn">Add to Cart</a>
            </div>
            <%
                    }
                }
            %> 
            <%
            } else {
                ProductDeteilDAO productDetails = new ProductDeteilDAO();
                List<ProductDetails> productList = (List<ProductDetails>) request.getAttribute("SearchbyName");
                if (productList != null) {
                    for (ProductDetails product : productList) {

            %>
            <div class="card">
                <img src="<%=product.getProductImage()%>" alt="Avatar" style="width:100%">
                <div class="container">
                    <h4><b><%=product.getProductName()%></b></h4> 
                    <p><%=product.getDescription()%></p> 
                    <h5>Category: <%=product.getCategoryName()%></h5>
                    <p>Price: <%=product.getProductPrice()%>$</p>
                </div>
                <a href="CartController?action=Add&&txtProductID=<%=product.getProductID()%>" class="buybtn">Add to Cart</a>
            </div>
            <%
                    }
                }
}
            %>
        </div>
    </body>
</html>
