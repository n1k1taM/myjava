package by.etc.introdaction.algoritmization;

/**
Сортировка обменами. Дана последовательность чисел n a1<=a2<=...<=an  .Требуется переставить числа в
порядке убывания. Для этого сравниваются два соседних числа ai и ai+1. Если ai<ai+1 , то делается
перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке убывания.
Составить алгоритм сортировки, подсчитывая при этом количества перестановок.
 */
public class Sort4 {

    public static void main(String[] args) {
        
        int count=0;
        int buf=0;
        
        int[]arr={1,2,3,4,5};
        
        for(int t=0;t<arr.length;t++){
           System.out.print(arr[t]+"  ");
        }
        
        System.out.println();
     //*************************************************************
        for(int j=0;j<arr.length;j++){
           for(int i=0;i<arr.length-1-j;i++){
              if(arr[i]<arr[i+1]){
                 buf=arr[i];
                 arr[i]=arr[i+1];
                 arr[i+1]=buf;
                 count++;
              }
           }
        }
        //*************************************************************
         for(int t=0;t<arr.length;t++){
           System.out.print(arr[t]+"  ");
        }
         System.out.print("\n"+count);
    }
    
}
