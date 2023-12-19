package com.java.pm;

interface PaymentMethod {
    void pay(double amount);
}

class ByCash implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("현금으로 " + amount + "원 결제되었습니다.");
    }
}

class ByCard implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("카드로 " + amount + "원 결제되었습니다.");
    }
}

class Pay<T extends PaymentMethod> {
    private T paymentMethod;

    public Pay(T paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.pay(amount);
    }
}

public class Payment {
    public static void main(String[] args) {
        Pay<ByCash> cashPayment = new Pay<>(new ByCash());
        cashPayment.processPayment(10000); // 현금 결제

        Pay<ByCard> cardPayment = new Pay<>(new ByCard());
        cardPayment.processPayment(20000); // 카드 결제
    }
}
