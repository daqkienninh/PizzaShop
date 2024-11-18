/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Order;

import Models.DTO.Order.Order;
import Models.DTO.OrderDAO.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(name = "UpdateOrderDetailController", urlPatterns = {"/UpdateOrderDetailController"})
public class UpdateOrderDetailController extends HttpServlet {

    private final String CategoryUpdatePage = "UpdateOrder.jsp";
    private final String OrderdetailListController = "OrderdetailListController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = CategoryUpdatePage;
        String message = null;
        String ordID, CusID, OrdDate, ReqDate, ShipDate, ShipAdd;
        float frei;
        try{
            ordID = request.getParameter("txtOrderID");
            CusID = request.getParameter("txtCustomerID");
            OrdDate = request.getParameter("txtOrderDate");
            ReqDate = request.getParameter("txtReqDate");
            ShipDate = request.getParameter("txtShipDate");
            ShipAdd = request.getParameter("txtShipAddress");
            frei = Float.parseFloat(request.getParameter("Freight"));
            OrderDAO orderDAO = new OrderDAO();
            Order order = new Order(ordID, CusID, OrdDate,
                    ReqDate, ShipDate, frei, ShipAdd);
            if(orderDAO.updateOrder(order) == true){
                message = "Success";
                url = OrderdetailListController;
            }else{
                message = "Fail";
                url = OrderdetailListController;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            request.setAttribute("action", "Update Category");
            request.setAttribute("page", "index.html");
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
