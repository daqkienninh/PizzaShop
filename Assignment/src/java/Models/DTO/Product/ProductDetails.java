/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DTO.Product;

/**
 *
 * @author admin
 */
public class ProductDetails{
    private String productName;
    private float productPrice;
    private String CategoryName;
    private String productImage;
    private String Description;
    private String productID;

    public ProductDetails() {
    }

    public ProductDetails(String productName, float productPrice, String CategoryName, String productImage, String Description, String ProductID) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.CategoryName = CategoryName;
        this.productImage = productImage;
        this.Description = Description;
        this.productID = ProductID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    
    
}
