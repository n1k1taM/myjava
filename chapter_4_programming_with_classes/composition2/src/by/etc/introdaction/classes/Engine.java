package by.etc.introdaction.classes;

public class Engine {
    private int power = 150;
    private boolean readness = true;
    private boolean startEngine = false;

    Engine() {

    }

    Engine(int power) {
        if ((power >= 70) && (power <= 1500)) {
            this.power = power;
        } else if (power < 70) {
            this.power = 70;
        } else {
            this.power = 1500;
        }
    }

    public int getPower() {
        return power;
    }

    public boolean isReadness() {
        return readness;
    }

    public void setReadness(boolean readness) {
        this.readness = readness;
    }

    public boolean isStartEngine() {
        return startEngine;
    }

    public void setStartEngine(boolean startEngine) {
        if (startEngine) {
            if (isReadness()) {
                this.startEngine = startEngine;
            } else {
                this.startEngine = false;
                System.out.println("Engine has defect");
            }
        } else {
            this.startEngine = startEngine;
        }
    }
}
