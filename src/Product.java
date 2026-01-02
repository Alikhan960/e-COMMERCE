import java.util.Objects;

// Inheritance: Abstract base class for products (subclasses like PhysicalProduct inherit from this)
// Data abstraction: Abstract class hides common product logic
public abstract class Product implements Entity {
    // Encapsulation: Private fields with getters/setters
    private String id;
    private String name;
    private double price;
    private String category;

    public Product(String id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    // Polymorphism: Abstract method for subclasses to define specifics
    public abstract String getProductType();

    // Polymorphism: Override displayDetails from Entity
    @Override
    public void displayDetails() {
        System.out.println("Product: " + name + " ($" + price + ", Category: " + category + ", Type: " + getProductType() + ")");
    }

    // Override toString(): Readable string
    @Override
    public String toString() {
        return "Product{id='" + id + "', name='" + name + "', price=" + price + ", category='" + category + "', type='" + getProductType() + "'}";
    }

    // Override equals(): Compare based on ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(id, product.id);
    }

    // Override hashCode(): Based on ID
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}