/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HP
 */
public class OrderItem {
    private int item_id, order_id, product_id, discount, quantity;
    private double list_price;
    private Order order;
    
    private Product product;

    public OrderItem(int order_id, int item_id, int discount, double list_price, int quantity, Product product) {
        this.order_id = order_id;
        this.item_id = item_id;
        this.discount = discount;
        this.list_price = list_price;
        this.quantity = quantity;
        this.product = product;
    }
      
      
    public OrderItem(int item_id, int discount, double list_price, int quantity, Product product) {
        this.item_id = item_id;
        this.discount = discount;
        this.list_price = list_price;
        this.quantity = quantity;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public OrderItem() {
    }

    public OrderItem(int item_id, int order_id, int product_id, int discount, int quantity, double list_price, Order order) {
        this.item_id = item_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.discount = discount;
        this.quantity = quantity;
        this.list_price = list_price;
        this.order = order;
    }

    
    public OrderItem(int item_id, int order_id, int product_id, int discount, int quantity, double list_price) {
        this.item_id = item_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.discount = discount;
        this.quantity = quantity;
        this.list_price = list_price;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getList_price() {
        return list_price;
    }

    public void setList_price(double list_price) {
        this.list_price = list_price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Double orderItemPrice() {
     return list_price * (1 - (discount * 0.01)) * quantity;
    }
    
    public String getorderItemPrice() {
        String formattedPrice = String.format("%,.0f", orderItemPrice());
        formattedPrice = formattedPrice.replace(",", ".");
        return formattedPrice;
    }
    @Override
    public String toString() {
        return "OrderItem{" + "item_id=" + item_id + ", order_id=" + order_id + ", product_id=" + product_id + ", discount=" + discount + ", quantity=" + quantity + ", list_price=" + list_price + '}';
    }
         
         
}
