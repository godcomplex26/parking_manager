package com.java.parking;

abstract class AbstractMember {
    int memId;
    String memName;
    String carNum;

    public AbstractMember(int memId, String memName, String carNum) {
        this.memId = memId;
        this.memName = memName;
        this.carNum = carNum;
    }
}

interface InnerMember {
    int getId();
    String getCarNum();
    String getName();
    void setName(String name);
}

public class Member extends AbstractMember implements InnerMember {
    int memId;
    String memName;
    String carNum;

    public Member(int memId, String memName, String carNum) {
        super(memId, memName, carNum);
    }
    
    @Override
    public int getId() {
        return this.memId;
    }

    @Override
    public String getCarNum() {
        return this.carNum;
    }

    @Override
    public String getName() {
        return this.memName;
    }

    @Override
    public void setName(String memName) {
        this.memName = memName;
    }
    
    public void memberPrint() {
    	System.out.printf("회원 번호: %-8d 회원 이름: %-8s 차 번호: %-8s\n", memId, memName, carNum);
    }
}