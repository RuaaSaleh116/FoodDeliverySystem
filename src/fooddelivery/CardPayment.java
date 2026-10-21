package fooddelivery;

public class CardPayment implements PaymentMethod {

    @Override
    public double pay(double amount) {
        return amount * 1.02;
    }
}
