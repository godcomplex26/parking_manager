package com.java.parking;

import java.time.Duration;

public class NewPayment {
    Car car;
    ParkingLot parkingLot;
    double discount = 0;

    public NewPayment(Car car, ParkingLot parkingLot) {
        this.car = car;
        this.parkingLot = parkingLot;
    }

    public void setDiscount(double d) {
        this.discount = d;
    }

    int getAmount() {
        if (car.timeOut == null) {
            car.setTimeOut();
        }
        Duration duration = Duration.between(this.car.timeIn, this.car.timeOut);
        return (int)(duration.toMinutes()*parkingLot.pricePerTenMin*(1-discount) - car.paidAmount);
    }

    int getChanges(int amount, int receive) {
        return receive - amount;
    }

    Car execPay(int receive) {
        if (car.timeOut == null) {
            car.setTimeOut();
        }
        if (getAmount() == receive) {
            car.setTimeOut();
            car.setTotalPay(getAmount());
            System.out.println("----------" + car.timeOut);
            car.setPaidAmount(receive);
            car.isPaid = true;
            System.out.printf("안녕히 가세요. 감사합니다.\n");
            parkingLot.carOut(car);
            return this.car;
        }
        else if (getAmount() < receive) {
            car.setTimeOut();
            car.setTotalPay(getAmount());
            System.out.println("----------" + car.timeOut);
            car.setPaidAmount(receive);
            car.isPaid = true;
            // int changes = receive - getAmount();
            System.out.printf("거스름돈은 %d 입니다. 감사합니다.\n", -getAmount());
            parkingLot.carOut(car);
            return this.car;
        }
        else {
            car.setTimeOut();
            car.setPaidAmount(receive);
            System.out.printf("다시 정산을 해주시기 바랍니다. 감사합니다.\n");
            return this.car;
        }
    }
}
