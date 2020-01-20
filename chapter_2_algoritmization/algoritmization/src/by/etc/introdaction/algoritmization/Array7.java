package by.etc.introdaction.algoritmization;

/*
 Даны действительные числа n a1 ,a2 , ,a n  . Найти
 max(a1, a2,...,an )
 */
public class Array7 {
    public static void main(String[] args) {

        double max = 0;

        double[] arr = new double[20];

        // заполняем массив случайными числами
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = (Math.random() * 10e6) - (Math.random() * 10e6);
        }
        //ищем макс. значение перебором в цикле
        for (int i = 0; i <= arr.length - 1; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.print(max);
    }
}
