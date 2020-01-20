package by.etc.introdaction.basics;

import java.util.Scanner;
/*
 Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
принадлежит закрашенной области, и false — в противном случае:
 */

public class Line6_ {

    public static void main(String[] args) {
          double x=0, y=0;
         
        try{
        Scanner sc= new Scanner(System.in);
        System.out.println("Введите коордтнату точки по оси x:");
        x=Float.parseFloat(sc.next());
         System.out.println("Введите коордтнату точки по оси y:");
        y=Float.parseFloat(sc.next());
        }
        catch ( NumberFormatException e){
           System.out.println("Вы ввели недопустимые символы");
           System.exit(0);
        }
        
        if(x<=4&&x>=-4){
           if(y<=0&&y>=-3){ 
              System.out.println(true);
           } else if(x<=2&&x>=-2){  
                      if(y<=4&&y>=-3){
                           System.out.println(true);
                        } else{
                      System.out.println(false);
                      }
                    }else{
          System.out.println(false);
          }
        }else{
        System.out.println(false);
        }
      
    }
    
}
