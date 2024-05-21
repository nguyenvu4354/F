/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author HP
 */
public class Order {

    private int order_id, account_id;
    private String status;
    private Date order_date, recieve_date;
    private Vector<OrderItem> listOrder;
    private Account acc;

    
    
    public Order() {
    }

    public Order(int order_id, int account_id, String status, Date order_date, Date recieve_date) {
        this.order_id = order_id;
        this.account_id = account_id;
        this.status = status;
        this.order_date = order_date;
        this.recieve_date = recieve_date;
    }

    public Order(int order_id, String status, Date order_date, Date recieve_date, Vector<OrderItem> listOrder, Account acc) {
        this.order_id = order_id;
        this.status = status;
        this.order_date = order_date;
        this.recieve_date = recieve_date;
        this.listOrder = listOrder;
        this.acc = acc;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getRecieve_date() {
        return recieve_date;
    }

    public void setRecieve_date(Date recieve_date) {
        this.recieve_date = recieve_date;
    }

    public String getAccountFullName() {
     return acc.getFirst_name() + " " +acc.getLast_name();
    }
    
    public Double totalOrder() {
        double total = 0;
        for (OrderItem orderItem : listOrder) {
            total += orderItem.orderItemPrice();
        }
        return total;
    }
    public String getOrderTotal() {
        String formattedPrice = String.format("%,.0f", totalOrder());
        formattedPrice = formattedPrice.replace(",", ".");
        return formattedPrice;
    }
    
    public String getAccountImg() {
     return acc.getAccount_image();
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", account_id=" + account_id + ", status=" + status + ", order_date=" + order_date + ", recieve_date=" + recieve_date + '}';
    }

}
