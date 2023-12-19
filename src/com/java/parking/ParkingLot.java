package com.java.parking;

import java.util.ArrayList;

public class ParkingLot {
    ArrayList<Car> currentCars; // database
    ArrayList<Car> outCars; // database
    int spaceTotal = 100;
    int space = 0;
    
    int getCurrentSpace() {
        int v = spaceTotal - space;
        return v;
    }

    void carIn(Car car) {
        
    }

    void carOut(Car car) {

    }
}
