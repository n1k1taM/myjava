package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */
public class ArrayArray4 {
    public static void main(String[] args) {

        int n = 0;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите порядок матрицы (четное число):");
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

        for (int i = 0; i < n; i++) {
            //если номер строки четный, то прямой порядок цифр
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = j + 1;
                }
                // если номер строки не четный, то обратный порядок цифр
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    arr[i][n - 1 - j] = j + 1;
                }
            }
        }
        // выводим матрицу на консоль
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}
