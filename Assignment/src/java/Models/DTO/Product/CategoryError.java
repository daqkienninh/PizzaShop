/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DTO.Product;

/**
 *
 * @author admin
 */
public class CategoryError {
    private String CategoryIDError;
    private String duplicateCategoryID;
    private String CategoryNameError;
    private String DescriptionError;

    public CategoryError() {
    }

    public String getCategoryIDError() {
        return CategoryIDError;
    }

    public void setCategoryIDError(String CategoryIDError) {
        this.CategoryIDError = CategoryIDError;
    }

    public String getDuplicateCategoryID() {
        return duplicateCategoryID;
    }

    public void setDuplicateCategoryID(String duplicateCategoryID) {
        this.duplicateCategoryID = duplicateCategoryID;
    }

    public String getCategoryNameError() {
        return CategoryNameError;
    }

    public void setCategoryNameError(String CategoryNameError) {
        this.CategoryNameError = CategoryNameError;
    }

    public String getDescriptionError() {
        return DescriptionError;
    }

    public void setDescriptionError(String DescriptionError) {
        this.DescriptionError = DescriptionError;
    }

    public CategoryError(String CategoryIDError, String duplicateCategoryID, String CategoryNameError, String DescriptionError) {
        this.CategoryIDError = CategoryIDError;
        this.duplicateCategoryID = duplicateCategoryID;
        this.CategoryNameError = CategoryNameError;
        this.DescriptionError = DescriptionError;
    }
    
    
}
