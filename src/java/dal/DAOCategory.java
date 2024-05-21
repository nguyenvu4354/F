/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Brand;
import entity.Category;
import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author HP
 */
public class DAOCategory extends DBConnect {
    
    public Vector<Category> getAllCategory() {
     Vector<Category> list = new Vector<>();
     String sql = "Select * from categorys";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name")
                );
                list.add(category);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void deleteCategory() {
        String sql = "DELETE FROM [dbo].[categorys]\n"
                + "      WHERE category_id = ?\n";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public int updateCategory(Category cat) {
        String sql = "UPDATE [dbo].[categorys]\n"
                + "   SET [category_name] = ?\n"
                + " WHERE [category_id] = ?";
        int n = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cat.getCategory_name());
            st.setInt(2, cat.getCategory_id());
            n = st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
}
