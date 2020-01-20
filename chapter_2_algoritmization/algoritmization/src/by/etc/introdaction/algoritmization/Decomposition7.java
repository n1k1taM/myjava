package by.etc.introdaction.algoritmization;

/**
 Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9
 */
public class Decomposition7 {

    static int fact=1;
    static int summ=0;
    
    public static void main(String[] args) {
      
        int[] array=new int[5];//массив для хранения значений факториала для чисел 1,3,5,7,9
        
        for(int t=1,n=0;t<=9;t+=2,n++){
           array[n]=factorial(t);
        }
        System.out.println(sum(array));
        
    }
    // вычисляем сумму значений факториалов в массиве
    public static int sum(int[]arr){
       for(int i=0;i<arr.length;i++){
          summ+=arr[i];
       }
       return summ;
    }
    
    public static int factorial(int a){
        fact=1;
       for(int j=1;j<=a;j++){
          fact*=j;
       }
       return fact;
    }
    
}
