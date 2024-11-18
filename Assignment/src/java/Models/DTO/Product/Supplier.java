/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DTO.Product;

/**
 *
 * @author admin
 */
public class Supplier {
    private String SupplierID;
    private String CompanyName;
    private String Address;
    private int Phone;

    public Supplier() {
    }

    public Supplier(String SupplierID, String CompanyName, String Address, int Phone) {
        this.SupplierID = SupplierID;
        this.CompanyName = CompanyName;
        this.Address = Address;
        this.Phone = Phone;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }
    
    
}
