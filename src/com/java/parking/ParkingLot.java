package com.java.parking;

import java.util.ArrayList;

/**
 * InnerParkingLot
 */
interface InnerParkingLot {
    void carIn(Car car);
    void carOut(Car car);
    int getCurrentSpace();
}

public class ParkingLot implements InnerParkingLot {
    ArrayList<Car> currentCars;
    ArrayList<Car> outCars;
    int spaceTotal = 100;
    int space = 0;
    
    @Override
    public int getCurrentSpace() {
        int spaceLeft = spaceTotal - space;
        return spaceLeft;
    }

    @Override
    public void carIn(Car car) {
        
    }

    @Override
    public void carOut(Car car) {
        
    }
}
