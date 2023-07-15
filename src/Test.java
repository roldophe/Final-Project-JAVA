import java.sql.*;

public class Test {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/final_project_sms";
        final String USER = "postgres";
        final String PASSWORD = "Radom1771";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("""
                    SELECT s.id, s.product_id, p.name  "Pro_name", p.category_id, c.name as "Cat_name", s.qty, p.price,
                     s.qty * p.price "Total price",
                      m.name as "Manu_name", s.created_at, u.id as user_id, u.username
                    FROM stocks s
                    JOIN products p ON s.product_id = p.id
                    JOIN category c ON p.category_id = c.id
                    JOIN manufacturer m ON p.manufacturer_id = m.id
                    JOIN users u ON s.user_id = u.id
                    """);
            while (rs.next()) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
