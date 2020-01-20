package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Два простых числа называются «близнецами», если они отличаются друг от друга
 * на 2 (например, 41 и 43). Найти и напечатать все пары «близнецов» из отрезка
 * [n,2n], где n - заданное натуральное число больше 2. Для решения задачи
 * использовать декомпозицию.
 */
public class Decomposition13 {

    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);

        while (n < 3) {
            System.out.print("Введите целое число n, которое больше 2:");
            while (sc.hasNextInt() == false) {
                sc.next();
                System.out.print("\n Введите целое число n, которое больше 2:");
            }
            n = Integer.parseInt(sc.next());
        }

        Decomposition13.numberTwins(n);
    }

    public static void numberTwins(int n) {

        int m = 0;
        for (int i = n; i <= n + 1; i++) {
            for (int j = i; j + 2 <= 2 * n; j = j + 2) {
                m = j + 2;
                System.out.print(j + " и " + m + " ,");
            }
            System.out.println();
        }
    }

}
