public class Order {
    // 1. Attributes (Fields)
    private int orderId;
    private Shopper customer; // link to object Shopper
    private Product item;     // link to object Product
    private int quantity;
    private double totalAmount;

    // 2. Constructor
    public Order(int orderId, Shopper customer, Product item, int quantity) {
        this.orderId = orderId;
        this.customer = customer;
        this.item = item;
        this.quantity = quantity;
        // calculate sum when making zakaz
        calculateTotal();
    }

    // 3. Getter Methods
    public int getOrderId() {
        return orderId;
    }

    public Shopper getCustomer() {
        return customer;
    }

    public Product getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // 4. Setter Methods
    // setter for changing number of. after changing have to recount
    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
            calculateTotal(); // recount
        } else {
            System.out.println("Error: Quantity must be positive.");
        }
    }

    // 5. Other Methods - calculate sum
    public void calculateTotal() {
        // receive price of product by getter
        this.totalAmount = this.quantity * this.item.getPrice();
    }

    // 6. Output Method
    public void displayOrderSummary() {
        System.out.println("--- Order #" + orderId + " Summary ---");
        System.out.println("Customer: " + customer.getName() + " (" + customer.getEmail() + ")");
        System.out.println("Item: " + item.getName() + " x " + quantity);
        System.out.println("Unit Price: $" + item.getPrice());
        System.out.printf("Total Amount: $%.2f%n", totalAmount);
    }
}
