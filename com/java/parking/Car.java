package com.java.parking;

import java.time.Instant;

public class Car {
    int carNum;
    String carType;
    boolean isPaid = false;
    boolean isMember = false;
    Instant timeIn = Instant.now();
    Instant timeOut;
}