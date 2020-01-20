package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Сформировать квадратную матрицу порядка N по правилу A[I,J]=sin((I2-J2)/N )
 */
public class ArrayArray7 {
    public static void main(String[] args) {

        int n = 0, count=0;
        double x = 0;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите порядок матрицы:");
            n = Integer.parseInt(sc.next());

        } catch (NumberFormatException ex) {
            System.out.println("Вы ввели недопустимые символы");
            System.exit(0);
        }

        //создаем массив размерности n
        double[][] arr = new double[n][n];

        for (double i = 0; i < n; i++) {
            for (double j = 0; j < n; j++) {
                // вычисляем выражение по условию задачи
                x = ((i * i - j * j) / n);
                //подставляем значение для вычисления sin
                arr[(int) i][(int) j] = Math.sin(Math.toRadians(x));
            }
        }
        //выводим матрицу на консоль
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "  ");
                if (arr[i][j]>0){
                    count++;
                }
            }
            System.out.println();
        }
        System.out.print("Количество положительных чисел равно: "+count);

    }

}
