package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
 * Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
 * один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
 * дополнительный массив.
 */
public class Sort1 {

    public static void main(String[] args) {

        int k;
        int count = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите натуральное число в диапазоне от 1 до 19: ");
        while (sc.hasNextInt() == false) {
            sc.next();
            System.out.println("Введите натуральное число в диапазоне от 1 до 19: ");
        }

        k = sc.nextInt();
        //если число не входит в заданный диапазон предлогаем ввести еще
        while (k <= 0 || k >=20 ) {
            System.out.println("Введите натуральное число к в диапазоне от 1 до 19: ");
            while (sc.hasNextInt() == false) {
                sc.next();
                System.out.println("Введите натуральное число к в диапазоне от 1 до 19: ");
            }
            k = sc.nextInt();
        }

        //инициализируем 2 массива
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] arr2 = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};

        //выводим на консоль 1 массив
        System.out.println("Первый массив:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "   ");
            count++;
        }

        System.out.println("\nВторой массив:");
        //выводим на консоль 2 массив
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + "   ");
            count++;
        }

        //создаем результирующий массив с числом элементов=сумме длин двуч массивов
        int[] arr3 = new int[count];

        System.out.println("\nРезультат:");

        for (int i = 0; i < arr3.length; i++) {
            //если i<=k присваиваем элемент 1 массива
            if (i <= k) {
                arr3[i] = arr1[i];
            } else {
                //i>k -> присваиваем элемент 2 массива
                if ((i - k) <= arr2.length) {
                    arr3[i] = arr2[i - k - 1];
                } else {
                    //если все элементы 2 массива присвоены, то продолжаем
                    //присваивать оставшиеся элементы 1 массива
                    arr3[i] = arr1[i - arr2.length];
                }
            }
            System.out.print(arr3[i] + "  ");
        }
    }
}
