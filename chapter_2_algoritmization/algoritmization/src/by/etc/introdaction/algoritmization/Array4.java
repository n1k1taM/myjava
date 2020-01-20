package by.etc.introdaction.algoritmization;

import java.util.Arrays;
import java.util.Random;

/**
 * Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
 */
public class Array4 {
    public static void main(String[] args) {

        float min = 0, max = 0;
        int minind = 0, maxind = 0;

        Random r = new Random();
        float[] ar = new float[10];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = r.nextInt() * Integer.MAX_VALUE - r.nextInt() * Integer.MAX_VALUE;
        }
        String intArrayString = Arrays.toString(ar);

        System.out.println("Старый массив " + intArrayString);

        for (int i = 0; i <= ar.length - 1; i++) {
            if (min > ar[i]) {
                min = ar[i];
                minind = i;
            }
            if (max < ar[i]) {
                max = ar[i];
                maxind = i;
            }
        }
        ar[minind] = max;
        ar[maxind] = min;

        String arrStrReplace = Arrays.toString(ar);
        System.out.println("Новый массив " + arrStrReplace);
    }
}
