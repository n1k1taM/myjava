package by.etc.introdaction.algoritmization;
/**
Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
 */
public class Array5 {
    public static void main(String[] args) {
       
        int m=0;
        int[] arr=new int[20];
        // заполняем массив случайными числами
        for(int i=0;i<=arr.length-1;i++){
           arr[i]=(int)(Math.random()*100);
        }
        //если элемент массива > индекса, то выводим на печать
        for(int i=0;i<=arr.length-1;i++){
           if(arr[i]>i){
              System.out.println("Элемент массива ="+arr[i]+" Индекс ="+i);
           }
        }
    }
}
