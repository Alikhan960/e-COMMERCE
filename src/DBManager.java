import java.sql.*;

public class DBManager {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void createTables() {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            // Create table fo e commerce
            stmt.execute("CREATE TABLE IF NOT EXISTS products (id VARCHAR(50) PRIMARY KEY, name VARCHAR(255), price DOUBLE PRECISION, category VARCHAR(100))");
            stmt.execute("CREATE TABLE IF NOT EXISTS shoppers (id SERIAL PRIMARY KEY, name VARCHAR(100), email VARCHAR(100))");

            stmt.execute("TRUNCATE TABLE shoppers RESTART IDENTITY");

            System.out.println("[DB] The database is ready: the products and shoppers tables have been created.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void saveProduct(String id, String name, double price, String category) {
        String sql = "INSERT INTO products (id, name, price, category) VALUES (?, ?, ?, ?) ON CONFLICT (id) DO NOTHING";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, price);
            pstmt.setString(4, category);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void printAllProductsFromDB() {
        String sql = "SELECT * FROM products";
        System.out.println("--- Products in Database ---");
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %-5s | Name: %-20s | Price: %8.2f | Cat: %s\n",
                        rs.getString("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("category"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void updatePrice(String id, double newPrice) {
        String sql = "UPDATE products SET price = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newPrice);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
            System.out.println("[DB] Price of product" + id + " updated to" + newPrice);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void deleteProduct(String id) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            System.out.println("[DB] Product " + id + " deleted.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void saveShopper(String name, String email) {
        String sql = "INSERT INTO shoppers (name, email) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("[DB] Shopper " + name + " saved.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void printAllShoppersFromDB() {
        String sql = "SELECT * FROM shoppers";
        System.out.println("\n--- Shoppers in Database ---");
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("Shopper ID: %-3d | Name: %-10s | Email: %s\n",
                        rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
