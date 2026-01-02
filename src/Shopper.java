import java.util.Objects;

// Inheritance: Extends User for shopper-specific details
public class Shopper extends User {
    // Encapsulation: Private fields with getters/setters
    private String email;

    public Shopper(String id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Polymorphism: Override abstract method from User
    @Override
    public String getType() {
        return "Shopper";
    }

    // Polymorphism: Override displayDetails from Entity
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Email: " + email);
    }

    // Override toString(): Include shopper details
    @Override
    public String toString() {
        return "Shopper{id='" + getId() + "', name='" + getName() + "', type='" + getType() + "', email='" + email + "'}";
    }

    // Override equals(): Check super equality and email
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Shopper shopper = (Shopper) obj;
        return Objects.equals(email, shopper.email);
    }

    // Override hashCode(): Include email
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email);
    }
}
