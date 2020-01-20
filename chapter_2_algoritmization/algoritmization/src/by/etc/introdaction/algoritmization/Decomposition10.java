package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Дано натуральное число N. Написать метод(методы) для формирования массива,
 * элементами которого являются цифры числа N.
 */
public class Decomposition10 {

    public static void main(String[] args) {

        int n = 0;
        int[] array;

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите натуральное число N:");
        while (sc.hasNextInt() == false) {
            sc.next();
            System.out.print("\n Введите натуральное число N:");
        }
        n = Integer.parseInt(sc.next());

        if (n > 0) {
            array = arrayN(n);
            for (int j = 0; j < number(n); j++) {
                System.out.print(array[j] + ", ");
            }
        } else {
            System.out.println("Вы ввели не натуральное число");
        }
    }
    
    //формируем массив
    public static int[] arrayN(int n) {
        int x = number(n);
        int[] arr = new int[x];

        for (int i = x - 1; i >= 0; i--) {
            arr[i] = n % 10;
            n /= 10;
        }
        return arr;
    }

    //находим количество цифр в числе N
    public static int number(int n) {
        int count = 0;

        while (n != 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

}
