import java.util.Scanner;

public class PaymentProcessor {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        strategy.pay(amount);
    }

    public interface PaymentStrategy {
        void pay(double amount);
    }

    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter payment amount:");
        double amount = scanner.nextDouble();

        System.out.println("Choose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                paymentProcessor.setStrategy(new PaymentStrategy() {
                    @Override
                    public void pay(double amount) {
                        System.out.println("Paid $" + amount + " using credit card");
                    }
                });
                break;
            case 2:
                paymentProcessor.setStrategy(new PaymentStrategy() {
                    @Override
                    public void pay(double amount) {
                        System.out.println("Paid $" + amount + " using PayPal");
                    }
                });
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        paymentProcessor.pay(amount);
    }
}