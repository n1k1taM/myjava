package by.etc.introdaction.basics;

import java.util.Scanner;

/**
 Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
 */
public class Branching3 {

    public static void main(String[] args) {
      
         double x1=0, x2=0, x3=0, y1=0, y2=0, y3=0;
         double a, b, c, p, s;
         
         try{
         Scanner sc= new Scanner(System.in);
        System.out.println("Введите координату первой точки по оси x:");
        x1=Float.parseFloat(sc.next());
        System.out.println("Введите координату первой точки по оси y:");
        y1=Float.parseFloat(sc.next());
         System.out.println("Введите координату второй точки по оси x:");
        x2=Float.parseFloat(sc.next());
        System.out.println("Введите координату второй точки по оси y:");
        y2=Float.parseFloat(sc.next());
        System.out.println("Введите координату третьей точки по оси x:");
        x3=Float.parseFloat(sc.next());
        System.out.println("Введите координату третьей точки по оси y:");
        y3=Float.parseFloat(sc.next());

        } catch ( NumberFormatException e){
           System.out.println("Вы ввели недопустимые символы");
           System.exit(0);
        }
         //находим расстояние между двумя точками. Между разными точками расстояния равны a, b, c
         a=Branching3.dist(x1, y1, x2, y2);
         b=Branching3.dist(x2, y2, x3, y3);
         c=Branching3.dist(x1, y1, x3, y3);
         
         //находтм величину полупериметра треугольника
         p=(a+b+c)/2;
         //Находим площадь треугольника используя формулу Герона
         s=Math.sqrt((p*(p-a)*(p-b)*(p-c)));
         //если площадь треугольника =0, то точки лежат на одной прямой
         if(s==0){
          System.out.println("Точки лежат на одной прямой");
         }else{
           System.out.println("Точки не лежат на одной прямой");
         }
    }

    public static double dist(double x1_, double y1_, double x2_, double y2_){
         double w1=Math.pow((x1_-x2_), 2);
         double w2=Math.pow((y1_-y2_), 2);
         
        return Math.sqrt((w1+w2));
    }
}
