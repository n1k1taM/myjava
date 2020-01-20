package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
 * на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
 * пользователь с клавиатуры
 */
public class ArrayArray8 {
    public static void main(String[] args) {

        int s = 0, k = 0, p = 0;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите размер матрицы:");
            s = Integer.parseInt(sc.next());
            System.out.println("Введите номер первого столбца:");
            k = Integer.parseInt(sc.next());
            System.out.println("Введите номер второго столбца:");
            p = Integer.parseInt(sc.next());

        } catch (NumberFormatException ex) {
            System.out.println("Вы ввели недопустимые символы");
            System.exit(0);
        }
        // выполняем проверки на равенство введенных строк и на превышение порядка матрицы
        if ((k | p) >= s) {
            System.out.println("Введенный номер превышает размер матрицы");
            System.exit(0);
        } else if (k == p) {
            System.out.println("Столбцы совпадают");
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
        System.out.println("**********************************");

        //делаем перебор по строкам
        // в каждой строке меняем местами нужные элементы используя k и p
        for (int i = 0; i < s; i++) {
            int j = arr[i][k];
            arr[i][k] = arr[i][p];
            arr[i][p] = j;
        }
        //выводим результат
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
