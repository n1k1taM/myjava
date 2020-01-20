package by.etc.introdaction.basics;

import java.util.Scanner;
/**
Вычислить значения функции на отрезке [а,b] c шагом h:
 */
public class Cycle2 {

    public static void main(String[] args) {
       
         double a=0, b=0, h=0, y, x;
        
         try{
             
         Scanner sc= new Scanner(System.in);
        System.out.println("Введите число начала интервала:");
        a=Float.parseFloat(sc.next());
        System.out.println("Введите число окончания интервала :");
        b=Float.parseFloat(sc.next());
         System.out.println("Введите шаг h:");
        h=Float.parseFloat(sc.next());
         }
        catch ( NumberFormatException e){
           System.out.println("Вы ввели недопустимые символы");
           System.exit(0);
        }
        
         for( x=a; x<=b; x=x+h){
             
             if(x>2){
                y=x;
                System.out.println("При x="+x+" y="+y);
             }else{
                y=-x;
                System.out.println("При x="+x+" y="+y);
             }
         
         }
    }
    
}
