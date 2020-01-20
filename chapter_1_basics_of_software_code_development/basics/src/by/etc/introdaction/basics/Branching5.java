package by.etc.introdaction.basics;

import java.util.Scanner;
/*
 * Вычислить значение функции:
 * x^2 - 3x + 9, если x <= 3;
 * 1 / (x^3 + 6), если x > 3.
 */
public class Branching5 {

    public static void main(String[] args) {
       
         double x=0, y=0;
         double result;
         
        try{
        Scanner sc= new Scanner(System.in);
        System.out.println("Введите число x:");
        x=Float.parseFloat(sc.next());
         
        }catch ( NumberFormatException e){
           System.out.println("Вы ввели недопустимые символы");
           System.exit(0);
        }
        // вычисляем значение одной из двух функций в зависимости от значения x
        if(x<=3){
          result=Math.pow(x, 2)-3*x+9;
        }else{
         result=1/(Math.pow(x, 3)+6);
        }
        System.out.print("Значение функции ="+result);
    }
    
}
