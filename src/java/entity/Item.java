/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HP
 */
public class Item {
    private Product product;
    private int quantity;
    private double price;

    public Item(Product product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price*quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getPriceFormat(int list_price) {
        String formattedPrice = String.format("%,.0f", list_price);
        formattedPrice = formattedPrice.replace(",", ".");
        return formattedPrice;
    }
    @Override
    public String toString() {
        return "Cart{" + "product=" + product + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
}
