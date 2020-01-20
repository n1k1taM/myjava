package by.etc.introdaction.basics;

import java.util.Scanner;
/**
 Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера
 */
public class Cycle6 {

    public static void main(String[] args) {
       
         char a=0;
         int number=0;
         boolean b=true;   
        while(true){
         try{
             
         Scanner sc= new Scanner(System.in);
        System.out.println("Введите символ:");
       
        a=(Character)sc.next().charAt(0);
       number=(int)a;
         }
        catch ( NumberFormatException ex){
           System.out.println("Вы ввели недопустимые символы");
           System.exit(0);
        }
         System.out.println("Введенный символ: "+a+" числовое значение: "+number);
        }
         
    }
    
}
