package by.etc.introdaction.algoritmization;

/**
Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д.
* Сколько таких действий надо произвести, чтобы получился нуль? 
* Для решения задачи использовать декомпозицию.
 */
public class Decopmosition17 {

    public static void main(String[] args) {
      
        int n=100;
        
        System.out.println(result(n));
    }
    //сумма цифр числа
    public static int sumNum(int n){
       int sum=0;
       
       while(n!=0){
          sum+=n%10;
          n/=10;
       }
       return sum;
    }
    
    public static int result(int number){
       int sum=0;
       int count=0;
       while(number!=0){
         sum=sumNum(number);
         number-=sum;
         count++;
       }
       return count;
    }
}
