package com.java.parking;

import java.util.ArrayList;
import java.util.Comparator;


interface InnerMemberArray {
    boolean isMember(String carNum);
    Member findMember(String any);
    void showAll();
    void showMember(String numOrName);
    MemberArray sortMemberById();
    MemberArray sortMemberIssueDate();
}

public class MemberArray extends ArrayList<Member> implements InnerMemberArray {
    public boolean isMember(String carNum) {
        if (findMember(carNum) == null) {
            return false;
        }
        return true;
    }

    // public boolean isNumeric(String str) {
    //     return str != null && str.matches("-?\\d+(\\.\\d+)?");
    // }

    public Member findMember(String any) {
        for (Member member : this) {
            if (member.memId.equals(any)) {
                // int number = Integer.parseInt(any);
                // findMember(number);
                return member;
            }
            if (member.carNum.equals(any)) {
                return member;
            }
            if (member.memName.equals(any)) {
                return member;
            }
        }
        return null;
    }

    // public Member findMember(int memId) {
    //     for (Member member : this) {
    //         if (member.memId == memId) {
    //             return member;
    //         }
    //     }
    //     return null;
    // }

    public void showAll() {
        System.out.printf("%-15s %-15s %-15s\n", "아이디", "차량번호", "이름");
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

    // public void showMember(int memId) {
    //     Member member = findMember(memId);
    //     if (member == null) {
    //         System.out.println("검색 결과 없음.");
    //     }
    //     else {
    //         System.out.printf("%-15d %-15s %-15s\n", "아이디", "차량번호", "이름");
    //         System.out.printf("%-15d %-15s %-15s\n", member.memId, member.carNum, member.memName);
    //     }
    // }
    
    public MemberArray sortMemberById() {
        MemberArray sortedMember = new MemberArray();
        sortedMember.addAll(this);
        sortedMember.sort(Comparator.comparing(member -> member.memId));
        return sortedMember;
    }

    public MemberArray sortMemberIssueDate() {
        MemberArray sortedMember = new MemberArray();
        sortedMember.addAll(this);
        sortedMember.sort(Comparator.comparing(member -> member.issueDate));
        return sortedMember;
    }

    public static void main(String[] args) {
        MemberArray mlist = new MemberArray();

        mlist.add(new Member("123", "이상목", "123나1234"));
        mlist.add(new Member("1233", "김철수", "12나1234"));
        mlist.add(new Member("1243", "김영희", "13나1234"));

        mlist.showMember("이상목");

    }
}
