package Repository;

import Model.Manufacturer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ManufacturerRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/final_project_sms";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Radom1771";
    private static final String INSERT_MANUFACTURER = """
            INSERT INTO public.manufacturer (name, description, address, license)
            VALUES (?, ?, ?, ?);
            """;
    private static final String UPDATE_MANUFACTURER= """
            UPDATE public.manufacturer
            SET name        = ?,
                description = ?,
                address     = ?,
                license     = ?
            WHERE id = ?;
            """;
    private static final String DELETE_MANUFACTURER= """
            DELETE
            FROM public.manufacturer
            WHERE id =?;
            """;
    public static void setInsertManufacturer(Manufacturer insert) throws SQLException{
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement(INSERT_MANUFACTURER)
        ){
            statement.setString(1,insert.getName());
            statement.setString(2,insert.getDescription());
            statement.setString(3,insert.getAddress());
            statement.setString(4,insert.getLicense());
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error inserting manufacturer: "+e.getMessage());
        }
    }
    public static void setUpdateManufacturer(Manufacturer update, Integer update_id){
        try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement(UPDATE_MANUFACTURER)
        ){
            statement.setString(1,update.getName());
            statement.setString(2,update.getDescription());
            statement.setString(3,update.getAddress());
            statement.setString(4,update.getLicense());
            statement.setInt(5,update_id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error updating manufacturer: "+e.getMessage());
        }
    }
    public static void setDeleteManufacturer(Integer delete_id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(DELETE_MANUFACTURER)
        ) {
            statement.setInt(1, delete_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Manufacturer> getAllManufacturers ()throws SQLException{
        try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
             Statement statement = connection.createStatement()
        ) {
            List<Manufacturer> manufacturers = new ArrayList<>();
            ResultSet resultSet= statement.executeQuery("select *from manufacturer");
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String address  = resultSet.getString("address");
                String license = resultSet.getString("license");
                Manufacturer manufacturer = new Manufacturer(id, name, description,address,license);
                manufacturers.add(manufacturer);
            }
            return manufacturers;
        }catch (SQLException e){
            System.out.println("Error connecting to database: "+e.getMessage());
            e.printStackTrace();
            return null;
        }

    }
}
