/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.AccountDAO.Service;

import Models.AccountDAO.Factory.DAOFactory;
import Models.AccountDAO.Factory.IAccountDAO;
import Models.DTO.Account.Account;
import java.util.List;

/**
 *
 * @author admin
 */
public class AccountService implements Iservice<Account>{
    
    IAccountDAO accountDAO;

    public AccountService() {
        this.accountDAO = new DAOFactory().AccountDAO();
    }


    @Override
    public Account checkAccount(String userName, String password) throws Exception {
        return accountDAO.login(userName, password);
    }

    @Override
    public Account getUserByAccountID(String accountID) throws Exception {
        return accountDAO.getUserByAccountID(accountID);
    }

    @Override
    public List<Account> getUserByKeywordOfLastName(String value) throws Exception {
        return accountDAO.searchAccountbyUserName(value);
    }

    @Override
    public boolean addNewUser(Account account) throws Exception {
        return accountDAO.addAccount(account);
    }

    @Override
    public boolean removeUser(String accountID) throws Exception {
        return accountDAO.deleteAccount(accountID);
    }

    @Override
    public boolean updateUser(Account account) throws Exception {
        return accountDAO.updateAccount(account);
    }

    @Override
    public List<Account> getListAccount() throws Exception {
        return accountDAO.listAccount();
    }

    @Override
    public Account getUserByUserName(String username) throws Exception {
        return accountDAO.getUserByUserName(username);
    }
    
}
