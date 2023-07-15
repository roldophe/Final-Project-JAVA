package Model;

import Utils.Invalidation;

import java.sql.Timestamp;
import java.util.Scanner;

public class Users {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String gender;
    private String role;
    private String remark;
    private Boolean isDisabled;
    private Timestamp createdAt;

    public Users() {
    }  /*Constructor*/

    public Users(Integer id, String username, String email, String password, String gender, String role, String remark, Boolean isDisabled, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.remark = remark;
        this.isDisabled = isDisabled != null ? isDisabled : false; // initialize to false if null
        this.createdAt = createdAt;
    }

    /*setter and getter*/
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getDisabled() {
        return isDisabled;
    }

    public void setDisabled(Boolean disabled) {
        isDisabled = disabled;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Users addUser(Scanner scanner) {
        String username = Invalidation.getUniqueName("Enter username: ", scanner);
        String email = Invalidation.getSignIn("Enter email:", scanner);
        String password = Invalidation.getSignIn("Enter password:", scanner);
        String gender = Invalidation.getString("Enter gender:",scanner);
        String role = Invalidation.getString("Enter role:",scanner);
        String remark = Invalidation.getString("Enter remark:",scanner);
        Boolean isDisabled = Invalidation.getBoolean("Is disabled(true or false):", scanner);
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        return new Users(null, username, email, password, gender, role, remark, isDisabled, createdAt);
    }
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", remark='" + remark + '\'' +
                ", isDisabled=" + isDisabled +
                ", createdAt=" + createdAt +
                '}';
    }

}
