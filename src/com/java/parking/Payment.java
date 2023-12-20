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
    int payCalc(Car car);
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
        this.discountSum = car.paidAmount;
    }

    public int toMin() {
        Duration duration = Duration.between(this.car.timeIn, this.car.timeOut);
        return (int)duration.toMinutes();
    }

    public int payCalc(Car car) {
        setCar(car);
        // 분 단위 절삭
        int duration = (toMin()/10) * 10;
        
        double amount = (duration*pricePerTenMin)*(1-discountProduct) - discountSum;
        return (int)amount;
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
}
