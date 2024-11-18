/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DTO.OrderDAO;

import DB.Utils.DBUtils;
import Models.DTO.Order.OrderDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class OrderDetailsDAO {
    public boolean addOrderDetail(OrderDetails orderDetails) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = DBUtils.getConnection();
            String sql = "Insert Order_Details values(?,?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, orderDetails.getOrderID());
            preStm.setString(2, orderDetails.getProductID());
            preStm.setFloat(3, orderDetails.getUnitPrice());
            preStm.setInt(4, orderDetails.getQuantity());
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
    
    public OrderDetails getOrdDebyID(String OrdID) throws Exception {
         OrderDetails orderDetails = null;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String ProductID; 
        int quantity;
        float price;
        try{
            cnn = DBUtils.getConnection();
            String sql = 
                    "select ProductID, UnitPrice, Quantity from Order_Details where [OrderID]=? ";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, OrdID);
            rs = preStm.executeQuery();
            while(rs.next()){
                ProductID = rs.getString(1);
                price = rs.getFloat(2);
                quantity = rs.getInt(3);
                orderDetails = new OrderDetails(OrdID, ProductID, price, quantity);
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
        return orderDetails;
    }
    
    public List<OrderDetails> listOrderdetail() throws Exception {
        String OrderID, ProductID;
        float price;
        int quantity;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs =null;
        List<OrderDetails> detailList = new ArrayList();
        
        try{
            cnn = DBUtils.getConnection();
            String sql = "select * from Order_Details";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            
            while(rs.next()){
                OrderID = rs.getString(1);
                ProductID = rs.getString(2);
                price = rs.getFloat(3);
                quantity = rs.getInt(4);
                OrderDetails orderDetails = new OrderDetails(OrderID, ProductID, price, quantity);
                detailList.add(orderDetails);
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
        return detailList;
    }
}
