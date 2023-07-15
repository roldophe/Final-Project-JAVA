package Model;

import Utils.Invalidation;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class Stocks {
    private Integer id ;
    private Integer pro_id ;
    private String pro_name;
    private Integer cat_id ;
    private String cat_name ;
    private Integer qty ;
    private Double price;
    private Double total_price;
    private String manu_name ;
    private Timestamp created_at;
    private Integer user_id ;
    private String username;
    //11field;
    public Stocks(){}

    public Stocks(Integer id, Integer pro_id,String pro_name, Integer cat_id, String cat_name, Integer qty, Double price, Double total_price, String manu_name, Timestamp created_at, Integer user_id, String username) {
        this.id = id;
        this.pro_id = pro_id;
        this.pro_name=pro_name;
        this.cat_id = cat_id;
        this.cat_name = cat_name;
        this.qty = qty;
        this.price = price;
        this.total_price = total_price;
        this.manu_name = manu_name;
        this.created_at = created_at;
        this.user_id = user_id;
        this.username = username;
    }
    public Stocks AddNewStock(Scanner scanner){
        this.pro_id = Invalidation.getInteger("Enter Pro_id: ",scanner);
        this.pro_name = Invalidation.getName("Enter Pro_name: ",scanner);
        this.cat_id = Invalidation.getInteger("Enter Cat_id: ",scanner);
        this.cat_name = Invalidation.getName("Enter Cat_name: ",scanner);
        this.qty = Invalidation.getInteger("Enter Quantity: ",scanner);
        this.price = Invalidation.getDouble("Enter Price: ",scanner);
        this.total_price = qty*price;
        this.manu_name = Invalidation.getName("Enter Manu_Name: ",scanner);
        this.created_at = new Timestamp(System.currentTimeMillis());
        this.user_id = Invalidation.getInteger("Enter User_Id: ",scanner);
        this.username = Invalidation.getName("Enter username: ",scanner);
        return this;
    }
    public Stocks AddStock(Scanner scanner) throws SQLException {
        this.pro_id = Invalidation.getCheckProId("Enter Pro_id: ",scanner);
        this.qty = Invalidation.getInteger("Enter Quantity: ",scanner);
        this.created_at = new Timestamp(System.currentTimeMillis());
        this.user_id = Invalidation.getCheckUserId("Enter User_Id: ",scanner);
        return this;
    }
    public String getPro_name() {
        return pro_name;
    }
    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPro_id() {
        return pro_id;
    }
    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }
    public Integer getCat_id() {
        return cat_id;
    }
    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }
    public String getCat_name() {
        return cat_name;
    }
    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
    public Integer getQty() {
        return qty;
    }
    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getTotal_price() {
        return total_price;
    }
    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }
    public String getManu_name() {
        return manu_name;
    }
    public void setManu_name(String manu_name) {
        this.manu_name = manu_name;
    }
    public Timestamp getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}