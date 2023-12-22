package com.java.parking;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int selectUMenu; // 전체 메뉴
		int selectLMenu1; // 입출차 관리
		int selectLMenu2; // 회원 관리
		int selectLMenu3; // 주차장 관리
		int selectLMenu2_1; // 회원 정보 조회(전체 or 특정)
		int selectLMenu2_2; // 회원 정보 수정 및 삭제
		
		boolean runUMenu = true; // 전체 메뉴
		boolean runLMenu1 = true; // 입출차 관리
		boolean runLMenu2 = true; // 회원 관리
		boolean runLMenu3 = true; // 주차장 관리
		boolean runLMenu2_1 = true; // 회원 정보 조회(전체 or 특정)
		boolean runLMenu2_2 = true; // 회원 정보 수정 및 삭제
		
		ParkingLot parkingLot = new ParkingLot(); // 주차장 객체 생성
		parkingLot.setTest(); // 테스트용 자료 추가
		MemberList memberList = new MemberList(); // 멤버 리스트 객체 생성

		while(runUMenu) {
			Utils.showUI("메뉴 선택");
            List<String> mainMenu = Arrays.asList("입출차 관리", "회원 관리", "주차장 관리", "종료");
            selectUMenu = Utils.showMenu(mainMenu, sc);
						
			switch(selectUMenu) {
						
			case 1:
				runLMenu1 = true;
				
				while(runLMenu1) {
					Utils.showUI("입출차 관리 메뉴 선택");
					List<String> subMenu1 = Arrays.asList("차량 입차", "출차 정산", "입차 차량 조회", "이전 메뉴");
					selectLMenu1 = Utils.showMenu(subMenu1, sc);
					
					switch(selectLMenu1) {
					
					// 차량 입차
					case 1:
						Utils.showUI("차량 입차");
						
						parkingLot.carIn();
						break;			
						
					// 출차 정산
					case 2:
						Utils.showUI("출차 정산");
						
						if(parkingLot.getSpace() > 0 ) { // 출차 차량 존재 여부 확인
							    
							System.out.print("출차 차량 번호 입력 > ");
							String outCarNum = sc.nextLine(); // 출차 차량 번호 입력
							    
							Car it = Utils.findCarInst(parkingLot.currentCars, outCarNum);
							if (it == null) {
                                break;
                            }
							// 1시간 추가
							it.addAnHour();
							
							NewPayment pay = new NewPayment(it, parkingLot);
                            if (memberList.mlist.isMember(it.carNum)) {
                                pay.setDiscount(0.2);
                            }
                            else {
                                pay.setDiscount(0);
                            }
                            // pay.setDiscount(0.2);
							while (!pay.car.isPaid) {
								pay.car.setTimeOut();
								System.out.printf(" %d원을 계산해 주세요.\n", pay.getAmount());
								System.out.print("> ");
								int amount = sc.nextInt();
								pay.car = pay.execPay(amount);
							}		
							
							// parkingLot.currentCars.remove(it);
							// parkingLot.carOut(it);
							Utils.showCarInfo(outCarNum, "출고");
							Utils.showLotInfo(parkingLot.getCurrentSpace()); // 남은 주차 자리 출력
							break;
						}
						else {
							System.out.println(parkingLot.errorType(2));
							break;
						}					
						
					// 입차 차량 조회
					case 3:
						Utils.showUI("입차 차량 조회");

						System.out.print("조회할 차량 번호 입력 > ");
						String carNum = sc.nextLine(); // 회원 ID 입력
						
						Car it2 = Utils.findCarInst(parkingLot.currentCars, carNum);
                        if (it2 == null) {
                            break;
                        }
						it2.carPrint();
						break;
					
					// 이전 메뉴
					case 4:
						// Utils.showUI("이전 메뉴");
						runLMenu1 = false;
						break;
					}
				}
				break;
				
			case 2:
				runLMenu2 = true;
				
				while(runLMenu2) {
					Utils.showUI("회원 관리 메뉴 선택");
					List<String> subMenu2 = Arrays.asList("회원 차량 등록", "회원 정보 조회", "회원 정보 수정 및 삭제", "이전 메뉴");
					selectLMenu2 = Utils.showMenu(subMenu2, sc);
					
					switch(selectLMenu2) {
					
					// 회원 차량 등록
					case 1:
						Utils.showUI("회원 차량 등록");
						memberList.addMember();
						System.out.println("회원 등록 완료");
						break;
					
					// 회원 정보 조회
					case 2:
						runLMenu2_1 = true;
						
						if(memberList.mlist.size() != 0) {
							while(runLMenu2_1) {
								Utils.showUI("회원 정보 조회");
								List<String> subMenu2_1 = Arrays.asList("전체 회원 조회", "특정 회원 조회");
								selectLMenu2_1 = Utils.showMenu(subMenu2_1, sc);
						
								switch(selectLMenu2_1) {
								
								// 회원 전체 조회
								case 1:
									Utils.showUI("전체 회원 조회");
									for(Member m : memberList.mlist.sortMemberById()) {
										m.memberPrint();
									}
									break;
								
								// 특정 회원 조회
								case 2:
									Utils.showUI("특정 회원 조회");
									System.out.print("조회할 회 원 정보 입력(ID, 이름, 차량 번호 中 1) > ");
									String whatFind = sc.nextLine(); // 정보 입력
									memberList.mlist.showMember(whatFind);								
															
									break;
								} break;
							} break;
						}
						else {
							System.out.println("조회할 정보가 없습니다.");
							break;
						}
					
					// 회원 정보 수정 및 삭제
					case 3:
						runLMenu2_2 = true;
						
						if(memberList.mlist.size() != 0) {
							while(runLMenu2_2) {
								Utils.showUI("회원 정보 수정 및 삭제");
								List<String> subMenu2_2 = Arrays.asList("회원 정보 수정", "회원 정보 삭제");
								selectLMenu2_2 = Utils.showMenu(subMenu2_2, sc);
								
								switch(selectLMenu2_2) {
								
								// 회원 정보 수정
								case 1:
									Utils.showUI("회원 등록 정보 수정");
									
									System.out.print("수정할 회원 ID 입력 > ");
									String memId = sc.nextLine(); // 회원 ID 입력
									
									Member it = Utils.findMemInst(memberList.mlist, memId);
                                    if (it == null) {
                                        break;
                                    }
									
									System.out.println("회원 정보를 입력하세요.");
									System.out.print("회원 ID > ");
									int id = sc.nextInt();
									sc.nextLine();
									
									System.out.print("회원 이름 > ");
									String newMemName = sc.nextLine();
									it.setName(newMemName);
									
									System.out.print("차량 번호 > ");
									String newMemCarNum = sc.nextLine();
									it.setNum(newMemCarNum);
									
									System.out.println("회원 정보 수정 완료");
									// it.memberPrint();
									break;
							
						
								// 회원 정보 삭제	
								case 2:
									Utils.showUI("회원 등록 정보 삭제");
									
									System.out.print("삭제할 회원 ID 입력 > ");
									memId = sc.nextLine(); // 회원 ID 입력
									
									it = Utils.findMemInst(memberList.mlist, memId);
                                    if (it == null) {
                                        break;
                                    }
									memberList.mlist.remove(it);
									System.out.println("회원 정보 삭제 완료");					
									break;
								} break;
							} break;
						} 
						else {
							System.out.println("조회할 정보가 없습니다.");
							break;
						}
				
					// 이전 메뉴	
					case 4:
						// Utils.showUI("이전 메뉴");
						runLMenu2 = false;
						break;
						
					// 차량 랜덤 생성 후 입고 - UI 노출X
					case 2580:
						Utils.showUI("입차 차량 랜덤 대량 생성");
						
						System.out.print("생성할 차량 수 입력 > ");
						int makeCarNum = sc.nextInt();
						
						if(makeCarNum <= parkingLot.getCurrentSpace()) {
							Utils.makeCars(makeCarNum, parkingLot.currentCars);
							System.out.println(makeCarNum + "대의 차량이 생성 되었습니다.");
						}
						else {
							System.out.println("주차 공간이 부족합니다.");
						}
						break;
					}
				}
				break;
			
			case 3:
				runLMenu3 = true;
				
				while(runLMenu3) {
					Utils.showUI("주차장 관리 메뉴 선택");
					List<String> subMenu3 = Arrays.asList("현재 주차된 차량 현황", "입출차 차량 통계", "결제된 금액 통계", "이전 메뉴");
					selectLMenu3 = Utils.showMenu(subMenu3, sc);
					
					switch(selectLMenu3) {
					
					// 현재 주차된 차량 현황
					case 1:
						Utils.showUI("현재 주차된 차량 현황");
						System.out.println("주차된 차량 목록");
						
						for(Car c : parkingLot.currentCars) {
							c.carPrint();
						}
						System.out.println("주차된 차량 수 : " + parkingLot.getSpace());
						break;
						
					// 입출차 차량 통계
					case 2:
						Utils.showUI("입출차 차량 통계");
                        parkingLot.outCars.showAllCar();
						break;
						
					// 결제된 금액 통계					
					case 3:
						Utils.showUI("결제된 금액 통계");
                        parkingLot.outCars.showAllPay();
						break;
						
					// 이전 메뉴	
					case 4:
						// Utils.showUI("이전 메뉴");
						runLMenu3 = false;
						break;
					}
				}
				break;
				
			case 4:
				Utils.showUI("시스템 종료");
				runUMenu = false;
				break;
			}
		}
	}
}
