/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Account;

import Models.AccountDAO.Service.AccountService;
import Models.DTO.Account.Account;
import Models.DTO.Account.AccountError;
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
@WebServlet(name = "UpdateAccountController", urlPatterns = {"/UpdateAccountController"})
public class UpdateAccountController extends HttpServlet {

    private final String AccountController = "AccountController";
    private final String AccountUpdatePage = "UpdateAccount.jsp";
    private final String HomePage = "DisplayListAccount";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accountId, userName, fullName, password;
        boolean type = false;
        boolean isError = false;
        String url = AccountUpdatePage;
        String message = null;
        try{
            accountId = request.getParameter("txtAccountID");
            userName = request.getParameter("txtUserName");
            password = request.getParameter("txtPassword");
            fullName = request.getParameter("txtFullName");
            String typ = request.getParameter("chkIsType");
            AccountError accountError = new AccountError();
            if(password.matches("(.){3,30}") == false){
                accountError.setPasswordError("The Password must be 3 to 15 charaters.");
                isError = true;
            }
            if (fullName.matches("(.){5,50}") == false) {
                accountError.setFullNameError("The FullName must be 5 to 50 characters.");
                isError = true;
            }
            if (isError == false) {
                if (typ == null) {
                    type = false;
                } else {
                    type = true;
                }
                AccountService accountService = new AccountService();
                Account account = new Account(accountId, userName, password, fullName, type);
                if(accountService.updateUser(account) == true){
                    message = "<b style='color: green'>The user has been updated successfully.</b>";
                    url =HomePage;
                }else {
                    message = "<b style='color: red'>Something went wrong.</b>";
                    url = HomePage;
                }
            }else {
                request.setAttribute("ErrorDetails", accountError);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            request.setAttribute("action", "Update Account");
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
