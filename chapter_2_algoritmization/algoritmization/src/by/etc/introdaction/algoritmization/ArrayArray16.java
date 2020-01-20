package by.etc.introdaction.algoritmization;

import java.util.Scanner;
/*
 * Магическим квадратом порядка n называется квадратная матрица размера nxn,
 * составленная из чисел 1, 2, 3, ..., 2 n так, что суммы по каждому столбцу,
 * каждой строке и каждой из двух больших диагоналей равны между собой.
 * Построить такой квадрат. (вывести все квадраты порядка n)
 */
public class ArrayArray16 {

    static int n = 0;
    static int[][] array;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите порядок квадрата: ");
        while (sc.hasNextInt() == false) {
            sc.next();
            System.out.println("Введите порядок квадрата");
        }
        n = sc.nextInt();
        if (n < 3) {
            System.out.println("Магический квадрат с порядком меньше 3 не существует");
        } else if (n % 4 == 0) {
            multipleFourSquare();
            printSquare();
        } else if (n % 2 != 0) {
            oddSquare();
            printSquare();
        } else {
            n = n - 2;
            evenOddOrder();
            printSquare();
        }
    }

    //индийский метод для нечетного порядка
    static void oddSquare() {
        array = new int[n][n];
        int x = 0;
        int y = (n - 1) / 2;
        //верхняя строка, средний элемент = 1
        array[x--][y++] = 1;

        for (int m = 2; m <= (n * n); m++, x--, y++) {
            if ((x < 0) && (y > (n - 1))) {
                x = x + 2;
                y = y - 1;
            } else if (x < 0) {
                x = n - 1;
            } else if (y > (n - 1)) {
                y = 0;
            }

            if (array[x][y] == 0) {
                array[x][y] = m;
            } else {
                x = x + 2;
                y = y - 1;
                array[x][y] = m;
            }
        }
    }


    static void printSquare() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + "       ");
            }
            System.out.println();
            System.out.println();
        }
    }

    //метод Рауз-Болла для порядка кратного 4
    static void multipleFourSquare() {
        int buf;
        array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = i * n + j + 1;
            }
        }
        for (int i = 0, j = 0; i <= n / 2 - 1; i++, j++) {
            buf = array[i][j];
            array[i][j] = array[n - 1 - i][n - 1 - j];
            array[n - 1 - i][n - 1 - j] = buf;

            buf = array[i][n - 1 - j];
            array[i][n - 1 - j] = array[n - 1 - i][j];
            array[n - 1 - i][j] = buf;
        }
        int w = 4;
        if (n > 4) {
            while (w < (n - 1)) {
                int k = 1;
                for (int i = 0, j = w; j <= n - 1; i++, j++) {
                    buf = array[i][j];
                    array[i][j] = array[n - 1 - i][n - 1 - j];
                    array[n - 1 - i][n - 1 - j] = buf;
                }
                for (int i = 0, j = w - 1; j >= 0; i++, j--) {
                    buf = array[i][j];
                    array[i][j] = array[n - 1 - i][n - 1 - j];
                    array[n - 1 - i][n - 1 - j] = buf;
                }
                w = w + 4;
            }
        }
    }

    //метод окаймленных квадратов четно-нечетного порядка
    static void evenOddOrder() {
        multipleFourSquare();
        //увеличиваем все элементы полученного массива на 2(n-1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = array[i][j] + 2 * (n + 2 - 1);
            }
        }
        n = n + 2;
        int[][] evenOddArray = new int[n][n];
        //заполняем новый массив
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                evenOddArray[i][j] = array[i - 1][j - 1];
            }
        }
        //заполняем угловые ячейки
        int m = n / 2;
        int d = n * n + 1;
        evenOddArray[0][0] = 3 * m - 1;
        evenOddArray[0][n - 1] = 1;
        evenOddArray[n - 1][0] = d - 1;
        evenOddArray[n - 1][n - 1] = d - 3 * m + 1;
        //заполняем верхнюю и нижнюю строки
        int t = 1;
        for (int j = 1; j < n - 1; j++) {
            if (j <= m) {
                evenOddArray[0][j] = d - 2 * j;
                evenOddArray[n - 1][j] = (n * n + 1) - evenOddArray[0][j];
            } else if (t <= m - 2) {
                evenOddArray[0][j] = 2 * t + 1;
                evenOddArray[n - 1][j] = (n * n + 1) - evenOddArray[0][j];
                t++;
            }
        }
        //заполняем левый и правый столбец
        int mm = m / 2;
        int q = 1;
        int l = 1;
        int p = 1;
        for (int i = 1; i < n - 1; i++) {
            if (q <= mm - 1) {
                evenOddArray[i][0] = 3 * m - 1 + q;
                evenOddArray[i][n - 1] = (n * n + 1) - evenOddArray[i][0];
                i++;
                evenOddArray[i][0] = d - 2 * m - q;
                evenOddArray[i][n - 1] = (n * n + 1) - evenOddArray[i][0];
                q++;
            } else if (p <= mm) {
                evenOddArray[i][0] = 3 * m - 1 - p;
                evenOddArray[i][n - 1] = (n * n + 1) - evenOddArray[i][0];
                p++;
            } else if (l <= mm + 1) {
                evenOddArray[i][0] = d - 4 * m + 1 + l;
                evenOddArray[i][n - 1] = (n * n + 1) - evenOddArray[i][0];
                l++;
            } else {
                evenOddArray[i][0] = 2 * m - 1;
                evenOddArray[i][n - 1] = (n * n + 1) - evenOddArray[i][0];
            }
        }
        array=evenOddArray;
    }
}
