package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 */
public class Array1 {
    public static void main(String[] args) {

        int n = 0, k = 0, sum = 0;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите количество элементов массива:");
            n = Integer.parseInt(sc.next());
            System.out.print("Введите число К:");
            k = Integer.parseInt(sc.next());

        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не целое число");
            System.exit(0);
        }

        int[] array = new int[n];

        //заполняем массив натуральными числами от 1 до 100
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = (int) (Math.random() * 99) + 1;
        }
        // перебор всех элементов массива и проверка их на кратность
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] % k == 0) {
                sum += array[i];
            }
        }
        System.out.println("Сумма = " + sum);
    }
}
