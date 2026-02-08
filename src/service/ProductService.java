package service;

import repository.IProductRepository;
import model.Product;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private final IProductRepository repository; // DIP: зависим от интерфейса

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.getAll();
    }

    public Product getProductById(String id) {
        return repository.getById(id);
    }

    public boolean addProduct(String id, String name, double price, String category) {
        // Тут можно добавить проверку (валидацию), например, цена > 0
        if (price < 0) return false;

        // Используем Builder
        Product product = new Product.Builder()
                .setId(id)
                .setName(name)
                .setPrice(price)
                .setCategory(category)
                .build();

        return repository.add(product);
    }

    // ЛЯМБДА-ВЫРАЖЕНИЕ (Требование методички!)
    public List<Product> filterByPrice(double minPrice) {
        return repository.getAll().stream()
                .filter(p -> p.getPrice() >= minPrice) // Лямбда
                .collect(Collectors.toList());
    }
}