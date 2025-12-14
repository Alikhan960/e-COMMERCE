public class Product {
    // 1. Attributes(Fields)
    private int productId;
    private String name;
    private double price;

    // 2. Constructor to create object
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // 3. Getter Methods to read private attribute
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // 4. Setter Methods to change private attribute
    // onlly the price
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Error: Price cannot be negative.");
        }
    }

    // 5. Other Methods
    public void displayProductDetails() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: $" + price);
    }
}