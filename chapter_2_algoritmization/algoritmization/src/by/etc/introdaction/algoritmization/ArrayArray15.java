package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
 */
public class ArrayArray15 {
    public static void main(String[] args) {


        int s = 0, k = 0, max = 0, count = 0;

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
                //ищем наибольший элемент при заполнении массива
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
                System.out.print(arr[i][j] + "     ");
            }
            System.out.println();
        }

        System.out.println("*****************************************   ");

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                //для определения четного элемента используем переменную count
                //котороя увеличивается при каждой итерации
                if (count % 2 == 0) {
                    arr[i][j] = max;
                }
                count++;
                System.out.print(arr[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
