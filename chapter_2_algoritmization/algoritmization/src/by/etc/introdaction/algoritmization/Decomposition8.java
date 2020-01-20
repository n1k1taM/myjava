package by.etc.introdaction.algoritmization;

/**
Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов 
* массива с номерами от k до m.
 */
public class Decomposition8 {

    public static void main(String[] args) {
        
        int[] arr={1,2,3,4,5,6};
        
        System.out.print(sum3(arr,0));
        System.out.print(sum3(arr,2));
        System.out.print(sum3(arr,3));
    }
    
    public static String sum3(int[]array, int i){
       if(i+2>=array.length){
          return "Выход за пределы массива \n";
       }
       int sum=0;
       for(int j=i;j<=i+2;j++){
          sum+=array[j];
       }
       return "Сумма ="+sum+"\n";
    }
    
}
