package Repository;

import Model.Users;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/final_project_sms";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Radom1771";
    private final static String INSERT_USER = """
            INSERT INTO users ( username, email, password, gender, role, remark, is_disabled, created_at)
            VALUES (?,?, ?,?, ?,?, ?,?);
            """;
    private final static String UPDATE_USER = """
            UPDATE users
            SET username    = ?,
                email       = ?,
                password    = ?,
                gender      = ?,
                role        = ?,
                remark      = ?,
                is_disabled = ?,
                created_at = ?
            WHERE id = ?
            """;
    public final static String DELETE_USER= """
           DELETE FROM users WHERE id=?;
            """;
    public static List<Users> getAllUsers() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
        ) {
            List<Users> users = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("select *from users");
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String gender = resultSet.getString("gender");
                String role = resultSet.getString("role");
                String remark = resultSet.getString("remark");
                Boolean isDisabled = resultSet.getBoolean("is_disabled");
                Timestamp createdAt = resultSet.getTimestamp("created_at");
                Users user = new Users(id, username, email, password, gender, role, remark, isDisabled, createdAt);
                users.add(user);
            }
            return users;
        }catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }
    public static void setInsertUser(Users user) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getRemark());
            preparedStatement.setBoolean(7, user.getDisabled());
            preparedStatement.setTimestamp(8, user.getCreatedAt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Inserting User: " + e.getMessage());
        }
    }
    public static void setUpdateUser(Users user, int update_id){
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getRemark());
            preparedStatement.setBoolean(7, user.getDisabled() != null && user.getDisabled());
            preparedStatement.setTimestamp(8, user.getCreatedAt());
            preparedStatement.setInt(9,update_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Updating User: " + e.getMessage());
        }
    }
    public  static void setDeleteUser(Integer delete_id){
        try (Connection connection  = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)){
            preparedStatement.setInt(1,delete_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Deleting User: "+e.getMessage());
        }
    }

}
