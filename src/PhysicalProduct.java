import java.util.Objects;

// Inheritance: Extends Product for physical items
public class PhysicalProduct extends Product {
    // Encapsulation: Private field with getters/setters
    private double weight;

    public PhysicalProduct(String id, String name, double price, String category, double weight) {
        super(id, name, price, category);
        this.weight = weight;
    }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    // Polymorphism: Override abstract method
    @Override
    public String getProductType() {
        return "Physical";
    }

    // Override toString(): Include weight
    @Override
    public String toString() {
        return super.toString().replace("}", "") + ", weight=" + weight + "kg}";
    }

    // Override equals(): Check super and weight
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        PhysicalProduct that = (PhysicalProduct) obj;
        return Double.compare(that.weight, weight) == 0;
    }

    // Override hashCode(): Include weight
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }
}