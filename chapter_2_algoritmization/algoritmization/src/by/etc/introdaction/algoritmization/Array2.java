package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
 * числом. Подсчитать количество замен.
 */
public class Array2 {
    public static void main(String[] args) {

        int n = 0, count = 0;
        double z = 0;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите количество элементов последовательности:");
            n = Integer.parseInt(sc.next());
            System.out.print("Введите число Z:");
            z = Double.parseDouble(sc.next());

        } catch (NumberFormatException e) {
            System.out.println("Вы ввели недопустимые символы");
            System.exit(0);
        }
        double[] array = new double[n];
        //заполняем массив действительными числами
        for (int i = 0; i <= array.length - 1; i++) {

            array[i] = Math.random() * Integer.MAX_VALUE - Math.random() * Integer.MAX_VALUE;
        }
        //перебираем все элементы массива и сравниваем их с числом z
        for (int i = 0; i <= array.length - 1; i++) {

            if (array[i] > z) {
                array[i] = z;
                count++;
            }
        }
        System.out.println("Число замен = " + count);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }
}
