/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DTO.Order;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Order {
     private String OrderID;
    private String CustomerID;
    private String OrderDate;
    private String RequiredDate;
    private String ShippedDate;
    private float Freight;
    private String ShipAddress;

    public Order(String OrderID, String CustomerID, String OrderDate, String RequiredDate, String ShippedDate, float Freight, String ShipAddress) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.OrderDate = OrderDate;
        this.RequiredDate = RequiredDate;
        this.ShippedDate = ShippedDate;
        this.Freight = Freight;
        this.ShipAddress = ShipAddress;
    }

    public Order() {
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getRequiredDate() {
        return RequiredDate;
    }

    public void setRequiredDate(String RequiredDate) {
        this.RequiredDate = RequiredDate;
    }

    public String getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(String ShippedDate) {
        this.ShippedDate = ShippedDate;
    }

    public float getFreight() {
        return Freight;
    }

    public void setFreight(float Freight) {
        this.Freight = Freight;
    }

    public String getShipAddress() {
        return ShipAddress;
    }

    public void setShipAddress(String ShipAddress) {
        this.ShipAddress = ShipAddress;
    }
    
    
}
