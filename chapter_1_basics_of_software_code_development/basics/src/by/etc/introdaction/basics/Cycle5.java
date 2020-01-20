package by.etc.introdaction.basics;

import java.util.Scanner;
/**
 Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
заданному е
 */
public class Cycle5 {

    public static void main(String[] args) {
       
         double e=0, n=0, x=0, sum=0, a;
        
         try{
             
         Scanner sc= new Scanner(System.in);
        System.out.println("Введите число e:");
        e=Float.parseFloat(sc.next());
        //число n равно количеству членов ряда
        System.out.println("Введите число n :");
        n=Float.parseFloat(sc.next());
         }
        catch ( NumberFormatException ex){
           System.out.println("Вы ввели недопустимые символы");
           System.exit(0);
        }
         
         n=Math.abs(n);
         
         while(x<n){
             
             a=1/(Math.pow(2, x))+1/(Math.pow(3, x));
             
             if(a>=e){
                sum+=a;
             }
                     
                     x++;
         }
        System.out.println("Сумма равна : "+sum);
    }
    
}
