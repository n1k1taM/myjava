package by.etc.introdaction.algoritmization;

/**
 * Даны натуральные числа К и N. Написать метод(методы) формирования массива А,
 * элементами которого являются числа, сумма цифр которых равна К и которые не большее N
 */
public class Decomposition12 {

    public static void main(String[] args) {

        int k = 12;
        int n = 100;

        if (k > 0 && n > 0) {

            int[] array = new int[sizeArray(k, n)];
            fillArray(array, k, n);

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        } else {
            System.out.println("Числа не являются натуральными");
        }


    }

    //метод вычисляет сумму цифр числа
    public static int sumNum(int n) {
        int sum = 0;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    //метод вычисляет размер массива, который нужно создать
    public static int sizeArray(int k, int n) {
        int count = 0;
        int sum_ = 0;

        for (int i = 1; i <= n; i++) {
            sum_ = sumNum(i);

            if (sum_ == k) {
                count++;
            }
            sum_ = 0;
        }
        return count;
    }

    // заполняем массив
    public static void fillArray(int[] arr, int k, int n) {
        int i = 0;
        int sum1 = 0;
        for (int j = 1; j <= n; j++) {
            sum1 = sumNum(j);

            if (sum1 == k) {
                arr[i] = j;
                i++;
            }
        }
    }
}
