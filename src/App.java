import java.util.ArrayList;
import java.util.Random;

import com.java.parking.*;

public class App {
    // 데이터 베이스
    ArrayList<Car> currentCars = new ArrayList<>();
    ArrayList<Car> outCars;
    ArrayList<Member> members;

    public static void main(String[] args) {
        System.out.println(fakeCarNumRecognizer("0"));
    }

    public static String fakeCarNumRecognizer(String carNum) {
        if (carNum.equals("0")) {
            Random random = new Random();
            carNum = String.valueOf(random.nextInt(10, 997)) + "허" + String.valueOf(random.nextInt(1000, 9999));
            return carNum;
        }
        return carNum;
    }
}