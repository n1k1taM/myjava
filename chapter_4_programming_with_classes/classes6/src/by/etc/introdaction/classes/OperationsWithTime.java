package by.etc.introdaction.classes;

//Составьте описание класса для представления времени. Предусмотрте
// возможности установки времени и изменения его отдельных полей (час, минута, секунда)
// с проверкой допустимости вводимых значений. В случае недопустимых значений полей поле
// устанавливается в значение 0. Создать методы изменения времени на заданное количество часов, минут и секунд.
public class OperationsWithTime {
    private int hours;
    private int minutes;
    private int seconds;


    OperationsWithTime() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    OperationsWithTime(int hours, int minutes, int seconds) {
        if (hours > 23 || hours < 0) {
            this.hours = 0;
        } else {
            this.hours = hours;
        }
        if (minutes > 59 || minutes < 0) {
            this.minutes = 0;
        } else {
            this.minutes = minutes;
        }
        if (seconds > 59 || seconds < 0) {
            this.seconds = 0;
        } else {
            this.seconds = seconds;
        }

    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours > 23 || hours < 0) {
            this.hours = 0;
        } else {
            this.hours = hours;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes > 59 || minutes < 0) {
            this.minutes = 0;
        } else {
            this.minutes = minutes;
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds > 59 || seconds < 0) {
            this.seconds = 0;
        } else {
            this.seconds = seconds;
        }
    }

    public void addHours(int numberHours) {
        int newHours = hours + numberHours;
        if (newHours < 24) {
            hours = newHours;
        } else {
            hours = newHours % 24;
        }
    }

    public void subtractHours(int numberHours) {
        int newHours = hours - numberHours;
        if (newHours >= 0) {
            hours = newHours;
        } else {
            hours = 24 + newHours;
        }
    }


    public void addMinutes(int numberMinutes) {
        int newMinutes = minutes + numberMinutes;
        if (newMinutes < 60) {
            minutes = newMinutes;
        } else {
            minutes = newMinutes % 60;
            addHours(newMinutes / 60);
        }
    }

    public void subtractMinutes(int numberMinutes) {
        int newMinutes = minutes - numberMinutes;
        if (newMinutes >= 0) {
            minutes = newMinutes;
        } else {
            if (numberMinutes / 60 == 0) {
                subtractHours(1);
            } else {
                subtractHours(numberMinutes / 60);
            }
            minutes = 60 + minutes - numberMinutes % 60;
        }
    }

    public void addSeconds(int numberSeconds) {
        int newSeconds = seconds + numberSeconds;
        if (newSeconds < 60) {
            seconds = newSeconds;
        } else {
            seconds = newSeconds % 60;
            addMinutes(newSeconds / 60);
        }
    }

    public void subtractSeconds(int numberSeconds) {
        int newSeconds = seconds - numberSeconds;
        if (newSeconds >= 0) {
            seconds = newSeconds;
        } else {
            if (numberSeconds / 60 == 0) {
                subtractMinutes(1);
            } else {
                if (numberSeconds % 60 != 0) {
                    subtractMinutes(numberSeconds / 60 + 1);
                }

            }
            seconds = 60 + seconds - numberSeconds % 60;
        }
    }

    public void showTime() {
        System.out.println("Hours:" + this.getHours() + " Minutes:" + this.getMinutes() + " Seconds:" + this.getSeconds());
    }
}
