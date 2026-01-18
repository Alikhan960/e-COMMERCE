import java.util.*;

public class Main {
    public static void main(String[] args) {
        DBManager db = new DBManager();
        db.createTables();

        // 1. DB products
        System.out.println("\n--- Добавление новых товаров ---");
        db.saveProduct("P001", "Laptop", 1200.0, "Electronics");
        db.saveProduct("P002", "Mechanical Keyboard", 150.0, "Accessories");
        db.saveProduct("P003", "Gaming Monitor", 300.0, "Electronics");
        db.saveProduct("P004", "Java Course", 50.0, "Education");
        db.saveProduct("P005", "Wireless Mouse", 40.0, "Accessories");

        db.printAllProductsFromDB();

        // update and delete to demonstrate CRUD
        db.updatePrice("P001", 1100.0);
        db.deleteProduct("P002"); // Удалим клавиатуру

        System.out.println("\nList of products after changing");
        db.printAllProductsFromDB();

        // 2. DB shoppers
        System.out.println("\n=== Тестирование Shoppers ===");
        db.saveShopper("Alikhan", "alikhan@example.com");
        db.saveShopper("Arman", "arman@mail.kz");
        db.saveShopper("Sergey", "sergey_dev@gmail.com");
        db.saveShopper("Aruzhan", "aru_star@list.ru");

        db.printAllShoppersFromDB();

        // 3. just java classes
        System.out.println("\n--- Работа с Java-объектами (через интерфейс Entity) ---");
        User user = new User("U01", "Alikhan960", "Admin");
        user.displayDetails();

        Order order = new Order("OR-2024", "Arman_ID", 1500.0);
        order.displayDetails();
    }
}