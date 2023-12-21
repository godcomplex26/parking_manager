package com.java.parking;

import java.time.Instant;

public class Member{
    String memId;
    String memName;
    String carNum;
    Instant issueDate = Instant.now();

    public Member(String memId, String memName, String carNum) {
        this.memId = memId;
        this.memName = memName;
        this.carNum = carNum;
    }
    
    public String getId() {
        return this.memId;
    }

    public String getCarNum() {
        return this.carNum;
    }

    public String getName() {
        return this.memName;
    }

    public void setId(String memId) {
        this.memId = memId;
    }

    public void setName(String memName) {
    	this.memName = memName;
    }
    
    public void setNum(String carNum) {
        this.carNum = carNum;
    }
    
    public void memberPrint() {
    	System.out.printf("회원 번호: %-8s | 회원 이름: %-8s | 차량 번호: %-8s\n", memId, memName, carNum);
    }
}