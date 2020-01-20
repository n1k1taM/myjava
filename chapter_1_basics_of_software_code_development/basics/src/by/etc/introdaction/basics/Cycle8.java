package by.etc.introdaction.basics;

import java.util.Scanner;
/**
 Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
 */
public class Cycle8 {

    public static void main(String[] args) {
        
         int a=0, b=0, x=0, y=0,len1=0, len2=0;
        
         try{
        Scanner sc= new Scanner(System.in);
         
        System.out.println("Введите число a:");
        String num1=sc.next();
        len1=num1.length();
        a=Integer.parseInt(num1);

        System.out.println("Введите число b :");
        String num2=sc.next();
        len2=num2.length();
        b=Integer.parseInt(num2);
         } catch ( NumberFormatException ex){
           System.out.println("Вы ввели недопустимые символы");
           System.exit(0);
        }
         // в цикле находим цифры числа
         for(int i=1;i<=len1;i++){
             
             x=a%10;
              a=a/10;
              //каждую итерацию присваивает b1 начальное значение b
             int b1=b;
             // во внутреннем цикле сравниваем  цифру из числа а с цифрами из числа b
             for(int j=1;j<=len2;j++){
                 y=b1%10;
                 b1= b1/10;

                 if(y==x){
                  System.out.print(y+" ");
                 }
             
             }
         }
         
    }
    
}
