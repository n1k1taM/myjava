package by.etc.introdaction.classes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TravelVoucher implements Comparable<TravelVoucher> {
    //constants for searching
    static final String PURPOSE = "searchingByPurpose";
    static final String DESTINATION = "searchingByDestination";
    static final String DAYSOFWEEK = "searchingByDays";

    static Comparator<TravelVoucher> destinationComparator = new Destination();
    static Comparator<TravelVoucher> daysComparator = new NumberOfDays();

    private static Scanner sc = new Scanner(System.in);

    //fields
    private String purpose;
    private String destination;
    private int numberOfDays;
    private double price;
    private String food;
    private String transport;

    TravelVoucher(String purpose, String destination, int numberOfDays, double price, String food, String transport) {
        this.purpose = purpose;
        this.destination = destination;
        this.numberOfDays = numberOfDays;
        this.price = price;
        this.food = food;
        this.transport = transport;

    }

    @Override
    public String toString() {
        return "purpose='" + purpose + '\'' +
                ", destination='" + destination + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", price=" + price +
                ", food='" + food + '\'' +
                ", transport='" + transport;
    }

    //selection
    static void voucherSelection(TravelVoucher... vouchers) {
        String purpose;
        String destination;
        int numberOfDays;
        double price;
        String food;
        String transport;

        System.out.println("Введите назначение путевки выбрав один из следующих вариантов: отдых, экскурсия, лечение, шопинг, круиз ");
        System.out.println();
        while (sc.hasNextLine() == false) {
            sc.next();
            System.out.println("Введите назначение путевки выбрав один из следующих вариантов: отдых, экскурсия, лечение, шопинг, круиз ");
        }
        purpose = sc.nextLine();
        System.out.println("Введите пункт назначения: ");
        System.out.println();
        while (sc.hasNextLine() == false) {
            sc.next();
            System.out.println("Введите пункт назначения:");
        }
        destination = sc.nextLine();

        System.out.println("Включено ли питание (да/нет): ");
        System.out.println();
        while (sc.hasNextLine() == false) {
            sc.next();
            System.out.println("Включено ли питание (да/нет): ");
        }
        food = sc.nextLine();

        System.out.println("Выберите транспорт(Автобус, поезд, самолет) ");
        System.out.println();
        while (sc.hasNextLine() == false) {
            sc.next();
            System.out.println("Выберите транспорт(Автобус, поезд, самолет) ");
        }
        transport = sc.nextLine();

        System.out.println("Введите количество дней от 6 до 18: ");
        System.out.println();
        while (sc.hasNextInt() == false) {
            sc.next();
            System.out.println("Введите количество дней от 6 до 18: ");
        }
        numberOfDays = sc.nextInt();

        for (TravelVoucher voucher : vouchers) {
            if (voucher.purpose.equalsIgnoreCase(purpose)) {
                if (voucher.destination.equalsIgnoreCase(destination)) {
                    if (voucher.numberOfDays >= numberOfDays) {
                        if (voucher.food.equalsIgnoreCase(food)) {
                            if (voucher.transport.equalsIgnoreCase(transport)) {
                                System.out.println(voucher.toString());
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public int compareTo(TravelVoucher o) {
        return this.purpose.compareTo(o.purpose);
    }

    //sorting
    static void sorting(TravelVoucher[] vouchers, String parameter) {
        if (parameter.equals(PURPOSE)) {
            Collections.sort(Arrays.asList(vouchers));
        } else if (parameter.equals(DESTINATION)) {
            Collections.sort(Arrays.asList(vouchers), destinationComparator);
        } else if (parameter.equals(DAYSOFWEEK)) {
            Collections.sort(Arrays.asList(vouchers), daysComparator);
        } else {
            Collections.sort(Arrays.asList(vouchers));
        }
        for (TravelVoucher voucher : vouchers) {
            System.out.println(voucher);
        }
    }

    static class Destination implements Comparator<TravelVoucher> {

        @Override
        public int compare(TravelVoucher o1, TravelVoucher o2) {
            return o1.destination.compareTo(o2.destination);
        }
    }

    static class NumberOfDays implements Comparator<TravelVoucher> {

        @Override
        public int compare(TravelVoucher o1, TravelVoucher o2) {
            return o1.numberOfDays - o2.numberOfDays;
        }
    }

}
