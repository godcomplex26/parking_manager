package com.java.parking;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int selectUMenu;
		int selectLMenu1;
		int selectLMenu2;
		boolean runUMenu = true;
		boolean runLMenu1 = true;
		boolean runLMenu2 = true;
		ParkingLot parkingLot = new ParkingLot(); // 주차장 객체 생성
		MemberList memberList = new MemberList(); // 멤버 리스트 객체 생성
		
		while(runUMenu) {
			Utils.showUI("메뉴 선택");
			System.out.printf("1.%-15s 2.%-15s 3.%-15s\n", "회원 관리", "입출차 관리", "종료");
			System.out.print("> ");
			selectUMenu = sc.nextInt();
			
			switch(selectUMenu) {
			
			case 1:
				runLMenu1 = true;
				
				while(runLMenu1) {
					Utils.showUI("회원 차량 관리");
					System.out.printf("1.%-15s 2.%-16s 3.%-15s\n4.%-15s 5.%-15s 6.%-15s\n", 
							"회원 차량 등록", "회원 정보 조회", "입차 차량 조회", "회원 등록 정보 수정", "회원 등록 정보 삭제", "이전 메뉴");
					System.out.print("> ");
					selectLMenu1 = sc.nextInt();
					
					switch(selectLMenu1) {
								
					case 1:
						Utils.showUI("회원 차량 등록");
						memberList.addMember();
						System.out.println("회원 등록 완료");
						break;
							
					case 2:
						Utils.showUI("회원 정보 조회");
						sc.nextLine(); // 입력창 초기화
						
						System.out.print("회원 ID 입력 > ");
						int memId = sc.nextInt(); // 회원 ID 입력
						
						Member it = Utils.findMemInst(memberList.mlist, memId);
						it.memberPrint();
						
						break;
						
					case 3:
						Utils.showUI("입차 차량 조회");
						break;	
						
					case 4:
						Utils.showUI("회원 등록 정보 수정");
						break;
							
					case 5:
						Utils.showUI("회원 등록 정보 삭제");
						break;
							
					case 6:
						Utils.showUI("이전 메뉴");
						runLMenu1 = false;
						break;
					}
				}
				break;
						
			case 2:
				runLMenu2 = true;
				
				while(runLMenu2) {
					Utils.showUI("입출차 관리 메뉴 선택");
					System.out.printf("1.%-15s 2.%-15s 3.%-15s\n", "차량 입차", "출차 정산", "이전 메뉴");
					System.out.print("> ");
					selectLMenu2 = sc.nextInt();
					
					switch(selectLMenu2) {
					
					// 차량 입차
					case 1:
						Utils.showUI("차량 입차");
						sc.nextLine(); // 입력창 초기화
						
						System.out.print("입차 차량 번호 입력(0 입력시 랜덤 생성) > ");
						String inCarNum = sc.nextLine(); // 차량 번호 입력
						inCarNum = Utils.fakeCarNumRecognizer(inCarNum);
												
						System.out.print("차량 종류 입력 > ");
						String inCarType = sc.nextLine(); // 차량 타입 자동 생성 입력
						
						parkingLot.carIn(new Car(inCarNum, inCarType)); // carNum, carType 가지는 자동차 입차
						Utils.showCarInfo(inCarNum, "입고");
						Utils.showLotInfo(parkingLot.getCurrentSpace()); // 남은 주차 자리 출력
						break;
							
					// 출차 정산
					case 2:
						Utils.showUI("출차 정산");
						sc.nextLine(); // 입력창 초기화
						
						System.out.print("출차 차량 번호 입력 > ");
						String outCarNum = sc.nextLine(); // 출차 차량 번호 입력
						
						Car it = Utils.findCarInst(parkingLot.currentCars, outCarNum);
                        // Payment pay = new Payment(200, it);
                        it.addAnHour(); // 1시간 추가
                        // it.setTimeOut();
                        NewPayment pay = new NewPayment(it, parkingLot);
                        // System.out.println(pay.payCalc(it));
                        while (!pay.car.isPaid) {
                            // pay = new Payment(200, it);
                            pay.car.setTimeOut();
                            System.out.printf(" %d원을 다시 계산해 주세요.\n", pay.getAmount());
                            System.out.print("> ");
                            int amount = sc.nextInt();
                            pay.car = pay.execPay(amount);
                            // if (pay.payCalc(it) == 0) {
                            //     System.out.printf("감사합니다. 안녕히가세요.\n");
                            //     it.isPaid = true;
                            //     parkingLot.carOut(it);
                            //     break;
                            // }
                            // else if (pay.payCalc(it) < 0) {
                            //     System.out.printf("거스름돈 %d원 입니다. 감사합니다.", -pay.payCalc(it));
                                
                            //     it.isPaid = true;
                            //     parkingLot.carOut(it);
                            //     break;
                            // }
                        }
                        
                        
                        
						
						// 정산 추가 필요		
						
						parkingLot.currentCars.remove(it);
						parkingLot.carOut(it);
						Utils.showCarInfo(outCarNum, "출고");
						Utils.showLotInfo(parkingLot.getCurrentSpace()); // 남은 주차 자리 출력
						
						
						
						
						break;
					
					// 이전 메뉴
					case 3:
						Utils.showUI("이전 메뉴");
						runLMenu2 = false;
						break;
					}
				}
				break;
				
			case 3:
				Utils.showUI("시스템 종료");
				runUMenu = false;
				break;
			}
		}
	}
}
