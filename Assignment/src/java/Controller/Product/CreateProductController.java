/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Product;

import Models.DTO.Product.Product;
import Models.ProductDAO.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "CreateProductController", urlPatterns = {"/CreateProductController"})
public class CreateProductController extends HttpServlet {

    private final String CreateProPage = "CreateProduct.jsp";
    private final String DisplaylistPro = "DisplayProductAdmin";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String message = null;
        String url = DisplaylistPro;
        String productName, SupplierID, CategoryID, ProductImage, productID;
        int quantity;
        float price;
        try{
            productID = request.getParameter("txtProductID");
            productName = request.getParameter("txtProductName");
            SupplierID = request.getParameter("txtSupplierID");
            CategoryID = request.getParameter("txtCategoryID");
            quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            price = Float.parseFloat(request.getParameter("txtPrice"));
            ProductImage = request.getParameter("txtImg");
            ProductDAO productDAO = new ProductDAO();
            Product product = new Product(productID, productName, SupplierID, 
                    CategoryID, quantity, price, ProductImage);
            if(productDAO.addProduct(product) == true){
                message = "Success";
            }else{
                message = "Fail";
            }
        }catch (Exception ex) {
            log(ex.getMessage());
        } finally {
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
