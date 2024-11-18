/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Account;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name = "AccountController", urlPatterns = {"/AccountController"})
public class AccountController extends HttpServlet {

    private final String searchPage = "SearchProduct.jsp";
    private static final String registerController = "CreateAccountController";
    private static final String userDetailsController = "AccountDetailController";
    private static final String deleteController = "DeleteAccountController";
    private static final String updateController = "UpdateAccountController";
    private static final String AccoountgetUserController = "AccoountgetUserController";
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String url = null;
        HttpSession session = request.getSession();
        boolean isLoggedIn = (session.getAttribute("UserLoggedIn") != null);
        try {
            if (action.equalsIgnoreCase("Register")) {
                url = registerController;
            } else if (isLoggedIn == true) {
                if (action.equalsIgnoreCase("Details")) {
                    url = userDetailsController;
                } else if (action.equalsIgnoreCase("Delete")) {
                    url = deleteController;
                } else if (action.equalsIgnoreCase("Update")) {
                    url = updateController;
                } else if (action.equalsIgnoreCase("Detail")) {
                    url = AccoountgetUserController;
                }
            } else {
                url = searchPage;
            }
        } catch (Exception ex) {
            log(ex.getMessage());
        } finally {
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
