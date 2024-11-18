/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Models.AccountDAO.Service;

import Models.DTO.Account.Account;
import java.util.List;

/**
 *
 * @author admin
 */
public interface Iservice<T> {
    Account checkAccount(String userName, String password) throws Exception;
    Account getUserByAccountID(String accountID) throws Exception;
    List<Account> getUserByKeywordOfLastName(String value) throws Exception;
    boolean addNewUser(Account account) throws Exception;
    boolean removeUser(String accountID) throws Exception;
    boolean updateUser(Account account) throws Exception;
    List<Account> getListAccount() throws Exception;
    Account getUserByUserName (String username) throws Exception;
}
