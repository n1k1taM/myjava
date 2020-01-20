package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Найти положительные элементы главной диагонали квадратной матрицы.
 */
public class ArrayArray10 {
    public static void main(String[] args) {

        int s = 0, index = 0, sum = 0, max = 0;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите размер матрицы:");
            s = Integer.parseInt(sc.next());
        } catch (NumberFormatException ex) {
            System.out.println("Вы ввели недопустимые символы");
            System.exit(0);
        }

        //создаем и инициализируем двумерный массив и выводим его на консоль
        int[][] arr = new int[s][s];
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                arr[i][j] = (int) (Math.random() * 200 - 100);
                System.out.print(arr[i][j] + "     ");
            }
            System.out.println();
        }
        System.out.println("**********************************");

        //для перемещения по диагонали инкрементируем сразу две переменные (i,j)
        for (int i = 0, j = 0; (i & j) < s; i++, j++) {
            //если >=0 то выводим
            if (arr[i][j] > 0) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
