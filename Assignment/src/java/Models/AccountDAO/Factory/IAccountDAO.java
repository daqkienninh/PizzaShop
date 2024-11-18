/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Models.AccountDAO.Factory;


import Models.DTO.Account.Account;
import java.util.List;

/**
 *
 * @author admin
 */
public interface IAccountDAO {
    Account login(String UserName, String Password) throws Exception;
    Account getUserByAccountID (String AccountID) throws Exception;
    Account getUserByUserName (String username) throws Exception;
    List<Account> searchAccountbyUserName(String searchValue) throws Exception;
    boolean addAccount(Account account) throws Exception;
    boolean deleteAccount (String AccountID) throws Exception;
    boolean updateAccount(Account account) throws Exception;
    List<Account> listAccount() throws Exception;
}
