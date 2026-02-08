package controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.google.gson.Gson;
import service.ProductService;
import model.Product;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

public class ProductHandler implements HttpHandler {
    private final ProductService service;
    private final Gson gson = new Gson();

    public ProductHandler(ProductService service) {
        this.service = service;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Разрешаем запросы с любого сайта (CORS)
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

        if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            exchange.sendResponseHeaders(204, -1);
            return;
        }

        if (exchange.getRequestMethod().equalsIgnoreCase("GET")) {
            // Отдаем список товаров
            List<Product> products = service.getAllProducts();
            String jsonResponse = gson.toJson(products);
            sendResponse(exchange, jsonResponse, 200);

        } else if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            // Принимаем новый товар
            try (InputStreamReader reader = new InputStreamReader(exchange.getRequestBody())) {
                Product p = gson.fromJson(reader, Product.class);
                boolean success = service.addProduct(p.getId(), p.getName(), p.getPrice(), p.getCategory());

                String response = success ? "{\"message\":\"Product added\"}" : "{\"message\":\"Error adding product\"}";
                sendResponse(exchange, response, success ? 201 : 400);
            } catch (Exception e) {
                e.printStackTrace();
                sendResponse(exchange, "{\"error\":\"Invalid JSON\"}", 400);
            }
        } else {
            sendResponse(exchange, "{\"error\":\"Method not allowed\"}", 405);
        }
    }

    private void sendResponse(HttpExchange exchange, String response, int statusCode) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}