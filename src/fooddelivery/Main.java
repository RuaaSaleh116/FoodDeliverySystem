package fooddelivery;

public class Main {
    public static void main(String[] args) {

        // Test 1: Express delivery and card payment
        System.out.println("ORDER 1");

        Meal burger = new Meal("Burger", 8.0, 1);
        Drink juice = new Drink("Juice", 3.0, true);

        Order order1 = new Order("Sara", new ExpressDelivery());

        order1.addItem(burger, 2);
        order1.addItem(juice);

        System.out.println("Order Number: " + order1.getOrderNumber());
        System.out.println("Customer: " + order1.getCustomerName());
        System.out.println("Subtotal: $" + order1.getSubtotal());
        System.out.println("Total: $" + order1.getTotal());

        double paid1 = order1.pay(new CardPayment());

        System.out.printf("Paid: $%.2f%n", paid1);
        System.out.println("Status: " + order1.getStatus());

        // Try adding an item after payment
        order1.addItem(juice, 3);
        System.out.println("Total after adding item: $" + order1.getTotal());

        // Try cancelling a paid order
        order1.cancel();
        System.out.println("Status after cancel attempt: " + order1.getStatus());

        order1.deliver();
        System.out.println("Status after delivery: " + order1.getStatus());


        // Test 2: Standard delivery and cash payment
        System.out.println("\nORDER 2");

        Meal pizza = new Meal("Pizza", 12.0, 2);
        Drink coffee = new Drink("Coffee", 4.0, false);

        Order order2 = new Order("Ahmad", new StandardDelivery());

        order2.addItem(pizza, 3);
        order2.addItem(coffee, 2);

        System.out.println("Order Number: " + order2.getOrderNumber());
        System.out.println("Customer: " + order2.getCustomerName());
        System.out.println("Subtotal: $" + order2.getSubtotal());
        System.out.println("Total: $" + order2.getTotal());

        double paid2 = order2.pay(new CashPayment());

        System.out.printf("Paid: $%.2f%n", paid2);
        System.out.println("Status: " + order2.getStatus());


        // Test 3: Delivery before payment
        System.out.println("\nORDER 3");

        Order order3 = new Order("Lina", new StandardDelivery());

        order3.addItem(new Drink("Water", 2.0, false));

        System.out.println("Order Number: " + order3.getOrderNumber());
        System.out.println("Status before delivery: " + order3.getStatus());

        order3.deliver();

        System.out.println("Status after delivery attempt: " + order3.getStatus());


        // Test 4: Cancel a new order
        System.out.println("\nORDER 4");

        Order order4 = new Order("Omar", new ExpressDelivery());

        order4.addItem(new Meal("Sandwich", 6.0, 0));

        System.out.println("Order Number: " + order4.getOrderNumber());
        System.out.println("Status before cancel: " + order4.getStatus());

        order4.cancel();

        System.out.println("Status after cancel: " + order4.getStatus());

        // Try adding an item after cancellation
        order4.addItem(new Drink("Tea", 2.0, false));

        System.out.println("Subtotal after adding attempt: $" + order4.getSubtotal());

    }
}
