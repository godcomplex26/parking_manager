package com.java.parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MemberList {
	MemberArray mlist = new MemberArray();
	String memId;
	String memName;
	String carNum;	

	public void addMember() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("회원 정보를 입력하세요.");
		System.out.print("회원 ID > ");
		memId = sc.nextLine();
		
		System.out.print("회원 이름 > ");
		memName = sc.nextLine();
		
		System.out.print("차량 번호 > ");
		carNum = sc.nextLine();
		
		mlist.add(new Member(memId, memName, carNum));
	}

    // public boolean memCheck(String memId) {
        
    // }
    public static void main(String[] args) {
    }
}
	
