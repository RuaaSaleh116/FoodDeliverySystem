package fooddelivery;

import java.util.ArrayList;

public class Order {

    private static int nextOrderNumber = 1001;

    private int orderNumber;
    private String customerName;
    private DeliveryOption deliveryOption;
    private OrderStatus status;
    private ArrayList<OrderLine> lines;

    public Order(String customerName, DeliveryOption deliveryOption) {
        this.orderNumber = nextOrderNumber++;
        this.customerName = customerName;
        this.deliveryOption = deliveryOption;
        this.status = OrderStatus.NEW;
        this.lines = new ArrayList<OrderLine>();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void addItem(MenuItem item) {
        addItem(item, 1);
    }

    public void addItem(MenuItem item, int quantity) {
        if (status == OrderStatus.NEW && item != null && quantity > 0) {
            lines.add(new OrderLine(item, quantity));
        }
    }

    public double getSubtotal() {
        double subtotal = 0;

        for (OrderLine line : lines) {
            subtotal += line.getLineTotal();
        }

        return subtotal;
    }

    public double getTotal() {
        return getSubtotal() + deliveryOption.getFee();
    }

    public double pay(PaymentMethod paymentMethod) {
        if (status == OrderStatus.NEW && paymentMethod != null && !lines.isEmpty()) {
            double amount = paymentMethod.pay(getTotal());
            status = OrderStatus.PAID;
            return amount;
        }

        return 0.0;
    }

    public void deliver() {
        if (status == OrderStatus.PAID) {
            status = OrderStatus.DELIVERED;
        }
    }

    public void cancel() {
        if (status == OrderStatus.NEW) {
            status = OrderStatus.CANCELLED;
        }
    }
}
