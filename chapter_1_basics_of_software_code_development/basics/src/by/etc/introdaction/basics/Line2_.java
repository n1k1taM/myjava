/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.etc.introdaction.basics;

import java.util.Scanner;

/**
 Вычислить значение выражения по формуле (все переменные принимают действительные значения):
 * ((𝑏 + √(𝑏^2 + 4𝑎𝑐)) / 2𝑎) − (𝑎^3)*𝑐 + 𝑏^(−2)
 */

public class Line2_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     double a=0, b=0, c=0;
     
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
         //вычислим некоторые части выражения и присвоим их переменным x, y, z
        double x=Math.sqrt(Math.pow(b,2)+4*a*c);
        double y=Math.pow(a,3)*c;
        double z=Math.pow(b,0.5);
        // вычисляем общее выражение
        double result=(b+x)/(2*a)-y+z;

        System.out.println( result);
    }

}
