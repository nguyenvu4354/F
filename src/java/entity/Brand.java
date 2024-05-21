/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HP
 */
public class Brand {
    private int brand_id;
    private String brand_name, brand_phone, brand_email, address;

    public Brand() {
    }

    public Brand(int brand_id, String brand_name, String brand_phone, String brand_email, String address) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.brand_phone = brand_phone;
        this.brand_email = brand_email;
        this.address = address;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_phone() {
        return brand_phone;
    }

    public void setBrand_phone(String brand_phone) {
        this.brand_phone = brand_phone;
    }

    public String getBrand_email() {
        return brand_email;
    }

    public void setBrand_email(String brand_email) {
        this.brand_email = brand_email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Brand{" + "brand_id=" + brand_id + ", brand_name=" + brand_name + ", brand_phone=" + brand_phone + ", brand_email=" + brand_email + ", address=" + address + '}';
    }
    
}
