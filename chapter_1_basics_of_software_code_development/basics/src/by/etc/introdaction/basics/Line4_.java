package by.etc.introdaction.basics;

import java.util.Scanner;
/**
 Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
 дробную и целую части числа и вывести полученное значение числа.
 */
public class Line4_ {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите действительное число вида: " + "nnn.ddd");

        try {
            Double d = Double.parseDouble(sc.next());
            String s = d.toString();
            String[] reverse = s.split("\\.");
            s = reverse[1] + "." + reverse[0];
            System.out.println(s);
        } catch (NumberFormatException e) {
            System.out.println("Введенное число не соответствует заданному формату");
            System.exit(0);
        }
        // TODO code application logic here
    }

}
