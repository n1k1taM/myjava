package by.etc.introdaction.algoritmization;

/**
Составить программу, которая в массиве A[N] находит второе по величине число
* (вывести на печать число, которое меньше максимального элемента массива, 
* но больше всех других элементов).
 */
public class Decomposition5 {

    public static void main(String[] args) {
       
        int[]array={1,3,5,7,8,7,9,15,12,14,14};
        
        System.out.print(preMax(array));
        
    }
    
    public static int preMax(int[]arr){
        
        int max=0;
        int buf=0;
        for(int i=0;i<arr.length;i++){
          if(max<arr[i]){
             buf=max;
             max=arr[i];
          }else if(buf<arr[i]){
               buf=arr[i];
          }
       }
       return buf;
    }
}
