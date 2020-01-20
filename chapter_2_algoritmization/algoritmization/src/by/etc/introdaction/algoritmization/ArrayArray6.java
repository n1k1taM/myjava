package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * <p>
 * 1 1 1 1 1 1
 * 0 1 1 1 1 0
 * 0 0 1 1 0 0
 * * * * * *
 * 0 1 1 1 1 0
 * 1 1 1 1 1 1
 */
public class ArrayArray6 {

    public static void main(String[] args) {

        int n = 0, x = 0;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите порядок матрицы:");
            n = Integer.parseInt(sc.next());

        } catch (NumberFormatException ex) {
            System.out.println("Вы ввели недопустимые символы");
            System.exit(0);
        }

        if (n % 2 != 0) {
            System.out.print("Введенное число n по условиям задачи должно быть четным");
            System.exit(0);
        }
        //создаем массив размерности n
        int[][] arr = new int[n][n];

        //заполняем 1 первую половину массива
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                // для условия используем переменную x (x увеличивается -> количество 1 в строке уменьшается
                if (j >= x & j < (n - x)) {
                    arr[i][j] = 1;
                }
            }
            x++;
        }
        //уменьшаем x на единицу, т.к. две строки в середине должны быть одинаковые
        x--;
        //заполняем 2 половину массива
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //используем то же условие, но теперь x уменьшается -> количество 1 увеличивается
                if (j >= x & j < (n - x)) {
                    arr[i][j] = 1;
                }
            }
            x--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}
