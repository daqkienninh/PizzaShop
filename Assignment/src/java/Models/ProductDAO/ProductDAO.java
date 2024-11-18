/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.ProductDAO;

import DB.Utils.DBUtils;
import Models.DTO.Product.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ProductDAO {
    public boolean addProduct(Product prodduct) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = DBUtils.getConnection();
            String sql = "Insert Products values(?,?,?,?,?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, prodduct.getProductID());
            preStm.setString(2, prodduct.getProductName());
            preStm.setString(3, prodduct.getSupplierID());
            preStm.setString(4, prodduct.getCategoryID());
            preStm.setInt(5, prodduct.getQuantityPerUnit());
            preStm.setFloat(6, prodduct.getUnitPrice());
            preStm.setString(7, prodduct.getProductImage());
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
    
    public boolean deleteProduct(String ProductID) throws Exception {
       PreparedStatement preStm = null;
        Connection cnn =null; 
        try{
            cnn = DBUtils.getConnection();
            String sql = "delete Products Where ProductID = ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, ProductID);
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
    public boolean updateProduct(Product prodduct) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn =null;
        try{
            cnn = DBUtils.getConnection();
            String sql = "Update Products set ProductName=?,SupplierID=?, CategoryID =?, QuantityPerUnit=?,UnitPrice=?,ProductImage=? where ProductID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, prodduct.getProductName());
            preStm.setString(2, prodduct.getSupplierID());
            preStm.setString(3, prodduct.getCategoryID());
            preStm.setInt(4, prodduct.getQuantityPerUnit());
            preStm.setFloat(5, prodduct.getUnitPrice());
            preStm.setString(6, prodduct.getProductImage());
            preStm.setString(7, prodduct.getProductID());
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
    
    public Product getProductbyProductID(String ProductID) throws Exception {
         Product product = null;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String productName, SupplierID, CategoryID, ProductImage;
        int quantity;
        float price; 
        try{
            cnn = DBUtils.getConnection();
            String sql = 
                    "select ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice,ProductImage from Products where [ProductID]=? ";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, ProductID);
            rs = preStm.executeQuery();
            while(rs.next()){
                productName = rs.getString(1);
                SupplierID = rs.getString(2);
                CategoryID = rs.getString(3);
                quantity = rs.getInt(4);
                price = rs.getFloat(5);
                ProductImage = rs.getString(6);
                product = new Product(ProductID, productName, SupplierID, CategoryID, quantity, price, ProductImage);
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
        return product;
    }
    
    public List<Product> listProduct() throws Exception {
        String productName, SupplierID, CategoryID, ProductImage, productID;
        int quantity;
        float price;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs =null;
        List<Product> productList = new ArrayList();
        
        try{
            cnn = DBUtils.getConnection();
            String sql = "select * from Products";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            
            while(rs.next()){
                productID = rs.getString(1);
                productName = rs.getString(2);
                SupplierID = rs.getString(3);
                CategoryID = rs.getString(4);
                quantity = rs.getInt(5);
                price = rs.getFloat(6);
                ProductImage = rs.getString(7);
                Product product = new Product(productID, productName, SupplierID, CategoryID, quantity, price, ProductImage);
                productList.add(product);
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
        return productList;
    }
}
