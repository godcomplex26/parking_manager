package com.java.parking;

import java.time.Instant;

abstract class AbstractCar {
    String carNum;
    String carType;
    int memNum;
    boolean isPaid;
    int paidAmount;
    Instant timeIn;
    Instant timeOut;
    public AbstractCar(String carNum, String carType) {
        this.carNum = carNum;
        this.carType = carType;
    }
}

interface InnerCar {
    void setMemNum(int memNum);
    void setTimeOut();
    String getCarNum();
    String getCarType();
    int getPaidAmount();
}

public class Car extends AbstractCar implements InnerCar {
    String carNum;
    String carType;
    boolean isPaid = false;
    int memNum = 0;
    int paidAmount = 0;
    public Instant timeIn = Instant.now();
    public Instant timeOut = null;

    public Car(String carNum, String carType) {
        super(carNum, carType);
    }

    @Override
    public String getCarNum() {
        return this.carNum;
    }

    @Override
    public String getCarType() {
        return this.carType;
    }

    @Override
    public void setMemNum(int memNum) {
        this.memNum = memNum;
    }

    @Override
    public void setTimeOut() {
        this.timeOut = Instant.now();
    }

    @Override
    public int getPaidAmount() {
        return this.paidAmount;
    }
}