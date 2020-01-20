package by.etc.introdaction.algoritmization;

import java.util.Scanner;
/**
 * Написать метод(методы) для нахождения наибольшего общего делителя и
 * наименьшего общего кратного двух натуральных чисел:
 */
public class Decomposition1 {

    public static void main(String[] args) {

        int a = 0;
        int b = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите натуральное число а:");
        while(sc.hasNextInt() == false){
              sc.next();
              System.out.print("\n Введите натуральное число а:");
        }
        a = Integer.parseInt(sc.next());
        
        System.out.print("Введите натуральное число b:");
         while(sc.hasNextInt() == false){
              sc.next();
              System.out.print("\n Введите натуральное число b:");
        }
        b = Integer.parseInt(sc.next());
        
        if(a>0&&b>0){
           System.out.println("Наибольший общий делитель равен "+gcd(a,b));
           System.out.println("Наименьшее общее кратное равно "+lcm(a,b));
        }else{
             System.out.println("Вы ввели не натуральное число");
        }

      
    }

    //наибольший общий делитель
    public static int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static int lcm(int a, int b) {
        int c = a * b / gcd(a, b);
        return c;
    }

}
