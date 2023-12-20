package com.java.parking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Utils {
	// UI 출력
    public static void showUI(String str1) {
    	// ━┃┏ ┓┛┗ 
    	System.out.print("");
    	
    	for(int i = 0; i < str1.length()+6; i++) {
    		System.out.print("━");
    	}
    	System.out.println("");
    	System.out.println("◎ " + str1 + " ◎");
    	System.out.print("");
    	
    	for(int i = 0; i < str1.length()+6; i++) {
    		System.out.print("━");
    	}
    	System.out.println();
    }
    
    // 입출차 알림
    public static void showCarInfo(String carNum, String status) {
    	System.out.printf("%s 차량이 %s 되었습니다.\n", carNum, status);
    }
    
    // 남은 자리 알림
    public static void showLotInfo(int leftSpace) {
    	System.out.printf("주차 자리 %d개 남았습니다.\n", leftSpace);
    }
    
    // 랜덤 차량 번호 생성
    public static String fakeCarNumRecognizer(String carNum) {
        if (carNum.equals("0")) {
            Random random = new Random();
            carNum = String.valueOf(random.nextInt(10, 997)) + "허" + String.valueOf(random.nextInt(1000, 9999));
            return carNum;
        }
        return carNum;
    }
    
    // 특정 carNum을 가진 Car 객체를 list에서 Car 타입으로 호출
    public static Car findCarInst(ArrayList list, String carNum) {
    	Car it = null;
		for(Iterator<Car> itr = list.iterator(); itr.hasNext();) {
			it = itr.next();
			if(carNum.equals(it.carNum)) {
				return it;
			}
		} return it;
	}
    
    // 특정 ID를 가진 member 객체를 list에서 member 타입으로 호출
    public static Member findMemInst(ArrayList list, int memId) {
    	Member it = null;
		for(Iterator<Member> itr = list.iterator(); itr.hasNext();) {
			it = itr.next();
			if(memId == it.memId) {
				return it;
			}
		} return it;
	}
}
