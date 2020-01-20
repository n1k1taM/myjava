package by.etc.introdaction.basics;

import java.util.Scanner;
/**
Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
m и n вводятся с клавиатуры
 */
public class Cycle7 {

    public static void main(String[] args) {
       
        int n=0, m=0, x,y,t;
        
         try{
         Scanner sc= new Scanner(System.in);
        System.out.println("Введите число n:");
        n=Integer.parseInt(sc.next());
        //число n равно количеству членов ряда
        System.out.println("Введите число m :");
        m=Integer.parseInt(sc.next());
         }
        catch ( NumberFormatException ex){
           System.out.println("Вы ввели недопустимые символы");
           System.exit(0);
        }
         
         for( x=n;x<=m;x++){
              System.out.print("Делители для числа "+x+":");
            for( y=2;y<x;y++){
                 t=x%y;
                 if(t==0){
                    System.out.print(" "+y+"");
                 }
            }
            System.out.println();
         }
    }
    
}
