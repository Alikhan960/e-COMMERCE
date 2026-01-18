public class Order implements Entity {
    private String id;
    private String shopperId;
    private double totalAmount;

    public Order(String id, String shopperId, double totalAmount) {
        this.id = id;
        this.shopperId = shopperId;
        this.totalAmount = totalAmount;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void displayDetails() {
        System.out.println("Order [ID=" + id + ", ShopperID=" + shopperId + ", Total=$" + totalAmount + "]");
    }

    // Геттеры для DBManager
    public String getShopperId() { return shopperId; }
    public double getTotalAmount() { return totalAmount; }
}
