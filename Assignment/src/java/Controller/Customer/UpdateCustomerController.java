/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Customer;

import Models.DTO.Order.Customer;
import Models.DTO.OrderDAO.CustomerDAO;
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
@WebServlet(name = "UpdateCustomerController", urlPatterns = {"/UpdateCustomerController"})
public class UpdateCustomerController extends HttpServlet {

    private final String SearchPage = "DisplayListProduct";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SearchPage;
        String cusID, pass, conName, add;
        String phone;
        String message = null;
        try{
            cusID = request.getParameter("txtCustomerID");
            pass = request.getParameter("txtPassword");
            conName = request.getParameter("txtContactName");
            add = request.getParameter("txtAddress");
            phone = request.getParameter("Phone");
            CustomerDAO customerDAO = new CustomerDAO();
            Customer customer = new Customer(cusID, pass, conName, add, phone);
            if(customerDAO.updateCus(customer) == true){
                message = "Success";
            }else{
                message = "Fail";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            request.setAttribute("action", "Update Customer");
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
