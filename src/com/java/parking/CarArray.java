package com.java.parking;

import java.util.ArrayList;

public class CarArray extends ArrayList<Car> {

    public Car findCar(String carNum) {
        for (Car car : this) {
            if (car.carNum.equals(carNum)) {
                return car;
            }
        }
        return null;
    }

    public void showAll() {
        System.out.printf("%-15s %-15s %-15s\n", "차량번호", "차량번호", "이름");
        for (Member member : this) {
            System.out.printf("%-15s %-15s %-15s\n", member.memId, member.carNum, member.memName);
        }
    }

    public void showAll(MemberArray mlist) {
        System.out.printf("%-15s %-15s %-15s\n", "아이디", "차량번호", "이름");
        for (Member member : mlist) {
            System.out.printf("%-15s %-15s %-15s\n", member.memId, member.carNum, member.memName);
        }
    }

    public void showMember(String numOrName) {
        Member member = findMember(numOrName);
        if (member == null) {
            System.out.println("검색 결과 없음.");
        }
        else {
            System.out.printf("%-15s %-15s %-15s\n", "아이디", "차량번호", "이름");
            System.out.printf("%-15s %-15s %-15s\n", member.memId, member.carNum, member.memName);
        }
    }
}
