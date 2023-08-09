package Repository;
import Model.Stocks;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StocksRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Radom1771";
    private static final String GET_STOCKS= """
            SELECT s.id, s.product_id, p.name  "Pro_name", p.category_id, c.name as "Cat_name", s.qty, p.price,
                     s.qty * p.price "Total price",
                      m.name as "Manu_name", s.created_at, u.id as user_id, u.username
                    FROM stocks s
                    JOIN products p ON s.product_id = p.id
                    JOIN category c ON p.category_id = c.id
                    JOIN manufacturer m ON p.manufacturer_id = m.id
                    JOIN users u ON s.user_id = u.id
            """;
    private static final String GET_STOCKS_ISNULL= """
            SELECT s.id, s.product_id, p.name as "Pro_name", p.category_id, c.name as "Cat_name", s.qty, p.price,
                     s.qty * p.price "Total price",
                      m.name as "Manu_name", s.created_at, u.id as user_id, u.username
                FROM stocks as s
                FULL OUTER JOIN products AS p ON s.product_id = p.id
                FULL OUTER JOIN category c on c.id = p.category_id
                FULL OUTER JOIN manufacturer m on m.id = p.manufacturer_id
                FULL OUTER JOIN users u on u.id = s.user_id
            WHERE p.id IS NOT NULL OR s.id IS NULL\s
            """;
    public static List<Stocks> getStocks (){
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(GET_STOCKS);
            List<Stocks> stocks = new ArrayList<>();
            while (rs.next()){
                Integer id = rs.getInt("id");
                Integer pro_id = rs.getInt("product_id");
                String pro_name = rs.getString("Pro_name");
                Integer cat_id = rs.getInt("category_id");
                String cat_name = rs.getString("Cat_name");
                Integer qty = rs.getInt("qty");
                Double price = rs.getDouble("price");
                Double total_price = rs.getDouble("Total price");
                String manu_name = rs.getString("Manu_name");
                Timestamp created_at = rs.getTimestamp("created_at");
                Integer user_id = rs.getInt("user_id");
                String username = rs.getString("username");
                Stocks stock = new Stocks(id,pro_id,pro_name,cat_id,cat_name,qty,price,total_price,manu_name,created_at,user_id,username);
                stocks.add(stock);
            }
            return stocks;
            /*while (rs.next()) {
                int id = rs.getInt("id");
                int pro_id = rs.getInt("product_id");
                String pro_name = rs.getString("Pro_name");
                int cat_id = rs.getInt("category_id");
                String cat_name = rs.getString("Cat_name");
                int qty = rs.getInt("qty");
                double price = rs.getDouble("price");
                double total_price = rs.getDouble("Total price");
                String manu_name = rs.getString("Manu_name");
                Timestamp created_at = rs.getTimestamp("created_at");
                int user_id = rs.getInt("user_id");
                String username = rs.getString("username");
                System.out.println("Result: ");
                System.out.println("Stock ID: " + id +
                        "\nPro_Id: " + pro_id +
                        "\tPro_Name: " + pro_name +
                        "\tCat_ID: " + cat_id +
                        "\tCat_Name : " + cat_name +
                        "\tQuantity: " + qty +
                        "\tPrice:" + price +
                        "\tTotal Price: " + total_price +
                        "\tManu_Name: " + manu_name +
                        "\tCreated_At: " + created_at +
                        "\tUser_ID: " + user_id +
                        "\tUser_Name: " + username);
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to database: "+e.getMessage());
            return null;
        }
    }
    public static List<Stocks> getStocksIsNUll (){
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(GET_STOCKS_ISNULL);
            List<Stocks> getStocks = new ArrayList<>();
            while (rs.next()){
                Integer id = rs.getInt("id");
                Integer pro_id = rs.getInt("product_id");
                String pro_name = rs.getString("Pro_name");
                Integer cat_id = rs.getInt("category_id");
                String cat_name = rs.getString("Cat_name");
                Integer qty = rs.getInt("qty");
                Double price = rs.getDouble("price");
                Double total_price = rs.getDouble("Total price");
                String manu_name = rs.getString("Manu_name");
                Timestamp created_at = rs.getTimestamp("created_at");
                Integer user_id = rs.getInt("user_id");
                String username = rs.getString("username");
                Stocks stock = new Stocks(id,pro_id,pro_name,cat_id,cat_name,qty,price,total_price,manu_name,created_at,user_id,username);
                getStocks.add(stock);
            }
            return getStocks;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to database: "+e.getMessage());
            return null;
        }
    }
    private static final String ADD_STOCK = """        
            INSERT INTO public.stocks (qty, created_at, user_id, product_id)
            VALUES (?,?,?,?);
            """;
    private static final String UPDATE_STOCK = """
            UPDATE public.stocks
            SET qty        = ?,
                created_at = ?,
                user_id    = ?,
                product_id = ?
            WHERE id = ?;
            """;
    private static final String UPDATE_QTY = """
            UPDATE public.stocks
            SET qty        = ?
            WHERE id = ?;
            """;
    private static final String DELETE_STOCK = """
            DELETE FROM public.stocks
            WHERE id = ?;
            """;
//    private static final String GET_STOCK= """
//            SELECT s.id, s.pro_id, p.pro_name, p.cat_id, c.cat_name, s.gty, p.price, s.gty * p.price as "Total price", m.manu_name, s.created_at, u.id as user_id, u.username
//            FROM stocks s
//            JOIN products p ON s.pro_id = p.pro_id
//            JOIN category c ON p.cat_id = c.cat_id
//            JOIN manufacturer m ON p.manu_id = m.manu_id
//            JOIN users u ON s.user_id = u.id;
//            """;
//    public static List<Stocks> getAllStocks() throws SQLException {
//        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//             Statement selectStatement = connection.createStatement();
//        ) {
//            ResultSet resultSet = selectStatement.executeQuery("Select * from stocks");
//            List<Stocks> stocks = new ArrayList<>();
//            while (resultSet.next()) {
//                Integer id = resultSet.getInt("id");
//                Integer qty = resultSet.getInt("qty");
//                Timestamp createdAt = resultSet.getTimestamp("created_at");
//                Integer user_id = resultSet.getInt("user_id");
//                Integer productId = resultSet.getInt("product_id");
//                Stocks stock = new Stocks(id, user_id, qty, productId, createdAt);
//                stocks.add(stock);
//            }
//            return stocks;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.err.println("Error connecting to database: " + e.getMessage());
//            return null;
//        }
//    }

    public static void setAddStock(Stocks addStock) {
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement(ADD_STOCK)
        ){
            statement.setInt(1,addStock.getQty());
            statement.setTimestamp(2,addStock.getCreated_at());
            statement.setInt(3,addStock.getUser_id());
            statement.setInt(4,addStock.getPro_id());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error adding stocks: "+e.getMessage());
        }
    }
    public static void setUpdateStock(Stocks addStock,Integer update_id) {
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement(UPDATE_STOCK)
        ){
            statement.setInt(1,addStock.getQty());
            statement.setTimestamp(2,addStock.getCreated_at());
            statement.setInt(3,addStock.getUser_id());
            statement.setInt(4,addStock.getPro_id());
            statement.setInt(5,update_id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error updating stocks: "+e.getMessage());
        }
    }
    public static void setUpdateQTY(Integer update_id,Integer update_qty){
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement(UPDATE_QTY)
        ){
            statement.setInt(1,update_qty);
            statement.setInt(2,update_id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error updating stocks: "+e.getMessage());
        }
    }
    public static void setDeleteStock(Integer update_id)  {
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement(DELETE_STOCK)
        ){
            statement.setInt(1,update_id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error deleting stocks: "+e.getMessage());
        }
    }
}
