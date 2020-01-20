package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */
public class ArrayArray3 {
    public static void main(String[] args) {

        int s = 0, k = 0, p = 0;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите размер матрицы:");
            s = Integer.parseInt(sc.next());
            System.out.println("Введите номер строки k:");
            k = Integer.parseInt(sc.next());
            System.out.println("Введите номер столбца p:");
            p = Integer.parseInt(sc.next());

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

        //k и p должны быть меньше размерности матрицы
        if (k < s & p < s) {
            System.out.println("Выводим строку №" + k);
            // индекс по строке неизменный, меняем индекс по столбцу
            for (int j = 0; j < s; j++) {
                System.out.print(arr[k][j] + "  ");
            }
            System.out.println(" \n Выводим столбец №" + p);
            //индекс по столбцу неизменный, меняем индекс по строке
            for (int i = 0; i < s; i++) {
                System.out.println(arr[i][p]);
            }
        }else {
            System.out.println("Введенный номер строки или столбца превышает размерность матрицы");
        }
    }

}
