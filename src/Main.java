import com.sun.net.httpserver.HttpServer;
import controller.ProductHandler;
import repository.IProductRepository;
import repository.PostgresRepository;
import service.ProductService;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Создаем репозиторий (Работа с БД)
            IProductRepository repository = new PostgresRepository();

            // 2. Создаем сервис (Бизнес-логика + Лямбды)
            ProductService productService = new ProductService(repository);

            // 3. Добавим тестовые данные, если база пустая (через сервис)
            if (productService.getAllProducts().isEmpty()) {
                productService.addProduct("P001", "Gaming Laptop", 1500.0, "Electronics");
                productService.addProduct("P002", "Wireless Mouse", 50.0, "Accessories");
                System.out.println("[DB] Test data added.");
            }

            // 4. Настройка сервера
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            // Регистрируем наш обработчик для пути /products
            server.createContext("/products", new ProductHandler(productService));

            server.setExecutor(null);
            System.out.println("=====================================");
            System.out.println("   E-COMMERCE SYSTEM IS RUNNING");
            System.out.println("   URL: http://localhost:8080/products");
            System.out.println("=====================================");
            server.start();

        } catch (IOException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}