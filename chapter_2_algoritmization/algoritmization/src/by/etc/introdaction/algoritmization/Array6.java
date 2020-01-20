package by.etc.introdaction.algoritmization;

/**
 * Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
 * являются простыми числами.
 */
public class Array6 {
    public static void main(String[] args) {

        double sum = 0;
        boolean b = false;

        double[] arr = new double[20];
        // заполняем массив случайными числами
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = (Math.random() * 1000000) - (Math.random() * 1000000);
        }
        for (int i = 0; i <= arr.length - 1; i++) {
            //число 2 является простым
            if (i == 2) {
                sum += arr[i];
            }
            // проверяем делители числа i начиная с 2
            for (int t = 2; t < i; t++) {
                b = true;
                if (i % t == 0) {
                    // если делитель есть, то не суммируем его
                    b = false;
                    break;
                }
            }
            if (b) {
                sum += arr[i];
            }
        }
        System.out.print(sum);
    }
}
