package by.etc.introdaction.algoritmization;

import java.util.Arrays;

/**
 * В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
 * чисел несколько, то определить наименьшее из них.
 */
public class Array9 {
    public static void main(String[] args) {

        int num = 0, max = 0, index = 0;

//создаем два массива
        int[] arr = new int[10];
        int[] arr2 = new int[10];

        //заполняем основной массив
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        // выводим основной массив на консоль
        System.out.println(Arrays.toString(arr));

        // Находим сколько раз каждое число находится в массиве
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    num++;
                }
            }
            arr2[i] = num; // Заполняем массив arr2 этими значениями
            num = 0;
        }

        // выводим 2 массив элементы которого равны количеству повторений элементов в 1 массиве
        System.out.println(Arrays.toString(arr2));

        // находим максимальный элемент во 2 массиве и запоминаем его индекс
        for (int i = 0; i < arr2.length - 1; i++) {
            if (arr2[i] >= max) {

                max = arr2[i];
                index = i;
            }
        }
        // проверяем на равенство max со значениями 2 массива
        // если =, то находим меньшее число в 1 массиве по индексам
        for (int i = 0; i < arr2.length; i++) {
            if (max == arr2[i]) {
                if (arr[index] <= arr[i]) {
                    max = arr2[index];
                } else {
                    max = arr2[i];
                    index = i;
                }
            }
        }
        System.out.print("Элемент " + arr[index] + " встречается " + max + " раз");
    }
}
