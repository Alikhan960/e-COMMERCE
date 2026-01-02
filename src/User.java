import java.util.Objects;

// Inheritance: Base class for users (e.g., Shopper can inherit from this)
public abstract class User implements Entity {
    // Encapsulation: Private fields with getters/setters
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Polymorphism: Abstract method for subclasses to implement
    public abstract String getType();

    @Override
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Type: " + getType());
    }

    // Override toString(): Custom string representation
    @Override
    public String toString() {
        return "User{id='" + id + "', name='" + name + "', type='" + getType() + "'}";
    }

    // Override equals(): Compare based on ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(id, user.id);
    }

    // Override hashCode(): Based on ID for hashing in collections
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
