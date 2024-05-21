/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Order;
import entity.OrderItem;
import entity.Product;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author HP
 */
public class DAOOrderItem extends DBConnect {


    public Vector<OrderItem> getOrderDetail(int OrderId) {
        String sql = "SELECT * FROM Order_items O\n"
                + "JOIN Products P ON P.product_id = O.product_id\n"
                + "WHERE O.order_id = ?";
        Vector<OrderItem> list = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, OrderId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product Pro = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_img")
                );
                
                OrderItem OI = new OrderItem(
                        rs.getInt("item_id"),
                        rs.getInt("discount"),
                        rs.getDouble("list_price"),
                        rs.getInt("quantity"),
                        Pro
                );
                list.add(OI);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Vector<OrderItem> getAllOrderDetail() {
        String sql = "SELECT * FROM Order_items O\n"
                + "JOIN Products P ON P.product_id = O.product_id";
        Vector<OrderItem> list = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product Pro = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_img")
                );
                
                OrderItem OI = new OrderItem(
                        rs.getInt("order_id"),
                        rs.getInt("item_id"),
                        rs.getInt("discount"),
                        rs.getDouble("list_price"),
                        rs.getInt("quantity"),
                        Pro
                );
                list.add(OI);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Vector<OrderItem> getOrderItemByOrderId(int OrderId) {
        String sql = "Select * from order_items where order_id = ?";
        Vector<OrderItem> list = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, OrderId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderItem OI = new OrderItem(
                        rs.getInt("item_id"),
                        rs.getInt("order_id"),
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getInt("quantity"),
                        rs.getDouble("list_price")
                );
                list.add(OI);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Vector<OrderItem> getAllOrderItem() {
        String sql = "SELECT * FROM [order_items]";
        Vector<OrderItem> list = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderItem OI = new OrderItem(
                        rs.getInt("item_id"),
                        rs.getInt("order_id"),
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getInt("quantity"),
                        rs.getDouble("list_price")
                );
                list.add(OI);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
