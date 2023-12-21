package com.java.parking;

import java.util.ArrayList;

public class Menu {
    ArrayList<String> menu = new ArrayList<>();

    public Menu() {
        
    }

    public static void main(String[] args) {
        MemberArray mlist = new MemberArray();

        mlist.add(new Member("123", "이상목", "123나1234"));
        mlist.add(new Member("1233", "김철수", "12나1234"));
        mlist.add(new Member("1243", "김영희", "13나1234"));

        mlist.showMember("이상목");

    }
}
