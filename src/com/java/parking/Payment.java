package com.java.parking;

import java.time.Duration;

abstract class AbstractPayment {
    Car car;
    int pricePerTenMin;
    int paymentMethod;
    int discountSum;
    double discountProduct;
    public AbstractPayment(int pricePerTenMin, Car car) {
        this.pricePerTenMin = pricePerTenMin;
        this.car = car;
    }
}

interface InnerPayment {
    int toMin();
    double payCalc(Car car);
    void setDiscountSum(int paidAmount);
    void setDiscountProduct(double percent);
    void setPaymentMethod(int method);
    void setCar(Car car);
}

public class Payment extends AbstractPayment implements InnerPayment {
    Car car;
    int pricePerTenMin;
    int paymentMethod = 1;
    int discountSum = 0;
    double discountProduct = 0;
    
    public Payment(int pricePerTenMin, Car car) {
        super(pricePerTenMin, car);
        this.pricePerTenMin = pricePerTenMin;
        this.car = car;
        this.discountSum = car.paidAmount;
    }

    public int toMin() {
        Duration duration = Duration.between(this.car.timeIn, this.car.timeOut);
        return (int)duration.toMinutes();
    }

    public double payCalc(Car car) {
        setCar(car);
        // 분 단위 절삭
        // int duration = (toMin()/10) * 10;
        Duration duration = Duration.between(this.car.timeIn, this.car.timeOut);
        
        return (int)(duration.toMinutes()*pricePerTenMin*(1-discountProduct) - discountSum);
    }

    public void setDiscountSum(int paidAmount) {
        this.discountSum = paidAmount;
    }

    public void setDiscountProduct(double percent) {
        if (percent > 1 || percent < 0) {
            System.out.println("올바른 값을 입력하세요.");
        }
        else {
            this.discountProduct = percent;
        }
    }

    public void setPaymentMethod(int method) {
        if (method != 1 || method != 2) {
            System.out.println("올바른 값을 입력하세요.");
        }
        else {
            this.paymentMethod = method;
        }
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public static void main(String[] args) {
        Car car = new Car("12나1111", "승용차");
        car.addAnHour();
        car.setTimeOut();
        Payment pay = new Payment(200, car);
        pay.car.addAnHour();
        pay.car.setTimeOut();
        // Instant now = Instant.now();
        // Instant later = Instant.now().plus(1, ChronoUnit.HOURS);
        // Duration duration = Duration.between(now, later);
        // System.out.println(duration.toMinutes());
        // System.out.println(pay.toMin());
        System.out.println(pay.car.timeIn);
        System.out.println(pay.car.timeOut);
        System.out.println(pay.payCalc(pay.car));
    }
}
