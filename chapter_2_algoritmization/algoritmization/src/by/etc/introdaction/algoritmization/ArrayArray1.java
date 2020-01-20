package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
 */
public class ArrayArray1 {
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

        //создаем и инициализируем двумерный массив
        int[][] arr = new int[s][s];
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                arr[i][j] = (int) (Math.random() * 100);
                System.out.print(arr[i][j] + "   ");
            }
            System.out.println();
        }

        for (int j = 0; j < s; j++) {
            //проверяем нечетность столбца
            if (j % 2 != 0) {
                // первый элемент столбца должен быть больше последнего
                if (arr[0][j] > arr[s - 1][j]) {
                    System.out.println("Столбец №" + j);
                    //выводим все элементы столбца
                    for (int i = 0; i < s; i++) {
                        System.out.println(arr[i][j]);
                    }
                }
            }
        }
    }
}
