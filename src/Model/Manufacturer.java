package Model;

import Utils.Invalidation;

import java.util.Scanner;

public class Manufacturer {
    private Integer id;
    private String name;
    private String description;
    private String address;
    private String license;

    /*Constructor*/
    public Manufacturer(){}

    public Manufacturer(Integer id, String name, String description, String address, String license) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.license = license;
    }
    public Manufacturer addManufacturer(Scanner scanner){
        name=Invalidation.getName("Enter Manu_Name: ",scanner);
        description=Invalidation.getString("Enter description: ",scanner);
        address=Invalidation.getString("Enter address: ",scanner);
        license=Invalidation.getName("Enter license: ",scanner);
        return this;
    }
    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", license='" + license + '\'' +
                '}';
    }
    /*Setter and Getter*/
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
}
