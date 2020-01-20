package by.etc.introdaction.algoritmization;

import java.util.Arrays;
/**
 Дана последовательность целых чисел n a1 ,a2 ...an . Образовать новую последовательность, выбросив из
исходной те члены, которые равны min(a1 ,a2 ,...an ) 
 */
public class Array8 {
    public static void main(String[] args) {
       
        double min=0;
        int count=0, x=0;
        
        int[] arr=new int[20];
        
        // заполняем массив случайными числами
        for(int i=0;i<=arr.length-1;i++){
           arr[i]=(int)(Math.random()*10e6)-(int)(Math.random()*10e6);
      }
        System.out.println(Arrays.toString(arr));
        //ищем min значение перебором в цикле
        for(int i=0;i<=arr.length-1;i++){
           if(min>arr[i]){
              min=arr[i];
           }
        }
        //считаем количество элементов = min
        for(int i=0;i<=arr.length-1;i++){
           if(arr[i]==min){
             count++;
           }
        }
        //создаем новый массив и заполняем его элементами старого исключая min
        int[] newArr=new int[arr.length-count];
        
        for(int i=0;i<=arr.length-1;i++){
           
           if(arr[i]!=min){
              newArr[x]=arr[i];
              x++;
           }
        }
         System.out.print(Arrays.toString(newArr));
    }
}
