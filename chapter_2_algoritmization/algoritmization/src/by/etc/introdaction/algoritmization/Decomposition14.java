package by.etc.introdaction.algoritmization;

/**
 * Натуральное число, в записи которого n цифр, называется числом Армстронга,
 * если сумма его цифр, возведенная в степень n, равна самому числу.
 * Найти все числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию.
 */
public class Decomposition14 {

    public static void main(String[] args) {

        int n = 1;
        int k = 100;
        int sum = 0;
        int quantity = 0;

        if (n > 0) {
            if (n <= k) {
                for (int i = n; i <= k; i++) {
                    //находим сумму цифр
                    sum = Decomposition14.sumNum(i);
                    //находим количество цифр
                    quantity = Decomposition14.quantityNum(i);
                    //проверка на число Армстронга
                    Decomposition14.numArmstrong(sum, quantity, i);
                }
            }
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

    //метод вычисляет количество цифр числа
    public static int quantityNum(int n) {
        int count = 0;

        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static void numArmstrong(int sum, int quantity, int number) {
        int result = 0;
        result = (int) Math.pow(sum, quantity);
        if (number == result) {
            System.out.print(number + " ");
        }

    }

}
