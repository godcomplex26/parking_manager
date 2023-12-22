import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

import com.java.parking.*;

public class App {
    // 데이터 베이스
    // static ArrayList<Car> currentCars = new ArrayList<>();
    // static ArrayList<Car> outCars;
    // static ArrayList<Member> members;
    // static ParkingLot parkingLot = new ParkingLot();

    // public static void main(String[] args) {
    //     // System.out.println(parkingLot.getCurrentSpace());
    //     // Car car = new Car(fakeCarNumRecognizer("0"), "중형");
    //     // for (int i=0; i < 110; i++) {
    //     //     parkingLot.carIn(car);
    //     // }
    //     // System.out.println(parkingLot.getCurrentSpace());

    //     // System.out.println(fakeCarNumRecognizer("0"));
    //     Car carnumber = new Car(fakeCarNumRecognizer("0"), "중형");
    //     currentCars.add(new Car(fakeCarNumRecognizer("0"), "중형"));
    //     currentCars.add(new Car(fakeCarNumRecognizer("0"), "중형"));
    //     currentCars.add(carnumber);
    //     System.out.println("-----------"+carnumber.getCarNum());
    //     // if (currentCars.contains(car))
    //     //     System.out.println(car.getCarNum());

    //     CRUD<Car> parkingCars = new CRUD<Car>();
    //     parkingCars.add(new Car(fakeCarNumRecognizer("0"), "중형"));
    //     parkingCars.add(new Car(fakeCarNumRecognizer("0"), "중형"));
    //     parkingCars.add(carnumber);

    //     String searchCarNum = carnumber.getCarNum();
    //     ArrayList<Car> carsWithSpecificCarNum = parkingCars.find(car -> car.getCarNum().equals(searchCarNum));
    //     for (Car car : parkingCars.getAll()) {
    //         System.out.println(car.getCarNum());
    //     }

    //     // 결과 출력
    //     for (Car car : carsWithSpecificCarNum) {
    //         System.out.println(car.getCarNum());
    //     }

    //     Instant timeIn = Instant.now();
    //     Instant timeOut = Instant.now().plus(2, ChronoUnit.HOURS);
    //     Duration duration = Duration.between(timeIn, timeOut);
    //     System.out.println(duration.toMinutes());
    // }

    // public static String fakeCarNumRecognizer(String carNum) {
    //     if (carNum.equals("0")) {
    //         Random random = new Random();
    //         carNum = String.valueOf(random.nextInt(10, 997)) + "허" + String.valueOf(random.nextInt(1000, 9999));
    //         return carNum;
    //     }
    //     return carNum;
    // }

    // public static int toMin(Instant timeIn, Instant timeOut) {
    //     Duration duration = Duration.between(timeIn, timeOut);
    //     return (int)duration.toMinutes();
    // }

    // public static int payCalc(Instant timeIn, Instant timeOut) {
    //     // 분 단위 절삭
    //     int duration = (toMin(timeIn, timeOut)/10) * 10;
        
    //     int amount = duration*200;
    //     return amount;
    // }
}