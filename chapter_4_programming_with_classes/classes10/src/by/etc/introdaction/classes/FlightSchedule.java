package by.etc.introdaction.classes;

import java.util.Scanner;

public class FlightSchedule {
    Airline[] airlines;
    Airline airline;
    Scanner sc = new Scanner(System.in);

    //for example********************************************
    static String[] arrayDestination = {"Gomel", "Moscow", "Helsinki", "Geneva", "Kiev", "London"};
    static String[] arrayFlightNumber = {"B2-867", "B2-889", "B2-698", "B2-567", "B2-345", "B2-956"};
    static String[] arrayTypeOfPlane = {"Boeing 737", "Embraer 175", "CRJ-200", "Embraer 195", "Airbus 320", "Boeing 777"};
    static String[] arrayTimeDeparture = {"14:30", "10:40", "15:25", "14:00", "18:35", "13:30"};
    static Airline.DaysOfWeek[] d1 = {
            Airline.DaysOfWeek.MONDAY, Airline.DaysOfWeek.FRIDAY};
    static Airline.DaysOfWeek[] d2 = {
            Airline.DaysOfWeek.SATURDAY, Airline.DaysOfWeek.THURSDAY};
    static Airline.DaysOfWeek[] d3 = {
            Airline.DaysOfWeek.MONDAY, Airline.DaysOfWeek.SUNDAY};
    static Airline.DaysOfWeek[] d4 = {
            Airline.DaysOfWeek.TUESDAY, Airline.DaysOfWeek.FRIDAY};
    static Airline.DaysOfWeek[] d5 = {
            Airline.DaysOfWeek.WEDNESDAY, Airline.DaysOfWeek.MONDAY};
    static Airline.DaysOfWeek[] d6 = {
            Airline.DaysOfWeek.SUNDAY, Airline.DaysOfWeek.SATURDAY};
    static Airline.DaysOfWeek[][] arrayDaysOfWeek = {d1, d2, d3, d4, d5, d6};


    FlightSchedule(int n) {
        airlines = new Airline[Math.abs(n)];
    }

    public static void main(String[] args) {

        FlightSchedule flightSchedule = new FlightSchedule(6);
        for (int i = 0; i < flightSchedule.airlines.length; i++) {
            flightSchedule.airline = new Airline(arrayDestination[i], arrayFlightNumber[i], arrayTypeOfPlane[i],
                    arrayTimeDeparture[i], arrayDaysOfWeek[i]);
            flightSchedule.airlines[i] = flightSchedule.airline;
        }
//show schedule
        for (int i = 0; i < flightSchedule.airlines.length; i++) {
            System.out.println(flightSchedule.airlines[i]);
        }
        System.out.println();

        flightSchedule.pointOfDestination();

        System.out.println();

        flightSchedule.poitedDayOfWeek();

        System.out.println();

        flightSchedule.dayAndTime();

    }

    //show list of flight for pointed destination
    public void pointOfDestination() {
        System.out.println("Enter point destination: ");
        String pointDest;
        while (sc.hasNextLine() == false) {
            sc.next();
        }
        pointDest = sc.nextLine();
        for (Airline a : airlines) {
            if (pointDest.trim().equalsIgnoreCase(a.getDestination())) {
                System.out.println(a);
            }
        }
    }

    //show list of flight for pointed day of week
    public void poitedDayOfWeek() {
        System.out.println("Enter day of week: ");
        String day;
        while (sc.hasNextLine() == false) {
            sc.next();
        }
        day = sc.nextLine();
        for (Airline a : airlines) {
            for (Airline.DaysOfWeek d : a.getDaysOfWeek()) {
                if (day.trim().equalsIgnoreCase(d.getTitle())) {
                    System.out.println(a);
                }
            }
        }
    }

    //show list of flight for poined day and time (time after entered time)
    public void dayAndTime() {
        System.out.println("Enter day of week: ");
        String day;
        String time;
        while (sc.hasNextLine() == false) {
            sc.next();
        }
        day = sc.nextLine();
        System.out.println("Enter time: ");
        while (sc.hasNextLine() == false) {
            sc.next();
        }
        time = sc.nextLine();
        for (Airline a : airlines) {
            for (Airline.DaysOfWeek d : a.getDaysOfWeek()) {
                if (day.trim().equalsIgnoreCase(d.getTitle())) {
                    if ((time.trim().compareTo(a.getTimeDeparture())) < 1) {
                        System.out.println(a);
                    }
                }
            }
        }
    }
}
