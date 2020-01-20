package by.etc.introdaction.basics;

import java.util.Scanner;
/**
Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует
все числа от 1 до введенного пользователем числа.
 */
public class Cycle1 {

    public static void main(String[] args) {
       
         int number=0, result=0;

        try{
        Scanner sc= new Scanner(System.in);
        System.out.println("Введите целое положительное число:");
        number=Integer.parseInt(sc.next());

        } catch ( NumberFormatException e){
           System.out.println("Вы ввели недопустимые символы или слишком большое число");
           System.exit(0);
        }
        for(int i=1; i<=number;i++ ){
            
            int differ=Integer.MAX_VALUE-result;

            if(differ<i){
               System.out.println("Результат превышает максимальное значение для числа int");
               System.exit(0);
               }else{
                     result+=i;
            }
        }
        System.out.println(result);
    }
}
