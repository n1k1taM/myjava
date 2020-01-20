package by.etc.introdaction.classes;
import java.util.Arrays;

//Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
//Найти и вывести:
//a) список рейсов для заданного пункта назначения;
//b) список рейсов для заданного дня недели;
//c) список рейсов для заданного дня недели, время вылета для которых больше заданного
public class Airline {
    String destination;
    String flightNumber;
    String typeOfPlane;
    String timeDeparture;
    DaysOfWeek[] daysOfWeek;

    Airline(String destination,String flightNumber,String typeOfPlane,String timeDeparture,DaysOfWeek[] daysOfWeek){
        this.destination=destination;
        this.flightNumber=flightNumber;
        this.typeOfPlane=typeOfPlane;
        this.timeDeparture=timeDeparture;
        this.daysOfWeek=daysOfWeek;
    }

    enum DaysOfWeek{
        SUNDAY("SUNDAY"),
        MONDAY("MONDAY"),
        TUESDAY("TUESDAY"),
        WEDNESDAY("WEDNESDAY"),
        THURSDAY("THURSDAY"),
        FRIDAY("FRIDAY"),
        SATURDAY("SATURDAY");

        private String title;

        DaysOfWeek(String title){
            this.title=title;
        }
        public String getTitle(){
            return title;
        }
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getTypeOfPlane() {
        return typeOfPlane;
    }

    public void setTypeOfPlane(String typeOfPlane) {
        this.typeOfPlane = typeOfPlane;
    }

    public String getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(String timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public DaysOfWeek[] getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(DaysOfWeek[] daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", typeOfPlane='" + typeOfPlane + '\'' +
                ", timeDeparture='" + timeDeparture + '\'' +
                ", daysOfWeek='" + Arrays.asList(daysOfWeek)+ '\'' +
                '}';
    }
}
