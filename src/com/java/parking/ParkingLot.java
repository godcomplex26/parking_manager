package com.java.parking;

import java.util.ArrayList;
import java.util.List;


interface InnerParkingLot
{
	void carIn(Car car);
	void carOut(Car car);
    boolean isAvailable();
	int getCurrentSpace();
    String errorType(int errorCode);
}

public class ParkingLot implements InnerParkingLot{
    ArrayList<Car> currentCars = new ArrayList(); // database
    ArrayList<Car> outCars = new ArrayList(); // database
    int spaceTotal = 100; // 전체 주차가능 수
    int space = 0; // 현재 주차중인 수
    
    @Override
    public int getCurrentSpace() { // 현재 주차가능 공간
        int spaceLeft = spaceTotal - space;
        return spaceLeft;
    }
    
    @Override
    public void carIn(Car car) {
        currentCars.add(car); // 차량 입고
        if (!isAvailable()) {
            System.out.println(errorType(1));
        }
        else {
            space++;
        }
    }
    
    @Override
    public void carOut(Car car) {
    	outCars.add(car); // 차량 출고
    	if (!isAvailable()) {
    		System.out.println(errorType(2));
    	}
    	else {
    		space--;
    	}
    }

    @Override
    public String errorType(int errorCode) { // 에러 정의
        switch (errorCode) {
            case 1:
                return "주차 공간이 가득 찼습니다.";
            case 2:
            	return "주차된 차량이 없습니다.";
            default:
                return "오류없음";
        }
    }

    @Override
    public boolean isAvailable() { // 주차 가능유무
        if(space <= spaceTotal)
        {
        	return true;
        }
        else if(space < 0)
        {
        	return false;
        }
        else
        {
        	return false;
        }
    }
}
