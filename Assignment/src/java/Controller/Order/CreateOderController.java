/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Order;

import Models.DTO.Order.Order;
import Models.DTO.Order.OrderDetails;
import Models.DTO.OrderDAO.OrderDAO;
import Models.DTO.OrderDAO.OrderDetailsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
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
@WebServlet(name = "CreateOderController", urlPatterns = {"/CreateOderController"})
public class CreateOderController extends HttpServlet {

     private final String SearchPage = "DisplayListProduct";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SearchPage;
        String message = null;
         String ordID ,cusID, shipadd;
        String orderDate = "", reqDate = "", shippDate = "";
        float frei;
        String prodID;
        int quan;
        try{
            cusID = request.getParameter("txtCustomerID");
            shipadd = request.getParameter("txtShippAddress");
            frei = Float.parseFloat(request.getParameter("txtFreight"));
            prodID = request.getParameter("txtProductID");
            quan = Integer.parseInt(request.getParameter("txtQuantity"));
            OrderDAO orderDAO = new OrderDAO();
            List<Order> orderList = orderDAO.listOrderdetail();
            int length = orderList.size();
            ordID = ""+(length+1);
            Order order = new Order(ordID, cusID, orderDate
                    , reqDate, shippDate, frei, shipadd);
            OrderDetails orderDetails = new OrderDetails(ordID, prodID,
                    frei, quan);
            OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
            if(orderDAO.addOrderDetail(order) == true && orderDetailsDAO.addOrderDetail(orderDetails) == true){
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
