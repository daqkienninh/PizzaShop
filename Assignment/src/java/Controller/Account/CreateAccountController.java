/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Account;

import Models.AccountDAO.Service.AccountService;
import Models.DTO.Account.Account;
import Models.DTO.Account.AccountError;
import Models.DTO.Order.Customer;
import Models.DTO.OrderDAO.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CreateAccountController", urlPatterns = {"/CreateAccountController"})
public class CreateAccountController extends HttpServlet {

    private final String registerPage = "CreateAccount.jsp";
    private final String HomePage = "index.html";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String message = "Something went wrong.";
        String url = HomePage;
        String accountID ,userName, fullName, password;
        boolean type = false, isError = false;
        String conName = "", add = "";
        String phone = "";
        try{
           // accountID = request.getParameter("txtAccountID");
            userName = request.getParameter("txtUserName");
            password = request.getParameter("txtPassword");
            fullName =request.getParameter("txtFullName");
             AccountService accountService = new AccountService();
            AccountError accountError = new AccountError();
            CustomerDAO customerDAO = new CustomerDAO();
            
            List<Account> accountList = accountService.getListAccount();
            int length = accountList.size();
            accountID = "0"+(length+3);
            
            if (accountService.getUserByAccountID(accountID) != null) {
                accountError.setDuplicateAccoutID("The User already exists.");
                isError = true;
            }
            if (password.matches("(.){3,30}") == false) {
                accountError.setPasswordError("The Password must be 3 to 30 charaters.");
                isError = true;
            }
            if (fullName.matches("(.){5,50}") == false) {
                accountError.setFullNameError("The FullName must be 5 to 50 characters.");
                isError = true;
            }
            if (isError == false) {
                
                Account account = new Account(accountID, userName, password, fullName, type);
                Customer customer = new Customer(accountID, password, conName, add, phone);
                if (accountService.addNewUser(account) == true  && customerDAO.addCustomer(customer) == true) {
                    message = "<b style='color: green'>The user has been created successfully.</b>";
                    url =HomePage;
                } else {
                    message = "<b style='color: red'>Something went wrong.</b>";
                    url = HomePage;
                }
            } else {
                request.setAttribute("ErrorDetails", accountError);
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
