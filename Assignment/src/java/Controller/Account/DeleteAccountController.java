/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Account;

import Models.AccountDAO.Service.AccountService;
import Models.DTO.Account.Account;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(name = "DeleteAccountController", urlPatterns = {"/DeleteAccountController"})
public class DeleteAccountController extends HttpServlet {

    private final String AccountController = "AccountController";
    private final String HomePage = "DisplayListAccount";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = AccountController;
        String message = null;
        try{
            AccountService accountService = new AccountService();
  //          HttpSession session = request.getSession();
  //          Account userLoggedIn = (Account) session.getAttribute("AccountLoggedIn");
            String accountID = request.getParameter("txtAccountID");
   //         if(accountID.equals(userLoggedIn.getAccountID())){
   //             message = "This user logged in, can not delete.";
    //        }else{
                if(!accountID.isEmpty()){
                    if(accountService.removeUser(accountID) == true){
                        message = "The user has been deleted successfully.";
                        url = HomePage;
                    }else{
                        message = "Something went wrong.";
                    }
                }
        //    }
          //  url = HomePage;
        }catch (Exception ex){
            log(ex.getMessage());
        }finally{
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
