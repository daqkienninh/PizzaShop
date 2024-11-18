/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DTO.Product;

/**
 *
 * @author admin
 */
public class Product {
    private String ProductID;
    private String ProductName;
    private String SupplierID;
    private String CategoryID;
    private int QuantityPerUnit;
    private float UnitPrice;
    private String ProductImage;

    public Product() {
    }

    public Product(String ProductID, String ProductName, String SupplierID, String CategoryID, int QuantityPerUnit, float UnitPrice, String ProductImage) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.SupplierID = SupplierID;
        this.CategoryID = CategoryID;
        this.QuantityPerUnit = QuantityPerUnit;
        this.UnitPrice = UnitPrice;
        this.ProductImage = ProductImage;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.CategoryID = CategoryID;
    }

    public int getQuantityPerUnit() {
        return QuantityPerUnit;
    }

    public void setQuantityPerUnit(int QuantityPerUnit) {
        this.QuantityPerUnit = QuantityPerUnit;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public void setProductImage(String ProductImage) {
        this.ProductImage = ProductImage;
    }
    
    
}
