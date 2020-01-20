package by.etc.introdaction.classes;

import java.util.*;

public class ListCustomer {
    Customer[] customers;
    Customer customer;

    //for example******************************************************************
    static String[] arrayName = {"Василий", "Андрей", "Александр", "Татьяна", "Виктория", "Светлана", "Василий", "Ирина", "Виктория", "Дарья"};
    static String[] arraySurname = {"Иванов", "Петров", "Пархоменко", "Рак", "Фещенко", "Бабич", "Иванов", "Веко", "Чергинец", "Петрова"};
    static String[] arrayPatronymic = {"Васильевич", "Андреевич", "Александрович", "Петровна", "Владимировна", "Сергеевна", "Дмитриевич", "Сергеевна", "Максимовна", "Александровна"};
    static String[] arrayAdress = {"г. Минск", "г. Гомель", "г. Брест", "г. Витебск", "г.Могилев", "г. Гродно", "г. Мозырь", "г. Барановичи", "г. Минск", "г. Минск"};
    //*********************************************************************************

    public static void main(String[] args) {

        //create an object and fill it with Customer objects
        ListCustomer listCustomer = new ListCustomer(10);
        for (int i = 0; i < listCustomer.customers.length; i++) {
            listCustomer.customer = new Customer(arrayName[i], arraySurname[i], arrayPatronymic[i], arrayAdress[i]);
            listCustomer.customers[i] = listCustomer.customer;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(listCustomer.customers[i]);
        }
        System.out.println();

        listCustomer.sortBySurname();

        System.out.println();

        listCustomer.numberCard();


    }

    ListCustomer(int n) {
        customers = new Customer[n];
    }

    public void sortBySurname() {
        ArrayList<Customer> arrayList = new ArrayList<>(Arrays.asList(customers));
        Collections.sort(arrayList);
        for (Customer c : arrayList) {
            System.out.println(c.toString());
        }
    }

    public void numberCard() {
        Scanner sc = new Scanner(System.in);
        int min;
        int max;
        System.out.println("Введите минимальное значение номера кварты:");
        while (sc.hasNextInt() == false) {
            sc.next();
        }
        min = sc.nextInt();
        System.out.println("Введите максимальное значение номера кварты:");
        while (sc.hasNextInt() == false) {
            sc.next();
        }
        max = sc.nextInt();
        if (max >= min) {
            for (Customer c : customers) {
                if ((c.getCreditCard() >= min) && (c.getCreditCard() <= max)) {
                    System.out.println(c);
                }
            }
        } else {
            System.out.println("найбольший номер карты не может быть меньше наименьшего номера карты");
            this.numberCard();
        }
    }
}
