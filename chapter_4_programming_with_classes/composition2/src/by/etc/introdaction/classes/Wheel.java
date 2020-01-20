package by.etc.introdaction.classes;

public class Wheel {
    private int wear = 0;
    private int pressure = 100;
    private boolean ready = true;

    Wheel() {
    }

    Wheel(int wear, int pressure) {
        // wear setting
        if ((wear >= 0) && (wear <= 100)) {
            this.wear = wear;
        } else if (wear < 0) {
            this.wear = 0;
        } else {
            this.wear = 100;
        }
        // pressure setting
        if ((pressure >= 0) && (pressure <= 150)) {
            this.pressure = wear;
        } else if (pressure < 0) {
            this.pressure = 0;
        } else {
            this.pressure = 0;
        }
        //readiness
        if (wear <= 80) {
            if ((pressure >= 60) && (pressure <= 115)) {
                this.ready = true;
            }
        }
    }

    public int getWear() {
        return wear;
    }

    public void setWear(int wear) {
        if ((wear >= 0) && (wear <= 100)) {
            this.wear = wear;
        } else if (wear < 0) {
            this.wear = 0;
        } else {
            this.wear = 100;
        }
        if (wear > 80) {
            this.ready = false;
        } else if (wear <= 80) {
            if ((pressure >= 60) && (pressure <= 115)) {
                this.ready = true;
            }
        }
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        if ((pressure >= 0) && (pressure <= 150)) {
            this.pressure = wear;
        } else if (pressure < 0) {
            this.pressure = 0;
        } else {
            this.pressure = 0;
        }
        if ((pressure < 60) && (pressure > 115)) {
            this.ready = false;
        } else if (wear <= 80) {
            if ((pressure >= 60) && (pressure <= 115)) {
                this.ready = true;
            }
        }
    }

    public boolean isReady() {
        return ready;
    }

}
