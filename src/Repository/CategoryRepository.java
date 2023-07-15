package Repository;

import Model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/final_project_sms";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Radom1771";
    public final static  String  INSERT_CATEGORY ="""
                    INSERT INTO public.category (name, description, create_at)
                    VALUES (?, ?, ?);
            """;
    public final static String UPDATE_CATEGORY = """
            UPDATE public.category
            SET name        = ?,
                description = ?,
                create_at   = ?
            WHERE id = ?;
            """;
    public  final static String DELETE_CATEGORY="""
            DELETE FROM public.category
            WHERE id = ?;
            """;
    public static void setInsertCategory(Category insert){
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY);
        ) {
            preparedStatement.setString(1,insert.getName());
            preparedStatement.setString(2,insert.getDescription());
            preparedStatement.setTimestamp(3,insert.getCreatedAt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Inserting category: "+e.getMessage());
        }
    }
    public static void setDeleteCategory(Integer delete_id) throws SQLException {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY)){
            statement.setInt(1,delete_id);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error deleting category: "+e.getMessage());
        }
    }
    public static void setUpdateCategory(Category update,Integer update_id){
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement updated = connection.prepareStatement(UPDATE_CATEGORY);
        ){
            updated.setString(1,update.getName());
            updated.setString(2,update.getDescription());
            updated.setTimestamp(3,update.getCreatedAt());
            updated.setInt(4,update_id);
            updated.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error Updating Category: "+e.getMessage());
        }
    }
    public static List<Category> getCategories() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement selectStatement = connection.createStatement();
        ) {
            ResultSet resultSet = selectStatement.executeQuery("Select * from category");
            List<Category> categories = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Timestamp createdAt = resultSet.getTimestamp("create_at");
                Category category = new Category(id, name, description, createdAt);
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }

}
