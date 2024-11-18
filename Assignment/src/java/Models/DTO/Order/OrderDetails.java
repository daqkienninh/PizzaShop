/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DTO.Order;

/**
 *
 * @author admin
 */
public class OrderDetails {
    private String OrderID;
    private String ProductID;
    private float UnitPrice;
    private int Quantity;

    public OrderDetails(String OrderID, String ProductID, float UnitPrice, int Quantity) {
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.UnitPrice = UnitPrice;
        this.Quantity = Quantity;
    }

    public OrderDetails() {
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    
}
