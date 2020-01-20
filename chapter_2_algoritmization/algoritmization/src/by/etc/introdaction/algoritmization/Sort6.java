package by.etc.introdaction.algoritmization;

/**
 * Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
 * Делается это следующим образом: сравниваются два соседних элемента ai и ai+1. Если ai<=ai+1 , то продвигаются
 * на один элемент вперед. Если ai>ai+1 , то производится перестановка и сдвигаются на один элемент назад.
 * Составить алгоритм этой сортировки.
 */
public class Sort6 {

    public static void main(String[] args) {

        double[] array = {1, 3, 0, -4, 7, 0.4, 23};
        double buf = 0;

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                //еслт текущий элемент меньше предыдущего, то перестановка
                if (array[j] < array[j - 1]) {
                    buf = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = buf;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }


    }


}
