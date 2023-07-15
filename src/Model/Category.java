package Model;
import Utils.Invalidation;

import java.sql.Timestamp;
import java.util.Scanner;

public class Category {
    private Integer id;
    private String name;
    private String description;
    private Timestamp createdAt;
    public Category() {}
    public Category(Integer id, String name, String description, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
    public Category addCategory(Scanner scanner){
         name = Invalidation.getCategoryName("Enter category name: ",scanner);
         description = Invalidation.getString("Enter description: ",scanner);
        createdAt = new Timestamp(System.currentTimeMillis());
        return this;
    }
    public void show() {
        System.out.println("Category ID: "+id);
        System.out.println("Category Name: "+name);
        System.out.println("Description: "+description);
        System.out.println("Creat at: "+createdAt);
    }
}
