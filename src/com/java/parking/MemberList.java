package com.java.parking;

import java.util.Scanner;
import java.util.ArrayList;

public class MemberList {
	ArrayList<Member> mlist = new ArrayList<>();
	
	public void addMember() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("회원 정보를 입력하세요.");
		System.out.print("회원 ID > ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("회원 이름 > ");
		String memName = sc.nextLine();
		
		System.out.print("차량 번호 > ");
		String carNum = sc.nextLine();
		
		mlist.add(new Member(id, memName, carNum));
	}
}
	
