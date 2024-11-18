/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DTO.Order;

/**
 *
 * @author admin
 */
public class Customer {
    private String CustomerID;
    private String Password;
    private String ContactName;
    private String Address;
    private String Phone;

    public Customer() {
    }

    public Customer(String CustomerID, String Password, String ContactName, String Address, String Phone) {
        this.CustomerID = CustomerID;
        this.Password = Password;
        this.ContactName = ContactName;
        this.Address = Address;
        this.Phone = Phone;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    
    
}
