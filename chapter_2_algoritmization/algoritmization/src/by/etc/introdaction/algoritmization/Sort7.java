package by.etc.introdaction.algoritmization;

/**
 * Пусть даны две неубывающие последовательности действительных чисел
 * Требуется указать те места, на которые нужно вставлять элементы второй последовательности  в первую
 * последовательность так, чтобы новая последовательность оставалась возрастающей.
 */
public class Sort7 {

    public static void main(String[] args) {


        int i = 0;
        int j = 0;
        double[] arr1 = {-3, 0, 1.5, 4, 6, 9};
        double[] arr2 = {-2, -0.5, 4, 7, 9, 10};

        //массив для результата
        double[] arrResult = new double[arr1.length + arr2.length];

        for (int t = 0; t < arrResult.length; t++) {

            if (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    arrResult[t] = arr1[i];
                    i++;
                } else {
                    arrResult[t] = arr2[j];
                    j++;
                }
            } else if (i < arr1.length) {
                arrResult[t] = arr1[i];
                i++;
            } else if (j < arr2.length) {
                arrResult[t] = arr2[j];
                j++;
            }
        }

        for (int n = 0; n < arrResult.length; n++) {
            System.out.print(arrResult[n] + "  ");
        }
    }

}
