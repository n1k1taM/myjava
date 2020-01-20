package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */
public class ArrayArray2 {
    public static void main(String[] args) {

        int s = 0;
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
                arr[i][j] = (int) (Math.random() * 100);
                System.out.print(arr[i][j] + "     ");
            }
            System.out.println();
        }

        System.out.println("Диагональные элементы");
        //изменяем сразу две переменные в цикле для вывода диагональных элементов
        for (int i = 0, j = 0; i < s; i++, j++) {
            System.out.print(arr[i][j] + "  ");
        }
    }
}
