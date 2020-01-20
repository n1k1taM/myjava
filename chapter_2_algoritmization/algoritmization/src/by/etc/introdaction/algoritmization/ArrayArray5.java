package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */
public class ArrayArray5 {
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

        // присваиваем переменной x значение n, при переходе на следующую строку x будем уменьшать на 1
        //все не заполненные элементы инициализируются нулями
        x = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < x; j++) {

                arr[i][j] = i + 1;
            }
            x--;
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
