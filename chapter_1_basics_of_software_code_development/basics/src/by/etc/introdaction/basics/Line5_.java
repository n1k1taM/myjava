package by.etc.introdaction.basics;

import java.util.Scanner;
/**
 Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести
 данное значение длительности в часах, минутах и секундах в следующей форме:
 ННч ММмин SSc
 */
public class Line5_ {

    public static void main(String[] args) {
         
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите натуральное число:");
        int hh, mm, ss;
        int rest;
        int t=0;
         try{
             t=Integer.parseInt(sc.next());
            
             }catch(NumberFormatException e){
               System.out.println("Введенное число не является натуральным");
               System.exit(0);
             }
        hh=t/3600;
        rest=t%3600;
        mm=rest/60;
        rest=rest%60;
        ss=rest;
        
        System.out.println(hh+"ч "+mm+"мин "+ss+"с");
     }
    
}
