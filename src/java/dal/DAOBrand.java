/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Brand;
import entity.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author HP
 */
public class DAOBrand extends DBConnect {
    
    public Vector<Brand> getAllBrand() {
     Vector<Brand> list = new Vector<>();
     String sql = "Select * from brands";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Brand brand = new Brand(
                        rs.getInt("brand_id"),
                        rs.getString("brand_name"),
                        rs.getString("brand_phone"),
                        rs.getString("brand_email"),
                        rs.getString("address")
                );
                list.add(brand);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void deleteBrand() {
        String sql = "DELETE FROM [dbo].[brands]\n"
                + "      WHERE brands_id = ?\n";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public int updateCategory(Brand brand) {
        String sql = "UPDATE [dbo].[brands]\n"
                + "   SET [brand_name] = ?\n"
                + "      ,[brand_phone] = ?\n"
                + "      ,[brand_email] = ?\n"
                + "      ,[address] = ?\n"
                + " WHERE [brand_id] = ?";
        int n = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, brand.getBrand_name());
            st.setString(2, brand.getBrand_phone());
            st.setString(3, brand.getBrand_email());
            st.setString(4, brand.getAddress());
            st.setInt(5, brand.getBrand_id());
            n = st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
}
