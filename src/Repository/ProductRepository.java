package Repository;

import Model.Products;
import jdk.jshell.spi.SPIResolutionException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/final_project_sms";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Radom1771";
    private static final String INSERT_PRODUCTS = """
            INSERT INTO public.products (
                name,
                description,
                price,
                made_at_date,
                expiration_date,
                created_at,
                manufacturer_id,
                category_id)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?);
            """;
    private static final String UPDATE_PRODUCTS = """
            UPDATE public.products
            SET name            = ?,
                description     = ?,
                price           = ?,
                made_at_date    = ?,
                expiration_date = ?,
                created_at      = ?,
                manufacturer_id = ?,
                category_id     = ?
            WHERE id = ?;
                        
            """;
    private static final String DELETE_PRODUCTS = """
            DELETE
            FROM public.products
            WHERE id = ?;
            """;
    public static List<Products> getAllProducts() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); Statement statement = connection.createStatement();) {
            List<Products> products = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("select *from products");
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Double price = resultSet.getDouble("price");
                Timestamp madeAtDate = resultSet.getTimestamp("made_at_date");
                Timestamp expirationDate = resultSet.getTimestamp("expiration_date");
                Timestamp createdAt = resultSet.getTimestamp("created_at");
                Integer manufacturerId = resultSet.getInt("manufacturer_id");
                Integer categoryId = resultSet.getInt("category_id");
                Products product = new Products(id, name, description, price, madeAtDate, manufacturerId, expirationDate, createdAt, categoryId);
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }
    public static void setInsertProducts(Products insertProducts) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCTS);
        ) {
            statement.setString(1, insertProducts.getName());
            statement.setString(2, insertProducts.getDescription());
            statement.setDouble(3, insertProducts.getPrice());
            statement.setTimestamp(4, insertProducts.getMadeAtDate());
            statement.setTimestamp(5, insertProducts.getExpirationDate());
            statement.setTimestamp(6, insertProducts.getCreatedAt());
            statement.setInt(7, insertProducts.getManuFacturerId());
            statement.setInt(8, insertProducts.getCategoryId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting products: " + e.getMessage());
        }
    }
    public static void setUpdateProducts(Products insertProducts, Integer update_id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS);
        ) {
            statement.setString(1, insertProducts.getName());
            statement.setString(2, insertProducts.getDescription());
            statement.setDouble(3, insertProducts.getPrice());
            statement.setTimestamp(4, insertProducts.getMadeAtDate());
            statement.setTimestamp(5, insertProducts.getExpirationDate());
            statement.setTimestamp(6, insertProducts.getCreatedAt());
            statement.setInt(7, insertProducts.getManuFacturerId());
            statement.setInt(8, insertProducts.getCategoryId());
            statement.setInt(9, update_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating products: " + e.getMessage());
        }
    }
    public static void setDeleteProducts(Integer update_id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS);
        ) {
            statement.setInt(1, update_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating products: " + e.getMessage());
        }
    }
}
