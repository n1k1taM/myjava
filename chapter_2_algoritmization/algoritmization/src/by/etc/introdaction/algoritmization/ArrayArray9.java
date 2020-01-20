package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
 * столбец содержит максимальную сумму.
 */
public class ArrayArray9 {
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
                arr[i][j] = (int) (Math.random() * 10);
                System.out.print(arr[i][j] + "     ");
            }
            System.out.println();
        }
        System.out.println("**********************************");

        for (int j = 0; j < s; j++) {
            //в каждом столбце суммируем элементы
            for (int i = 0; i < s; i++) {
                sum += arr[i][j];
            }
            //если сумма элементов текущего столбца > max, то
            // в max записываем sum и запоминаем индекс столбца
            if (sum > max) {
                index = j;
                max = sum;
            }
            // для новой итерации sum обнуляем
            sum = 0;
        }
        System.out.print("Индекс столбца: " + index + " Сумма столбца = " + max);
    }
}
