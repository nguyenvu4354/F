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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

/**
 *
 * @author HP
 */
public class DAOProduct extends DBConnect {

    //hien thi ban hang
    public Vector<Product> getAllProduct(String orderType) throws SQLException {
        String sql = "Select * from Products P\n"
                + " join categorys C on C.category_id = P.category_id\n"
                + " join brands B on B.brand_id = P.brand_id";
        if (orderType != null && !orderType.equals("")) {
            sql += " order by P.list_price " + orderType;
        }
        Vector<Product> list = new Vector<>();
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
                Category category = new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name")
                );
                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getString("product_name"),
                        rs.getString("product_img"),
                        rs.getString("product_desc"),
                        rs.getDouble("list_price"),
                        rs.getDate("date_added"),
                        rs.getInt("quantity"),
                        brand,
                        category
                );
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Vector<Product> getAllProduct(String start, String numPP) throws SQLException {
        String sql = "Select * from Products P\n"
                + " join categorys C on C.category_id = P.category_id\n"
                + " join brands B on B.brand_id = P.brand_id"
                + " ORDER BY P.product_id "
                + " OFFSET " + start + " ROWS FETCH NEXT " + numPP + " ROWS ONLY";
        Vector<Product> list = new Vector<>();
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
                Category category = new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name")
                );
                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getString("product_name"),
                        rs.getString("product_img"),
                        rs.getString("product_desc"),
                        rs.getDouble("list_price"),
                        rs.getDate("date_added"),
                        rs.getInt("quantity"),
                        brand,
                        category
                );
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Vector<String> getAllCategory() {
        String sql = "select Distinct category_name from products";
        Vector<String> list = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("category_name"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Vector<String> getAllBrand() {
        String sql = "select Distinct brand_name from products";
        Vector<String> list = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("brand_name"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Product getProductById(int id) {
        String sql = "Select * from Products P\n"
                + "join categorys C on C.category_id = P.category_id\n"
                + "join brands B on B.brand_id = P.brand_id WHERE P.product_id = ?";
        Product p = null;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Brand brand = new Brand(
                        rs.getInt("brand_id"),
                        rs.getString("brand_name"),
                        rs.getString("brand_phone"),
                        rs.getString("brand_email"),
                        rs.getString("address")
                );
                Category category = new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name")
                );
                p = new Product(
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getString("product_name"),
                        rs.getString("product_img"),
                        rs.getString("product_desc"),
                        rs.getDouble("list_price"),
                        rs.getDate("date_added"),
                        rs.getInt("quantity"),
                        brand,
                        category
                );
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return p;
    }

    public Vector<Product> getProductByName(String name) {
        String sql = "Select * from Products P\n"
                + "join categorys C on C.category_id = P.category_id\n"
                + "join brands B on B.brand_id = P.brand_id WHERE P.product_name like N'%" + name + "%'";
        Vector<Product> list = new Vector<>();
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
                Category category = new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name")
                );
                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getString("product_name"),
                        rs.getString("product_img"),
                        rs.getString("product_desc"),
                        rs.getDouble("list_price"),
                        rs.getDate("date_added"),
                        rs.getInt("quantity"),
                        brand,
                        category
                );
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Vector<Product> search(String[] category_name, String[] brand_name,
            String minPrice, String maxPrice, String discount, String order
    ) {
        Vector<Product> list = new Vector<>();
        String sql = "Select * from Products P\n"
                + "join categorys C on C.category_id = P.category_id\n"
                + "join brands B on B.brand_id = P.brand_id WHERE 1=1 ";

        if (category_name != null && category_name.length > 0) {
            sql += " and C.category_name in (";
            for (int i = 0; i < category_name.length; i++) {
                sql += "N'" + category_name[i] + "'";
                if (i < category_name.length - 1) {
                    sql += ",";
                }
            }
            sql += ")";
        }
        if (brand_name != null && brand_name.length > 0) {
            sql += " and B.brand_name in (";
            for (int i = 0; i < brand_name.length; i++) {
                sql += "N'" + brand_name[i] + "'";
                if (i < brand_name.length - 1) {
                    sql += ",";
                }
            }
            sql += ")";
        }
        if ((minPrice != null && maxPrice != null) && (minPrice != "" && maxPrice != "")) {
            sql += " and ((P.list_price - (P.list_price * P.discount/100)) >= "
                    + minPrice + " and (P.list_price - (P.list_price * P.discount/100)) <= " + maxPrice + " )";
        } else if (minPrice != null && minPrice != "") {
            sql += " and ((P.list_price - (P.list_price * P.discount/100)) >= " + minPrice + ")";
        } else if (maxPrice != null && maxPrice != "") {
            sql += " and ((P.list_price - (P.list_price * P.discount/100)) <= " + maxPrice + ")";
        }

        if (discount != null && discount != "") {
            sql += " and P.discount > " + discount;
        }
        
        if (order != null && order != "") {
            sql += " order by P.list_price " + order;
        }
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
                Category category = new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name")
                );
                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getString("product_name"),
                        rs.getString("product_img"),
                        rs.getString("product_desc"),
                        rs.getDouble("list_price"),
                        rs.getDate("date_added"),
                        rs.getInt("quantity"),
                        brand,
                        category
                );
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public String link(String[] category_name, String[] brand_name,
            String minPrice, String maxPrice, String discount, String order
    ) {
        String sql = "SELECT * FROM products P WHERE 1=1 ";

        if (category_name != null && category_name.length > 0) {
            sql += " and category_name in (";
            for (int i = 0; i < category_name.length; i++) {
                sql += "N'" + category_name[i] + "'";
                if (i < category_name.length - 1) {
                    sql += ",";
                }
            }
            sql += ")";
        }

        if (brand_name != null && brand_name.length > 0) {
            sql += " and brand_name in (";
            for (int i = 0; i < brand_name.length; i++) {
                sql += "N'" + brand_name[i] + "'";
                if (i < brand_name.length - 1) {
                    sql += ",";
                }
            }
            sql += ")";
        }
        if ((minPrice != null && maxPrice != null) && (minPrice != "" && maxPrice != "")) {
            sql += " and ((P.list_price - (P.list_price * P.discount/100)) >= "
                    + minPrice + " and (P.list_price - (P.list_price * P.discount/100)) <= " + maxPrice + " )";
        } else if (minPrice != null && minPrice != "") {
            sql += " and ((P.list_price - (P.list_price * P.discount/100)) >= " + minPrice + ")";
        } else if (maxPrice != null && maxPrice != "") {
            sql += " and ((P.list_price - (P.list_price * P.discount/100)) <= " + maxPrice + ")";
        }

        if (discount != null && discount != "") {
            sql += " and P.discount > " + discount;
        }
        
        if (order != null && order != "") {
            sql += " order by P.list_price " + order;
        }
        return sql;
    }

    public void addProduct(Product pro) {
        String sql = "INSERT INTO [dbo].[products]\n"
                + "           ([product_id]\n"
                + "           ,[product_name]\n"
                + "           ,[list_price]\n"
                + "           ,[discount]\n"
                + "           ,[category_id]\n"
                + "           ,[brand_id]\n"
                + "           ,[product_img]\n"
                + "           ,[date_added]\n"
                + "           ,[product_desc]\n"
                + "           ,[quantity])\n"
                + "     VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pro.getProduct_id());
            st.setString(2, pro.getProduct_name());
            st.setDouble(3, pro.getList_price());
            st.setDouble(4, pro.getDiscount());
            st.setInt(5, pro.getCategory_id());
            st.setInt(6, pro.getBrand_id());
            st.setString(7, pro.getProduct_img());
            st.setTimestamp(8, Timestamp.valueOf(getFormatDate()));
            st.setString(9, pro.getProduct_desc());
            st.setInt(10, pro.getQuantity());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
     public String getFormatDate() {
        LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
   }
    public int updateProduct(Product pro) {
        String sql = "UPDATE [dbo].[products]\n"
                + "   SET [product_name] = ?\n"
                + "      ,[list_price] = ?\n"
                + "      ,[discount] = ?\n"
                + "      ,[category_id] = ?\n"
                + "      ,[brand_id] = ?\n"
                + "      ,[product_img] = ?\n"
                + "      ,[date_added] = ?\n"
                + "      ,[product_desc] = ?\n"
                + "      ,[quantity] = ?\n"
                + " WHERE [product_id] = ?";
        int n = -1;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pro.getProduct_name());
            st.setDouble(2, pro.getList_price());
            st.setInt(3, pro.getDiscount());
            st.setInt(4, pro.getCategory_id());
            st.setInt(5, pro.getBrand_id());
            st.setString(6, pro.getProduct_img());
            st.setTimestamp(7, Timestamp.valueOf(getFormatDate()));
            st.setString(8, pro.getProduct_desc());
            st.setInt(9, pro.getQuantity());
            st.setInt(10, pro.getProduct_id());
            n = st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int deleteProduct(int pid) {
        String sql = "DELETE FROM [dbo].[products]\n"
                + " WHERE product_id = ?";
        int n = -1;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            n = st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

}
