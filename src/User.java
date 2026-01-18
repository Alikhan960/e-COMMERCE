public class User implements Entity {
    private String id;
    private String username;
    private String role;

    public User(String id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void displayDetails() {
        System.out.println("User [ID=" + id + ", Username=" + username + ", Role=" + role + "]");
    }

    // Геттеры для DBManager
    public String getUsername() { return username; }
    public String getRole() { return role; }
}