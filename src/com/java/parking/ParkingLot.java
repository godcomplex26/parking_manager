package com.java.parking;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


interface InnerParkingLot
{
	void carIn();
	void carOut(Car car);
	int getCurrentSpace();
    String errorType(int errorCode);
    void setPricePerTenMin(int price);
    void showAllOutCarPayments();
}

public class ParkingLot implements InnerParkingLot{
    ArrayList<Car> currentCars = new ArrayList<>(); // database
    CarArray outCars = new CarArray(); // database
    int spaceTotal = 70; // 전체 주차가능 수
    int space = 0; // 현재 주차중인 수
    int pricePerTenMin = 200;

    
    @Override
    public int getCurrentSpace() { // 현재 주차가능 공간
        int spaceLeft = spaceTotal - space;
        return spaceLeft;
    }
    
    @Override
    public void carIn() {
        if (this.space < this.spaceTotal) {
        	Scanner sc = new Scanner(System.in);
			
			System.out.print("입차 차량 번호 입력(0 입력시 랜덤 생성) > ");
			String inCarNum = sc.nextLine(); // 차량 번호 입력
			inCarNum = Utils.fakeCarNumRecognizer(inCarNum);
									
			System.out.print("차량 종류 입력 > ");
			String inCarType = sc.nextLine(); // 차량 타입 자동 생성 입력
			
			currentCars.add(new Car(inCarNum, inCarType)); // carNum, carType 가지는 자동차 입차
			Utils.showCarInfo(inCarNum, "입고");
			space++;
			Utils.showLotInfo(getCurrentSpace()); // 남은 주차 자리 출력
        }
        else {
            System.out.println(errorType(1));
        }
        
    }

    public void carIn(Car car) {
        if (this.space < this.spaceTotal) {
            currentCars.add(car);
            space++;
        }
        else {
            System.out.println(errorType(1));
        }
    }
    
    @Override
    public void carOut(Car car) {
    	if (car.isPaid == true) {
    		currentCars.remove(car);
            outCars.add(car); // 차량 출고
            space--;
            }
    	else {
            System.out.println(errorType(3));
    	}
    }


    @Override
    public String errorType(int errorCode) { // 에러 정의
        switch (errorCode) {
            case 1:
                return "주차 공간이 가득 찼습니다.";
            case 2:
            	return "주차된 차량이 없습니다.";
            case 3:
                return "정산이 완료되지 않았습니다.";
            default:
                return "오류없음";
        }
    }

    @Override
    public void setPricePerTenMin(int price) {
        this.pricePerTenMin = price;
    }

    @Override
    public void showAllOutCarPayments() {
        if (outCars.size() == 0) {
            System.out.println("결제된 차량이 없습니다.");
        }
        else {
                for (Car car : outCars) {
                System.out.printf("차량번호: %s 결제금액: %d \n", car.carNum, car.totalPay);
            }
        }
    }

    public void setTest() {
        Utils.makeCars(50, this);
        Random r = new Random();
        if (this.currentCars.size() == 0) {
            System.out.println("사이즈가 0입니다.");
        }
        else {
            // System.out.println(this.currentCars.size());
            // System.out.println(this.currentCars.get(0).timeIn);
            // System.out.println(this.currentCars.get(0).timeOut);
            // for (int i = 0; i < this.currentCars.size(); i++) {
            //     this.currentCars.get(i).addHours(r.nextInt(2,5));
            //     NewPayment pay = new NewPayment(this.currentCars.get(i), this);
            //     pay.execPay(200000);
            // }
            
            for (Car car : this.currentCars) {
                car.addHours(r.nextInt(1, 5));
                // NewPayment pay = new NewPayment(car, this);
                // car = pay.execPay(pay.getAmount());
                // this.carOut(car);
            }

            while(this.currentCars.size() != 0) {
                NewPayment pay = new NewPayment(this.currentCars.get(0), this);
                pay.execPay(pay.getAmount());
            }

            // Iterator<Car> iterator = this.currentCars.iterator();
            // while(iterator.hasNext()) {
            //     Car car = iterator.next();             
            //     NewPayment pay = new NewPayment(car, this);
            //     if (pay.execPay(pay.getAmount()).isPaid) {
            //         iterator.remove();
            //     }
            // }
            Utils.makeCars(60, this);
        }
    }
}
