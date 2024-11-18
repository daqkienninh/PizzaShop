/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DTO.Product;

/**
 *
 * @author admin
 */
public class ProductError {
    private String productIDError;
    private String productIDDuplicate;
    private String productNameError;
    private String supplierIDError;
    private String categoryIDError;
    private String quantityPerUnitError;
    private String unitPriceError;
    private String productImageError;

    public ProductError() {
    }

    public ProductError(String productIDError, String productIDDuplicate, String productNameError, String supplierIDError, String categoryIDError, String quantityPerUnitError, String unitPriceError, String productImageError) {
        this.productIDError = productIDError;
        this.productIDDuplicate = productIDDuplicate;
        this.productNameError = productNameError;
        this.supplierIDError = supplierIDError;
        this.categoryIDError = categoryIDError;
        this.quantityPerUnitError = quantityPerUnitError;
        this.unitPriceError = unitPriceError;
        this.productImageError = productImageError;
    }

    public String getProductIDError() {
        return productIDError;
    }

    public void setProductIDError(String productIDError) {
        this.productIDError = productIDError;
    }

    public String getProductIDDuplicate() {
        return productIDDuplicate;
    }

    public void setProductIDDuplicate(String productIDDuplicate) {
        this.productIDDuplicate = productIDDuplicate;
    }

    public String getProductNameError() {
        return productNameError;
    }

    public void setProductNameError(String productNameError) {
        this.productNameError = productNameError;
    }

    public String getSupplierIDError() {
        return supplierIDError;
    }

    public void setSupplierIDError(String supplierIDError) {
        this.supplierIDError = supplierIDError;
    }

    public String getCategoryIDError() {
        return categoryIDError;
    }

    public void setCategoryIDError(String categoryIDError) {
        this.categoryIDError = categoryIDError;
    }

    public String getQuantityPerUnitError() {
        return quantityPerUnitError;
    }

    public void setQuantityPerUnitError(String quantityPerUnitError) {
        this.quantityPerUnitError = quantityPerUnitError;
    }

    public String getUnitPriceError() {
        return unitPriceError;
    }

    public void setUnitPriceError(String unitPriceError) {
        this.unitPriceError = unitPriceError;
    }

    public String getProductImageError() {
        return productImageError;
    }

    public void setProductImageError(String productImageError) {
        this.productImageError = productImageError;
    }
    
    
}
