package by.etc.introdaction.algoritmization;

import java.util.Scanner;
/**
 * Написать метод(методы), определяющий, в каком из данных двух чисел больше
 * цифр
 */
public class Decomposition11 {

    public static void main(String[] args) {

        long a = 0;
        long b = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите целое число а:");
        while (sc.hasNextLong() == false) {
            sc.next();
            System.out.print("\n Введите целое число а:");
        }
        a = Long.parseLong(sc.next());

        System.out.print("Введите целое число b:");
        while (sc.hasNextLong() == false) {
            sc.next();
            System.out.print("\n Введите целое число b:");
        }
        b = Long.parseLong(sc.next());
        
        System.out.println(moreNumber(a,b));
    }

    
    public static String moreNumber(long a, long b){
       int countA=0;
       int countB=0;
       long a_=a;
       long b_=b;
       
       while(a_!=0){
          a_/=10;
          countA++;
       }
       
        while(b_!=0){
          b_/=10;
          countB++;
       }
        
        if(countA>countB){
           return ""+ a;
        }else if(countA==countB){
           return "Числа имеют одинаковое количество цифр: "+countA;
        }else {
           return ""+ b;
        }
    }
}
