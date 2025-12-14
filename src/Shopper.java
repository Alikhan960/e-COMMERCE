public class Shopper {
    // 1. Attributes (Fields)
    private int shopperId;
    private String name;
    private String email;

    // 2. Constructor
    public Shopper(int shopperId, String name, String email) {
        this.shopperId = shopperId;
        this.name = name;
        this.email = email;
    }

    // 3. Getter Methods
    public int getShopperId() {
        return shopperId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // 4. Setter Methods
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 5. Other Methods
    public void printWelcomeMessage() {
        System.out.println("Welcome back, " + name + " (ID: " + shopperId + ")!");
    }
}
