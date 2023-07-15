package Model;

import Utils.Invalidation;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class Products {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Timestamp madeAtDate;
    private Integer manuFacturerId;
    private Timestamp expirationDate;
    private Timestamp createdAt;
    private Integer categoryId;
    public Products(){
        // Initialize the madeAtDate field without hours, minutes, and seconds components
//        Calendar calendar = Calendar.getInstance();
//        calendar.clear(Calendar.HOUR_OF_DAY);
//        calendar.clear(Calendar.MINUTE);
//        calendar.clear(Calendar.SECOND);
//        calendar.clear(Calendar.MILLISECOND);
//        this.madeAtDate = new Timestamp(calendar.getTimeInMillis());
    } /*Constructor*/
    public Products(Integer id, String name, String description, Double price, Timestamp madeAtDate, Integer manuFacturerId, Timestamp expirationDate, Timestamp createdAt, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.madeAtDate = madeAtDate;
        this.manuFacturerId = manuFacturerId;
        this.expirationDate = expirationDate;
        this.createdAt = createdAt;
        this.categoryId = categoryId;
    }
    public Products addProducts(Scanner scanner) throws SQLException {
        name = Invalidation.getProductName("Enter product name: ",scanner);
        description = Invalidation.getString("Enter description: ",scanner);
        price = Invalidation.getDouble("Enter price: ",scanner);
        manuFacturerId = Invalidation.getCheckManuId("Enter manufacturer id: ",scanner);
        categoryId = Invalidation.getCheckCategoryId("Enter category id: ",scanner);
        madeAtDate = Invalidation.getTimestamp("Enter made at date(yyyy-mm-dd hh:mm:ss): ",scanner);
        expirationDate = Invalidation.getTimestamp("Enter expiration date: ", scanner);
        createdAt = new Timestamp(System.currentTimeMillis());
        return this;
    }
    /*getter and setter*/
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Timestamp getMadeAtDate() {
        return madeAtDate;
    }
    public void setMadeAtDate(Timestamp madeAtDate) {
        this.madeAtDate = madeAtDate;
    }
    public Integer getManuFacturerId() {
        return manuFacturerId;
    }
    public void setManuFacturerId(Integer manuFacturerId) {
        this.manuFacturerId = manuFacturerId;
    }
    public Timestamp getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", madeAtDate=" + madeAtDate +
                ", manuFacturerId=" + manuFacturerId +
                ", expirationDate=" + expirationDate +
                ", createdAt=" + createdAt +
                ", categoryId=" + categoryId +
                '}';
    }
}
