import java.util.List;
import java.util.Objects;

// Data abstraction: Class encapsulates order logic
public class Order implements Entity {
    // Encapsulation: Private fields with getters/setters
    private String id;
    private Shopper shopper;
    private List<Product> products;
    private double total;

    public Order(String id, Shopper shopper, List<Product> products) {
        this.id = id;
        this.shopper = shopper;
        this.products = products;
        this.total = products.stream().mapToDouble(Product::getPrice).sum();
    }

    public String getId() { return id; }
    public Shopper getShopper() { return shopper; }
    public List<Product> getProducts() { return products; }
    public double getTotal() { return total; }

    // Polymorphism: Override displayDetails from Entity
    @Override
    public void displayDetails() {
        System.out.println("Order ID: " + id + ", Shopper: " + shopper.getName() + ", Total: $" + total);
    }

    // Override toString(): Readable string
    @Override
    public String toString() {
        return "Order{id='" + id + "', shopper='" + shopper.getName() + "', products=" + products.size() + ", total=$" + total + "}";
    }

    // Override equals(): Compare based on ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return Objects.equals(id, order.id);
    }

    // Override hashCode(): Based on ID
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
