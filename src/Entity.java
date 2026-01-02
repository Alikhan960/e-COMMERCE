// Data abstraction: Interface to define common methods for entities, hiding implementation details
public interface Entity {
    String getId();
    void displayDetails();  // Polymorphism: Method to be overridden in implementing classes
}
