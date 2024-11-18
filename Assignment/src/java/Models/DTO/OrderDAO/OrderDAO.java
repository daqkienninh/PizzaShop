/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DTO.OrderDAO;

import DB.Utils.DBUtils;
import Models.DTO.Order.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class OrderDAO {
    public boolean addOrderDetail(Order order) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = DBUtils.getConnection();
            String sql = "Insert Orders values(?,?,?,?,?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, order.getOrderID());
            preStm.setString(2, order.getCustomerID());
            preStm.setString(3, order.getOrderDate());
            preStm.setString(4, order.getRequiredDate());
            preStm.setString(5,  order.getShippedDate());
            preStm.setFloat(6, order.getFreight());
            preStm.setString(7, order.getShipAddress());
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
    
    public Order getOrdbyID(String OrdID) throws Exception {
         Order order = null;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String cusID, shipadd;
        String orderDate, reqDate, shippDate;
        float frei;
        try{
            cnn = DBUtils.getConnection();
            String sql = 
                    "select CustomerID, OrderDate, RequiredDate,"
                    + "ShippedDate,Freight,ShipAddress from Orders where [OrderID]=? ";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, OrdID);
            rs = preStm.executeQuery();
            while(rs.next()){
                cusID = rs.getString(1);
                orderDate = rs.getString(2);
                reqDate = rs.getString(3);
                shippDate = rs.getString(4);
                frei = rs.getFloat(5);
                shipadd = rs.getString(6);
                order = new Order(OrdID, cusID, orderDate, reqDate, shippDate, frei, shipadd);
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
        return order;
    }
    
    public List<Order> listOrderdetail() throws Exception {
       String ordID ,cusID, shipadd;
        String orderDate, reqDate, shippDate;
        float frei;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs =null;
        List<Order> detailList = new ArrayList();
        
        try{
            cnn = DBUtils.getConnection();
            String sql = "select * from Orders";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            
            while(rs.next()){
                ordID = rs.getString(1);
                cusID = rs.getString(2);
                orderDate = rs.getString(3);
                reqDate = rs.getString(4);
                shippDate = rs.getString(5);
                frei = rs.getFloat(6);
                shipadd = rs.getString(7);
                Order order = new Order(ordID, cusID, orderDate, reqDate, shippDate, frei, shipadd);
                detailList.add(order);
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
    
     public boolean updateOrder(Order order) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn =null;
        try{
            cnn = DBUtils.getConnection();
            String sql = "Update Orders set OrderDate=?, RequiredDate=?, ShippedDate=? where OrderID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, order.getOrderDate());
            preStm.setString(2, order.getRequiredDate());
            preStm.setString(3, order.getShippedDate());
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
}
