/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.ProductDAO;

import DB.Utils.DBUtils;
import Models.DTO.Product.ProductDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ProductDeteilDAO {

    public List<ProductDetails> listProduct() throws Exception {
        String productName;
        float productPrice;
        String CategoryName;
        String productImage;
        String Description;
        String productID;
        boolean type;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<ProductDetails> productList = new ArrayList();

        try {
            cnn = DBUtils.getConnection();
            String sql = "select ProductID,ProductName, UnitPrice, ProductImage, CategoryName, "
                    + "Description from Products join Categories on Products.CategoryID = Categories.CategoryID";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();

            while (rs.next()) {
                productID = rs.getString(1);
                productName = rs.getString(2);
                productPrice = rs.getFloat(3);
                productImage = rs.getString(4);
                CategoryName = rs.getString(5);
                Description = rs.getString(6);
                ProductDetails productDetails = new ProductDetails(productName, productPrice, CategoryName, productImage, Description, productID);
                productList.add(productDetails);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        return productList;
    }

    public List<ProductDetails> searchProductbyName(String searchValue) throws Exception {
        float productPrice;
        String CategoryName;
        String productImage;
        String Description;
        String productID;
        String productName;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<ProductDetails> productList = new ArrayList();
        try{
            cnn = DBUtils.getConnection();
            String sql = "select ProductID, ProductName, UnitPrice, ProductImage, CategoryName, Description "
                    + "from Products join Categories on Products.CategoryID = Categories.CategoryID "
                    + "where ProductName like ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, "%"+searchValue+"%");
            rs = preStm.executeQuery();
            while(rs.next()){
                productID = rs.getString(1);
                productName = rs.getString(2);
                productPrice = rs.getFloat(3);
                productImage = rs.getString(4);
                CategoryName = rs.getString(5);
                Description = rs.getString(6);
                ProductDetails productDetails = new ProductDetails(productName, productPrice, CategoryName, productImage, 
                        Description, productID);
                productList.add(productDetails);
            }
        }catch(Exception ex){
            throw ex;
        }
        finally{
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
        if(productList.isEmpty()){
            return null;
        }
        return productList;
    }
    
     public List<ProductDetails> searchProductbyCate(String searchValue) throws Exception {
        float productPrice;
        String CategoryName;
        String productImage;
        String Description;
        String productID;
        String productName;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<ProductDetails> productList = new ArrayList();
        try{
            cnn = DBUtils.getConnection();
            String sql = "select ProductID, ProductName, UnitPrice, ProductImage, CategoryName, Description "
                    + "from Products join Categories on Products.CategoryID = Categories.CategoryID "
                    + "where CategoryName like ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, "%"+searchValue+"%");
            rs = preStm.executeQuery();
            while(rs.next()){
                productID = rs.getString(1);
                productName = rs.getString(2);
                productPrice = rs.getFloat(3);
                productImage = rs.getString(4);
                CategoryName = rs.getString(5);
                Description = rs.getString(6);
                ProductDetails productDetails = new ProductDetails(productName, productPrice, CategoryName, productImage, 
                        Description, productID);
                productList.add(productDetails);
            }
        }catch(Exception ex){
            throw ex;
        }
        finally{
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
        if(productList.isEmpty()){
            return null;
        }
        return productList;
    }
}
