import java.util.Objects;

// Inheritance: Extends Product for digital items
public class DigitalProduct extends Product {
    // Encapsulation: Private field with getters/setters
    private String format;

    public DigitalProduct(String id, String name, double price, String category, String format) {
        super(id, name, price, category);
        this.format = format;
    }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }

    // Polymorphism: Override abstract method
    @Override
    public String getProductType() {
        return "Digital";
    }

    // Override toString(): Include format
    @Override
    public String toString() {
        return super.toString().replace("}", "") + ", format='" + format + "'}";
    }

    // Override equals(): Check super and format
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        DigitalProduct that = (DigitalProduct) obj;
        return Objects.equals(format, that.format);
    }

    // Override hashCode(): Include format
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), format);
    }
}
