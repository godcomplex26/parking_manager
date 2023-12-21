package com.java.parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class Test {
    public static void main(String[] args) {
        ArrayList<TestT> cars = new ArrayList<>();
        // Car 객체를 cars에 추가...
        for (int i=10; i > 0; i--) {
            cars.add(new TestT(i, "d"));
        }

        Collections.sort(cars, new Comparator<TestT>() {
            @Override
            public int compare(TestT c1, TestT c2) {
                return Integer.compare(c1.id, c2.id);
            }
        });

        // 정렬된 cars 출력...
        for (TestT t : cars) {
            System.out.printf("%d %s\n", t.id, t.name);
        }
    }
}
