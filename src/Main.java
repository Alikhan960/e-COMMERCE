public class Main {
    public static void main(String[] args) {
        System.out.println("--- E-COMMERCE PLATFORM DEMO ---");

        // 1. Create Instances
        System.out.println("\n--- 1. Creating Objects ---");


        Product laptop = new Product(101, "Gaming Laptop", 1200.00);
        Product mouse = new Product(102, "Wireless Mouse", 25.50);
        Product keyboard = new Product(103, "Mechanical Keyboard", 120.00);


        Shopper shopperA = new Shopper(1, "Alikhan Yertaiuly", "alikhan@shop.com");
        Shopper shopperB = new Shopper(2, "Arman Satybaldy", "arman@shop.com");


        Order order1 = new Order(1001, shopperA, laptop, 1);
        Order order2 = new Order(1002, shopperB, mouse, 3);
        Order order3 = new Order(1003, shopperA, keyboard, 2);


        // 2. Output them to console
        System.out.println("\n--- 2. Output and Getter/Setter Demo ---");

        shopperA.printWelcomeMessage(); // example method
        laptop.displayProductDetails();

        // Demonstrating setter: change price of mouse and check with getter
        System.out.println("Old Mouse Price: $" + mouse.getPrice());
        mouse.setPrice(19.99); // using setter
        System.out.println("New Mouse Price: $" + mouse.getPrice()); // Используем геттер

        // Demostrate zakaz
        order1.displayOrderSummary();
        order2.displayOrderSummary();

        // Demonstrate change of zakaz: changing number in order3
        System.out.println("\n--- Order 3 BEFORE Change ---");
        order3.displayOrderSummary();

        System.out.println("Changing quantity of keyboard from 2 to 1...");
        order3.setQuantity(1); // using setter that auto recounting totalAmount

        System.out.println("\n--- Order 3 AFTER Change ---");
        order3.displayOrderSummary();


        // 3. Compare multiple objects
        System.out.println("\n--- 3. Object Comparison ---");

        // Compare примитивных attribute
        System.out.println("Is Laptop more expensive than Keyboard?");
        if (laptop.getPrice() > keyboard.getPrice()) {
            System.out.println("Yes, $" + laptop.getPrice() + " > $" + keyboard.getPrice());
        } else {
            System.out.println("No, $" + laptop.getPrice() + " <= $" + keyboard.getPrice());
        }

        System.out.println("\nDoes Order 1 and Order 2 belong to the same shopper?");
        // compare objects Shopper by their id
        if (order1.getCustomer().getShopperId() == order2.getCustomer().getShopperId()) {
            System.out.println("Yes, they have the same Shopper ID: " + order1.getCustomer().getShopperId());
        } else {
            System.out.println("No, Shopper IDs are different: "
                    + order1.getCustomer().getShopperId() + " vs " + order2.getCustomer().getShopperId());
        }

        System.out.println("\nDoes Order 1 and Order 3 belong to the same shopper?");
        // compare objects Shopper (Shopper A)
        if (order1.getCustomer() == order3.getCustomer()) { // Comparing links to the same object ShopperA
            System.out.println("Yes, the orders are linked to the exact same Shopper object.");
        } else {
            System.out.println("No, the orders are linked to different Shopper objects.");
        }
    }
}