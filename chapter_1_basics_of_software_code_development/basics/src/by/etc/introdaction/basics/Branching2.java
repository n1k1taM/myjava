package by.etc.introdaction.basics;

import java.util.Scanner;
/**
  Найти max{min(a, b), min(c, d)}.
 */
public class Branching2 {

    public static void main(String[] args) {
        
         double a=0, b=0, c=0, d=0;
         double min1, min2;
         
         try{
         Scanner sc= new Scanner(System.in);
        System.out.println("Введите число a:");
        a=Float.parseFloat(sc.next());
        System.out.println("Введите число b:");
        b=Float.parseFloat(sc.next());
         System.out.println("Введите число c:");
        c=Float.parseFloat(sc.next());
        System.out.println("Введите число d:");
        d=Float.parseFloat(sc.next());

        } catch ( NumberFormatException e){
           System.out.println("Вы ввели недопустимые символы");
           System.exit(0);
        }
         // находим мин(a,b)
         if(a<=b){
           min1=a;
           }else{
                 min1=b;
           }
         // находим мин(c,d)
          if(c<=d){
           min2=c;
           }else{
                 min2=d;
           }
          //находим макс(мин1, мин2)
          if(min1>=min2){
          System.out.println("Решением является число: " +min1);
            }else{
                  System.out.println("Решением является число: " +min2);
            }
    }
}
