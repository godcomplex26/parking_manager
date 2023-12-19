package com.java.parking;

import java.time.Instant;

interface InnerCar {
    void setMemNum(int memNum);
    void setTimeOut();
}

public class Car implements InnerCar {
    String carNum;
    String carType;
    boolean isPaid = false;
    int memNum = 0;
    Instant timeIn = Instant.now();
    Instant timeOut = null;

    public Car(String carNum, String carType) {
        this.carNum = carNum;
        this.carType = carType;
    }

    @Override
    public void setMemNum(int memNum) {
        this.memNum = memNum;
    }

    @Override
    public void setTimeOut() {
        this.timeOut = Instant.now();
    }
}