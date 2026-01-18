public class Shopper {
    private int id;
    private String name;
    private String email;

    // a constructor for creating a new buyer (without an ID, since the database will assign it itself)
    public Shopper(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Constructor for getting data from the database (already with ID)
    public Shopper(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Геттеры
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Shopper{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}
