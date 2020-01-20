package by.etc.introdaction.algoritmization;

import java.util.Arrays;
/**
 * Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
 * элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
 */
public class Array10 {
    public static void main(String[] args) {

        int[] arr = new int[20];

        // заполняем массив случайными числами
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        System.out.println(Arrays.toString(arr));

        // если остаток от деления на 2 не равен 0, то присваиваем текущему элементу 0
        for (int i = 0; i <= arr.length - 1; i++) {
            if (i % 2 != 0) {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
