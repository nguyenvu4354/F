/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class Product {
  
    private int product_id, category_id, brand_id, discount;
    private String product_name, product_img, product_desc;
    private Double list_price;
    private Date date_added;
    private int quantity;

    private  Brand brand;
    private Category category;
    
    public Product() {
    }

    public Product(int product_id, String product_name, String product_img,
            Double list_price, Brand brand, Category category,
            int quantity, int discount
    ) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_img = product_img;
        this.list_price = list_price;
        this.brand = brand;
        this.category = category;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Product(int product_id, String product_name, String product_img) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_img = product_img;
    }
    
    public Product(int product_id, int category_id, int brand_id, int discount, String product_name, String product_img, String product_desc, Double list_price, Date date_added, int quantity) {
        this.product_id = product_id;
        this.category_id = category_id;
        this.brand_id = brand_id;
        this.discount = discount;
        this.product_name = product_name;
        this.product_img = product_img;
        this.product_desc = product_desc;
        this.list_price = list_price;
        this.date_added = date_added;
        this.quantity = quantity;
    }

    public Product(int product_id, int discount, String product_name, String product_img, String product_desc, Double list_price, Date date_added, int quantity, Brand brand, Category category) {
        this.product_id = product_id;
        this.discount = discount;
        this.product_name = product_name;
        this.product_img = product_img;
        this.product_desc = product_desc;
        this.list_price = list_price;
        this.date_added = date_added;
        this.quantity = quantity;
        this.brand = brand;
        this.category = category;
    }

    
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public Double getList_price() {
        return list_price;
    }

    public void setList_price(Double list_price) {
        this.list_price = list_price;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBrandName() {
        return brand.getBrand_name();
    }

    public String getCategoryName() {
        return category.getCategory_name();
    }

    public String getPrice() {
        String formattedPrice = String.format("%,.0f", list_price);
        formattedPrice = formattedPrice.replace(",", ".");
        return formattedPrice;
    }
    
    public String getPriceAfterDiscount() {
        double productPrice = list_price*(1-discount*0.01);
        String formattedPrice = String.format("%,.0f", productPrice);
        formattedPrice = formattedPrice.replace(",", ".");
        return formattedPrice;
    }
    
    public String getPriceTotal() {
        double productPrice = list_price*(1-discount*0.01)*quantity;
        String formattedPrice = String.format("%,.0f", productPrice);
        formattedPrice = formattedPrice.replace(",", ".");
        return formattedPrice;
    }
    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", category_id=" + category_id + ", brand_id=" + brand_id + ", discount=" + discount + ", product_name=" + product_name + ", product_img=" + product_img + ", product_desc=" + product_desc + ", list_price=" + list_price + ", date_added=" + date_added + ", quantity=" + quantity + '}';
    }

    
}
