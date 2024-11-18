/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.ProductDAO;

import DB.Utils.DBUtils;
import Models.DTO.Product.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CategoryDAO {
    public boolean addCategory(Category category) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = DBUtils.getConnection();
            String sql = "Insert Categories values(?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, category.getCategoryID());
            preStm.setString(2, category.getCategoryName());
            preStm.setString(3, category.getDescription());
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
    
    public boolean deleteCategory(String CategoryID) throws Exception {
       PreparedStatement preStm = null;
        Connection cnn =null; 
        try{
            cnn = DBUtils.getConnection();
            String sql = "delete Categories Where CategoryID = ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, CategoryID);
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
    public boolean updateCategory(Category category) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn =null;
        try{
            cnn = DBUtils.getConnection();
            String sql = "Update Categories set CategoryName=?, Description=? where CategoryID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, category.getCategoryName());
            preStm.setString(2, category.getDescription());
            preStm.setString(3, category.getCategoryID());
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
    
    public Category getCategorybyID(String CategoryID) throws Exception {
         Category category = null;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String categoryName, Description; 
        try{
            cnn = DBUtils.getConnection();
            String sql = 
                    "select CategoryName, Description from Categories where [CategoryID]=? ";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, CategoryID);
            rs = preStm.executeQuery();
            while(rs.next()){
                categoryName = rs.getString(1);
                Description = rs.getString(2);
                category = new Category(CategoryID, categoryName, Description);
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
        return category;
    }
    
    public List<Category> listCategory() throws Exception {
        String cateID, cateName, Descrip;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs =null;
        List<Category> cateList = new ArrayList();
        
        try{
            cnn = DBUtils.getConnection();
            String sql = "select * from Categories";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            
            while(rs.next()){
                cateID = rs.getString(1);
                cateName = rs.getString(2);
                Descrip = rs.getString(3);
                Category category = new Category(cateID, cateName, Descrip);
                cateList.add(category);
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
        return cateList;
    }
}
