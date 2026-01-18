public abstract class Product {
    private String id, name, category;
    private double price;
    public Product(String id, String name, double price, String category) {
        this.id = id; this.name = name; this.price = price; this.category = category;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
}