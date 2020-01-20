package by.etc.introdaction.basics;

import java.util.Scanner;
/**
  Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
отверстие.
 */
public class Branching4 {

    public static void main(String[] args) {
        
         double a=0, b=0, x=0, y=0, z=0;
         double min1, min2;
         
         try{
         Scanner sc= new Scanner(System.in);
          System.out.println("Задаем размеры отверстия");
        System.out.println("Введите число А:");
        a=Float.parseFloat(sc.next());
        System.out.println("Введите число B:");
        b=Float.parseFloat(sc.next());
         System.out.println("Задаем размеры кирпича");
         System.out.println("Введите число x:");
        x=Float.parseFloat(sc.next());
        System.out.println("Введите число y:");
        y=Float.parseFloat(sc.next());
        System.out.println("Введите число z:");
        z=Float.parseFloat(sc.next());

        } catch ( NumberFormatException e){
           System.out.println("Вы ввели недопустимые символы");
           System.exit(0);
        }

// сравниваем размеры кирпича разными сторонами с размерами отверстия
if (((a>=x) && (b>=y))||((a>=y) && (b>=x)) || ((a>=x) && (b>=z))||((a>=z) && (b>=x)) || ((a>=z)&& (b>=y))||((a>=y) && (b>=z)) ){
         System.out.println("Влезет");  
  } else{
         System.out.println("не влезет");
  }

    }
    
}
