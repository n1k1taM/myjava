/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.etc.introdaction.basics;

import java.util.Scanner;

/**
 Вычислить значение выражения по формуле (все переменные принимают действительные значения):
 (𝑠𝑖𝑛 𝑥 + 𝑐𝑜𝑠 y)/(𝑐𝑜𝑠 𝑥 − 𝑠𝑖𝑛 y)∗ 𝑡𝑔 𝑥y
 */
public class Line3_ {

    public static void main(String[] args) {
        
     double x=0, y=0;
        try{
        Scanner sc= new Scanner(System.in);
        System.out.print("Введите число x:");
        x=Float.parseFloat(sc.next());
         System.out.print("Введите число y:");
        y=Float.parseFloat(sc.next());
        }catch ( NumberFormatException e){
           System.out.println("Вы ввели недопустимые символы");
           System.exit(0);
        }
        // вычисляем члены выражения

         double w1=Math.sin(Math.toRadians(x));
         double w2=Math.cos(Math.toRadians(y));
         double w3=Math.cos(Math.toRadians(x));
         double w4=Math.sin(Math.toRadians(y));
         double w5=Math.tan(Math.toRadians(x*y));
         // округляем до 1000
         w1=Math.round(w1*1000)/1000.0;
         w2=Math.round(w2*1000)/1000.0;
         w3=Math.round(w3*1000)/1000.0;
         w4=Math.round(w4*1000)/1000.0;
         w5=Math.round(w5*1000)/1000.0;
         // подставляем вычисленные переменные в исходное выражение
         double result=(w1+w2)/(w3-w4)*w5;
         result=Math.round(result*1000)/1000.0;
         System.out.println( result);
            System.out.println( "w1="+w1+" w2="+w2+" w3="+w3+" w4="+w4+" w5="+w5+" result= "+result);


          
       
    }

}
