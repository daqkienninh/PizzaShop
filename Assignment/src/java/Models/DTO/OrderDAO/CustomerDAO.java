/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DTO.OrderDAO;

import DB.Utils.DBUtils;
import Models.DTO.Order.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class CustomerDAO {
    public boolean addCustomer(Customer customer) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = DBUtils.getConnection();
            String sql = "Insert Customers values(?,?,?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, customer.getCustomerID());
            preStm.setString(2, customer.getPassword());
            preStm.setString(3, customer.getContactName());
            preStm.setString(4, customer.getAddress());
            preStm.setString(5, customer.getPhone());
            return preStm.executeUpdate() > 0;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
    }
    
    public boolean deleteCus(String CusID) throws Exception {
       PreparedStatement preStm = null;
        Connection cnn =null; 
        try{
            cnn = DBUtils.getConnection();
            String sql = "delete Customers Where CustomerID = ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, CusID);
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
    public boolean updateCus(Customer customer) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn =null;
        try{
            cnn = DBUtils.getConnection();
            String sql = "Update Customers set Password=?, ContactName=?, Address=?, Phone=? where CustomerID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, customer.getPassword());
            preStm.setString(2, customer.getContactName());
            preStm.setString(3, customer.getAddress());
            preStm.setString(4, customer.getPhone());
            preStm.setString(5, customer.getCustomerID());
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
    
    public Customer getCusbyID(String CusID) throws Exception {
         Customer customer = null;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String pass, conName, add;
        String phone;
        try{
            cnn = DBUtils.getConnection();
            String sql = 
                    "select Password, ContactName, Address, Phone from Customers where [CustomerID]=? ";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, CusID);
            rs = preStm.executeQuery();
            while(rs.next()){
                pass = rs.getString(1);
                conName = rs.getString(2);
                add = rs.getString(3);
                phone = rs.getString(4);
                customer = new Customer(CusID, pass, conName, add, phone);
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
        return customer;
    }
}
