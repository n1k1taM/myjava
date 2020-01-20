package by.etc.introdaction.basicsjfoop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/********************************************************
  Задача 3.
  Создать класс Календарь с внутренним классом,
  с помощью объектов которого можно хранить информацию о выходных и праздничных днях.
 *******************************************************/


public class Main {

    public static void main(String[] args) {

        int year=2020;
        Calendar calendar=new Calendar(year);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        calendar.addHoliday(LocalDate.parse("01.01." + year, dtf), "New Year");
        calendar.addHoliday(LocalDate.parse("07.01." + year, dtf), "Orthodox Christmas");
        calendar.addHoliday(LocalDate.parse("08.03." + year, dtf), "Women’s Day");


        calendar.printHolidays();

        Calendar.Holiday holiday = calendar.removeHoliday("October Revolution Day");
        System.out.println("\nremoved holiday " + holiday);
    }
}
