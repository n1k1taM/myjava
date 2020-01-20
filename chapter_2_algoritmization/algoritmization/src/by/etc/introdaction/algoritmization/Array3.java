package by.etc.introdaction.algoritmization;

import java.util.Random;
import java.util.Scanner;

/**
 * Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
 * положительных и нулевых элементов.
 */
public class Array3 {
    public static void main(String[] args) {

        int n = 0, pos = 0, neg = 0, zero = 0;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите количество элементов массива:");
            n = Integer.parseInt(sc.next());

        } catch (NumberFormatException e) {
            System.out.println("Вы ввели недопустимые символы");
            System.exit(0);
        }
        double[] array = new double[n];
        //заполняем массив действительными числами
        for (int i = 0; i <= array.length - 1; i++) {

            array[i] = Math.random() * Integer.MAX_VALUE - Math.random() * Integer.MAX_VALUE;

        }
        //перебираем все элементы массива и проверяем их знак
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] == 0) {
                zero++;
            } else if (array[i] < 0) {
                neg++;
            } else {
                pos++;
            }
        }

        System.out.println("Массив содержит " + pos + " положительных элементов");
        System.out.println("Массив содержит " + neg + " отрицательных элементов");
        System.out.println("Массив содержит " + zero + " нулевых элементов");
    }

}
