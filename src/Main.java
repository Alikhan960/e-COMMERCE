import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Data pool: Lists to organize products, shoppers, and orders
        List<Product> products = new ArrayList<>();
        products.add(new PhysicalProduct("P001", "Laptop", 1200.0, "Electronics", 2.5));
        products.add(new PhysicalProduct("P002", "Book", 20.0, "Books", 0.5));
        products.add(new DigitalProduct("P003", "E-Book", 10.0, "Books", "PDF"));

        List<Shopper> shoppers = new ArrayList<>();
        shoppers.add(new Shopper("S001", "Alice", "alice@email.com"));
        shoppers.add(new Shopper("S002", "Bob", "bob@email.com"));

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("O001", shoppers.get(0), Arrays.asList(products.get(0), products.get(1))));
        orders.add(new Order("O002", shoppers.get(1), Arrays.asList(products.get(2))));

        // Display full data pool
        System.out.println("--- Full Products ---");
        products.forEach(System.out::println);
        System.out.println("\n--- Full Shoppers ---");
        shoppers.forEach(System.out::println);
        System.out.println("\n--- Full Orders ---");
        orders.forEach(System.out::println);

        // Searching: Find products by name
        String searchName = "Laptop";
        System.out.println("\n--- Searching Products by Name: " + searchName + " ---");
        products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(searchName))
                .forEach(System.out::println);

        // Filtering: Products in "Books" category
        System.out.println("\n--- Filtering Products by Category: Books ---");
        products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .forEach(System.out::println);

        // Sorting: Products by price (ascending)
        System.out.println("\n--- Sorting Products by Price (Ascending) ---");
        products.sort(Comparator.comparingDouble(Product::getPrice));
        products.forEach(System.out::println);

        // Searching: Find orders by shopper ID
        String shopperId = "S001";
        System.out.println("\n--- Searching Orders by Shopper ID: " + shopperId + " ---");
        orders.stream()
                .filter(o -> o.getShopper().getId().equals(shopperId))
                .forEach(System.out::println);

        // Filtering: Orders with total > $100
        System.out.println("\n--- Filtering Orders by Total > $100 ---");
        orders.stream()
                .filter(o -> o.getTotal() > 100)
                .forEach(System.out::println);

        // Sorting: Orders by total (descending)
        System.out.println("\n--- Sorting Orders by Total (Descending) ---");
        orders.sort(Comparator.comparingDouble(Order::getTotal).reversed());
        orders.forEach(System.out::println);

        // Equality checks (demonstrating overrides)
        System.out.println("\n--- Equality Checks ---");
        Product prod1 = new PhysicalProduct("P001", "Laptop", 1200.0, "Electronics", 2.5);
        Product prod2 = new PhysicalProduct("P001", "Laptop", 1200.0, "Electronics", 2.5);
        System.out.println("Products equal? " + prod1.equals(prod2));

        Shopper shop1 = new Shopper("S001", "Alice", "alice@email.com");
        Shopper shop2 = new Shopper("S001", "Alice", "alice@email.com");
        System.out.println("Shoppers equal? " + shop1.equals(shop2));

        Order ord1 = new Order("O001", shop1, Arrays.asList(prod1));
        Order ord2 = new Order("O001", shop2, Arrays.asList(prod2));
        System.out.println("Orders equal? " + ord1.equals(ord2));
    }
}