package by.etc.introdaction.algoritmization;

/**
 Найти все натуральные n-значные числа, цифры в которых образуют строго 
 * возрастающую последовательность (например, 1234, 5789). Для решения задачи
 * использовать декомпозицию.
 */
public class Decomposition15 {
 
    static int m=1;
    
    public static void main(String[] args) {
      
        int n=4;
        int[] array=new int[n];
        sequense(n,array);
    }
    
    public static void sequense(int n, int[] arr){
        //если номер цифры меньше или = порядку числа, то выполняем алгоритм
        //если нет, то выводим массив на консоль и уменьшаем m на 1, 
        //чтобы перейти к предыдущей цифре и сделать следующую итерацию
       if(m<=n){
           
         for(int i=m;i<=(9-n+m);i++){
             //если предыдущая цифра больше текущей -> следующая итерация текущей цифры
             if(m>=2){
               if(arr[m-2]>=i){
                 continue;
               }
             }
              //если предыдущая цифра меньше текущей -> текущая цифра найдена
            arr[m-1]=i;
            //увеличиваем номер цифры, которую будем искать
            m++;
            sequense(n, arr);
            if(i==9-n+m){
              m-=1;
            }
         }
       }else{
           m-=1;
           for(int i=0;i<arr.length;i++){
              System.out.print(arr[i]);
           }
          System.out.println();
       }
    }
    
}
