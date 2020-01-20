package by.etc.introdaction.classes;

//Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
//менять колесо, вывести на консоль марку автомобиля.
public class Car {
    private String model;
    private Wheel[] wheels = new Wheel[4];
    private Engine engine;
    private int fuelTank;
    private int fuel;
    private boolean driver;

    Car(String model, int fuel, boolean driver, int power, int fuelTank) {

        this.model = model;
        this.driver = driver;
        if ((fuelTank >= 15) && (fuelTank <= 50)) {
            this.fuelTank = fuelTank;
        } else {
            this.fuelTank = 30;
        }
        if (fuel > fuelTank) {
            this.fuel = 15;
        } else {
            this.fuel = fuel;
        }
        Wheel w;
        for (int i = 0; i < wheels.length; i++) {
            w = new Wheel();
            wheels[i] = w;
        }
        engine = new Engine(power);
    }

    public boolean go() {
        for (Wheel w : wheels) {
            if (!w.isReady()) {
                System.out.println("Check wheels");
                return false;
            }
        }
        if (!engine.isStartEngine()) {
            System.out.println("You didn't start the engine");
            return false;
        }
        if (!(fuel > 5)) {
            System.out.println("Fuel about zero");
            return false;
        }
        if (!driver) {
            System.out.println("There is not driver");
            return false;
        }
        System.out.println("Car is going");
        return true;
    }

    public boolean refueling(int amountOfFuel) {
        int x = fuelTank - fuel;
        if (x == 0) {
            System.out.println("no refueling required");
            return false;
        }
        if (amountOfFuel <= x) {
            System.out.println("refueled on " + amountOfFuel + "liters");
            return true;
        } else {
            System.out.println("we have refueled only on" + x + " liters");
            return true;
        }
    }

    public boolean changeWheel(int numberWheel) {
        if ((numberWheel <= 0) || (numberWheel > 4)) {
            System.out.println("Car has only 4 wheels");
            return false;
        } else {
            if ((wheels[numberWheel].getWear() > 75) || (wheels[numberWheel].getPressure() < 40)) {
                System.out.println("Wheel #" + numberWheel + " has been changed");
                wheels[numberWheel] = new Wheel();
                return true;
            } else {
                System.out.println("Change of wheel #" + numberWheel + " not required");
                return false;
            }
        }
    }

    public void showModel() {
        System.out.println("Model of car: " + this.model);
    }

    public String getModel() {
        return model;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getFuel() {
        return fuel;
    }

    public boolean isDriver() {
        return driver;
    }

    public int getFuelTank() {
        return fuelTank;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDriver(boolean driver) {
        this.driver = driver;
    }

    public void setFuelTank(int fuelTank) {
        this.fuelTank = fuelTank;
    }
}
