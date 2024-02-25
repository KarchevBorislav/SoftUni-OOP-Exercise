package NeedForSpeed;

public class Main {
    public static void main(String[] args) {

        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(50,250);
        SportCar sportCar = new SportCar(20,120);
        Car car = new Car(10,80);
        raceMotorcycle.drive(100);
        sportCar.drive(100);
        car.drive(100);
    }
}
