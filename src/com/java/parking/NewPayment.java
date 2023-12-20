package com.java.parking;

import java.time.Duration;
import java.time.Instant;

public class NewPayment {
    Car car;
    ParkingLot parkingLot;

    public NewPayment(Car car, ParkingLot parkingLot) {
        this.car = car;
        this.parkingLot = parkingLot;
    }

    int getAmount() {
        Duration duration = Duration.between(this.car.timeIn, this.car.timeOut);
        return (int)(duration.toMinutes()*parkingLot.pricePerTenMin - car.paidAmount);
    }

    int getChanges(int amount, int receive) {
        return receive - amount;
    }

    Car execPay(int receive) {
        if (getAmount() == receive) {
            car.setTimeOut();
            car.setPaidAmount(receive);
            car.isPaid = true;
            System.out.printf("안녕히 가세요. 감사합니다.");
            return this.car;
        }
        else if (getAmount() < receive) {
            car.setTimeOut();
            car.setPaidAmount(receive);
            car.isPaid = true;
            // int changes = receive - getAmount();
            System.out.printf("거스름돈은 %d 입니다. 감사합니다.", -getAmount());
            return this.car;
        }
        else {
            car.setTimeOut();
            car.setPaidAmount(receive);
            System.out.printf("다시 정산을 해주시기 바랍니다. 감사합니다.");
            return this.car;
        }
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("1", "1");
        car.addAnHour();
        NewPayment pay = new NewPayment(car, parkingLot);
        car = pay.execPay(1000);
        System.out.println(car.isPaid);
        System.out.println(car.paidAmount);
    }
}
