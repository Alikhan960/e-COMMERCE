package repository;

import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresRepository implements IProductRepository {
    // Настройки БД
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    public PostgresRepository() {
        // При создании репозитория проверяем таблицу
        createTable();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS products (" +
                "id VARCHAR(50) PRIMARY KEY, " +
                "name VARCHAR(255), " +
                "price DOUBLE PRECISION, " +
                "category VARCHAR(100))";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean add(Product product) {
        String sql = "INSERT INTO products (id, name, price, category) VALUES (?, ?, ?, ?) " +
                "ON CONFLICT (id) DO NOTHING";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getId());
            pstmt.setString(2, product.getName());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setString(4, product.getCategory());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Используем Builder (паттерн) для создания объекта из базы
                Product p = new Product.Builder()
                        .setId(rs.getString("id"))
                        .setName(rs.getString("name"))
                        .setPrice(rs.getDouble("price"))
                        .setCategory(rs.getString("category"))
                        .build();
                products.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getById(String id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Product.Builder()
                        .setId(rs.getString("id"))
                        .setName(rs.getString("name"))
                        .setPrice(rs.getDouble("price"))
                        .setCategory(rs.getString("category"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}