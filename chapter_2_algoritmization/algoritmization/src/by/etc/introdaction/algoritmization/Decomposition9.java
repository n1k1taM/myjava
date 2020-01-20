package by.etc.introdaction.algoritmization;

/**
 * Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы)
 * вычисления его площади, если угол между сторонами длиной X и Y— прямой.
 */
public class Decomposition9 {

    public static void main(String[] args) {

        double[] arr = {2, 2, 2, 2};

        if (exist(arr)) {
            System.out.println(square(arr));
        } else {
            System.out.println("Такой четырехугольник не существует");
        }
    }

    //проверяем существует ли четырехугольник с заданными сторонами
    public static boolean exist(double[] array) {
        double max = 0;
        double sum = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                //пропускаем
            } else {
                sum += array[i];
            }
        }
        if (max < sum) {
            return true;
        } else {
            return false;
        }
    }

    public static double square(double[] arr) {
        //найдем площадь прямоугольного треугольника
        double s1 = 0.5 * arr[0] * arr[1];
        //находим гипотенузу
        double hypot = Math.sqrt(arr[0] * arr[0] + arr[1] * arr[1]);
        //по формуле Герона вычисляем площадь второго треугольника
        double n = arr[2] * arr[2] * arr[3] * arr[3];
        double m = (arr[2] * arr[2] + arr[3] * arr[3] - hypot * hypot) * (arr[2] * arr[2] + arr[3] * arr[3] - hypot * hypot);
        double s2 = 0.25 * Math.sqrt(4 * n - m);
        //результат сумма двух треугольников
        return s1 + s2;
    }
}
