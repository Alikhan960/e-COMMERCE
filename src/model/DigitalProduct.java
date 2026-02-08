package model;

public class DigitalProduct extends Product {
    private String format;

    public DigitalProduct(String id, String name, double price, String category, String format) {
        super(id, name, price, category);
        this.format = format;
    }

    // Геттер нужен, чтобы потом выводить формат
    public String getFormat() { return format; }
}
