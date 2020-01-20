/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.etc.introdaction.basics;

import java.util.Scanner;

/**
 . Найдите значение функции: z = ( (a – 3 ) * b / 2) + c
 */
public class Line1_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        float a=0, b=0, c=0;
        
        try{
        Scanner sc= new Scanner(System.in);
        System.out.print("Введите число a:");
        a=Float.parseFloat(sc.next());
         System.out.print("Введите число b:");
        b=Float.parseFloat(sc.next());
         System.out.print("Введите число c:");
        c=Float.parseFloat(sc.next());
        
        }catch ( NumberFormatException e){
           System.out.println("Вы ввели недопустимые символы");
           System.exit(0);
        }
        float x=(((a-3)*b/2)+c);
        System.out.println( x);
        
    }

}
