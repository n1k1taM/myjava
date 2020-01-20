package by.etc.introdaction.classes;

public class ExampleCar {
    public static void main(String[] args) {
        Car car = new Car("Ferrari", 30, true, 850, 30);
        car.go();
        car.refueling(10);
        car.changeWheel(2);
        car.showModel();

        car.getEngine().setStartEngine(true);

        car.go();

    }
}
