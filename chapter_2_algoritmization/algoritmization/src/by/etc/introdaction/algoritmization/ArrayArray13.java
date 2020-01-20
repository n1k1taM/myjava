package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
 */
public class ArrayArray13 {

    public static void main(String[] args) {

        int s = 0, k = 0;

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
        System.out.println("По возростанию");

        k = s;

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                //цикл для обхода неотсортированных элементов
                for (int t = 0; t < k - 1; t++) {
                    //если выполняется условие переставляем элементы
                    if (arr[t][i] > arr[t + 1][i]) {
                        int buf = arr[t][i];
                        arr[t][i] = arr[t + 1][i];
                        arr[t + 1][i] = buf;
                    }
                }
                //уменьшаем k на 1, т.к. k-элемент после цикла отсортирован
                k--;
            }
            //для сортировки следующей строки k=s
            k = s;
        }
        //выводим результат
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.print(arr[i][j] + "      ");
            }
            System.out.println();
        }

        System.out.println("По убыванию");

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                //цикл для обхода неотсортированных элементов
                for (int t = 0; t < k - 1; t++) {
                    //если выполняется условие переставляем элементы
                    if (arr[t][i] < arr[t + 1][i]) {
                        int buf = arr[t][i];
                        arr[t][i] = arr[t + 1][i];
                        arr[t + 1][i] = buf;
                    }
                }
                //уменьшаем k на 1, т.к. k-элемент после цикла отсортирован
                k--;
            }
            //для сортировки следующей строки k=s
            k = s;
        }
        //выводим результат
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.print(arr[i][j] + "      ");
            }
            System.out.println();
        }
    }
}
