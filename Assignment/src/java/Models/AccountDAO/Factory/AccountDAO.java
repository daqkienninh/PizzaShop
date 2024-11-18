/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.AccountDAO.Factory;

import DB.Utils.DBUtils;
import Models.DTO.Account.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class AccountDAO implements IAccountDAO{

    @Override
    public Account login(String UserName, String Password) throws Exception {
        Account account = null;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String accountID, fullName;
        boolean type ;
        try{
            cnn = DBUtils.getConnection();
            String sql = 
                    "select AccountID, FullName, Type from Account where [UserName]=? and [Password]=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, UserName);
            preStm.setString(2, Password);
            rs = preStm.executeQuery();
            while(rs.next()){
                accountID = rs.getString(1);
                fullName = rs.getString(2);
                type = rs.getBoolean(3);
                account = new Account(accountID, UserName, Password, fullName, type);
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if(rs != null){
                rs.close();
            }
            if(preStm != null){
                preStm.close();
            }
            if(cnn != null){
                cnn.close();
            }
        }
        return account;
    }

    @Override
    public Account getUserByAccountID(String AccountID) throws Exception {
         Account account = null;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String userName, password, fullName;
        boolean type;
        try{
            cnn = DBUtils.getConnection();
            String sql = 
                    "select UserName, Password, FullName, Type from Account where [AccountID]=? ";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, AccountID);
            rs = preStm.executeQuery();
            while(rs.next()){
                userName = rs.getString(1);
                password = rs.getString(2);
                fullName = rs.getString(3);
                type = rs.getBoolean(4);
                account = new Account(AccountID, userName, password, fullName, type);
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if(rs != null){
                rs.close();
            }
            if(preStm != null){
                preStm.close();
            }
            if(cnn != null){
                cnn.close();
            } 
        }
        return account;
    }

    @Override
    public List<Account> searchAccountbyUserName(String searchValue) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAccount(Account account) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn =null;
        try{
            cnn = DBUtils.getConnection();
            String sql = "Insert Account values(?,?,?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, account.getAccountID());
            preStm.setString(2, account.getUserName());
            preStm.setString(3, account.getPassword());
            preStm.setString(4, account.getFullName());
            preStm.setBoolean(5, account.isType());
            return preStm.executeUpdate() > 0;
        }catch(Exception ex){
            throw ex;
        }finally{
            if(preStm != null){
                preStm.close();
            }
            if(cnn != null){
                cnn.close();
            }
        }
    }

    @Override
    public boolean deleteAccount(String AccountID) throws Exception {
       PreparedStatement preStm = null;
        Connection cnn =null; 
        try{
            cnn = DBUtils.getConnection();
            String sql = "delete Account Where AccountID = ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, AccountID);
            return preStm.executeUpdate() > 0;
        }catch(Exception ex){
            throw ex;
        }finally{
            if(preStm != null){
                preStm.close();
            }
            if(cnn != null){
                cnn.close();
            }
        }
    }

    @Override
    public boolean updateAccount(Account account) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn =null;
        try{
            cnn = DBUtils.getConnection();
            String sql = "Update Account set UserName=?,Password=?, FullName =?, Type=? where AccountID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, account.getUserName());
            preStm.setString(2, account.getPassword());
            preStm.setString(3, account.getFullName());
            preStm.setBoolean(4, account.isType());
            preStm.setString(5, account.getAccountID());
            return preStm.executeUpdate() > 0;
        }catch(Exception ex){
            throw ex;
        }finally{
            if(preStm != null){
                preStm.close();
            }
            if(cnn != null){
                cnn.close();
            }
        }
    }

    @Override
    public List<Account> listAccount() throws Exception {
        String accountID, userName, password, fullName;
        boolean type;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs =null;
        List<Account> accountList = new ArrayList();
        
        try{
            cnn = DBUtils.getConnection();
            String sql = "select * from Account";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            
            while(rs.next()){
                accountID = rs.getString(1);
                userName = rs.getString(2);
                password = rs.getString(3);
                fullName = rs.getString(4);
                type = rs.getBoolean(5);
                Account account = new Account(accountID, userName, password, fullName, type);
                accountList.add(account);
            }
        }catch(Exception ex){
            throw ex;
        }finally{
           if(rs != null){
                rs.close();
            }
            if(preStm != null){
                preStm.close();
            }
            if(cnn != null){
                cnn.close();
            } 
        }
        return accountList;
    }

    @Override
    public Account getUserByUserName(String username) throws Exception {
        Account account = null;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String accountID, password, fullName;
        boolean type;
        try{
            cnn = DBUtils.getConnection();
            String sql = 
                    "select AccountID, Password, FullName, Type from Account where [UserName]=? ";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            while(rs.next()){
                accountID = rs.getString(1);
                password = rs.getString(2);
                fullName = rs.getString(3);
                type = rs.getBoolean(4);
                account = new Account(accountID, username, password, fullName, type);
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if(rs != null){
                rs.close();
            }
            if(preStm != null){
                preStm.close();
            }
            if(cnn != null){
                cnn.close();
            } 
        }
        return account;
    }
    
}
