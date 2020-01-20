package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
 * единиц равно номеру столбца.
 */
public class ArrayArray14 {
    public static void main(String[] args) {

        int s = 0, k = 0, p = 0;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите количество строк матрицы:");
            s = Integer.parseInt(sc.next());
            System.out.println("Введите количество столбцов матрицы:");
            k = Integer.parseInt(sc.next());

        } catch (NumberFormatException ex) {
            System.out.println("Вы ввели недопустимые символы");
            System.exit(0);
        }

        int[][] arr = new int[s][k];

        //перебор всех элементов
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < s; i++) {
                //если номер столбца > переменной. то текущий элемент 1
                // и увеличиваем p
                if (j > p) {
                    arr[i][j] = 1;
                    p++;
                    ////если номер столбца <= переменной. то текущий элемент 0
                } else {
                    arr[i][j] = 0;
                }
            }
            p = 0;
        }
        //выводим матрицу
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(arr[i][j] + "      ");
            }
            System.out.println();
        }
    }
}
