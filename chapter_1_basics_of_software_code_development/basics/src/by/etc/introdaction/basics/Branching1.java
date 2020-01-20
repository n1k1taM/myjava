package by.etc.introdaction.basics;

import java.util.Scanner;

/**
  Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли
он прямоугольным.
 */
public class Branching1 {

    public static void main(String[] args) {
        
       double x=0, y=0;
         int a;
        try{
        Scanner sc= new Scanner(System.in);
        System.out.println("Введите величину первого угла в градусах:");
        x=Float.parseFloat(sc.next());
         System.out.println("Введите величину второго угла в градусах:");
        y=Float.parseFloat(sc.next());
        }
        catch ( NumberFormatException e){
           System.out.println("Вы ввели недопустимые символы");
           System.exit(0);
        }
        
        a=(int)(x+y);
        // проверяем не равен ли введенный угол нулю
        if(x==0||y==0){
           System.out.println("Треугольник стакими углами не существует");
           //сумма углов треугольника =180 -> сумма двух углов должна быть меньше
           }else if(a>=180){
                 System.out.println("Треугольник стакими углами не существует");
                    // если какой-либо угол или сумма 2-х введенный =90, то треугольник прямоугольный
                    }else if(x==90||y==90||a==90){
                             System.out.println("Треугольник существует - прямоугольный");
                             }else{
                                   System.out.println("Треугольник существует - все углы острые");
                                   }
    }
    
}
