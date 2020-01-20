package by.etc.introdaction.algoritmization;
/**
Написать программу, определяющую сумму n - значных чисел, содержащих только
* нечетные цифры. Определить также, сколько четных цифр в найденной сумме.
* Для решения задачи использовать декомпозицию
 */
public class Decomposition16 {

    public static void main(String[] args) {
        
        int n=1;
        
        long result=sum(n);
        System.out.println("Сумма нечетных цифр = "+result);
        System.out.println("Количество четных цифр в найденной сумме = "+quantity(result));
      
        
    }
    //определяем сумму n - значных чисел, содержащих только нечетные цифры
    public static long sum(int n){
       long sum=0;
       String start="";
       String end="";
       
       for(int i=1;i<=n;i++){
           end+=9;
           if(i==1){
               start+=1;
           }else{
              start+=0;
           }
         
       }
      for(int k=Integer.parseInt(start);k<=Integer.parseInt(end);k++){
         if(oddNumber(k)){
            sum+=k;
         }
      }
      return sum;
    }
    // если все цифры нечетные тогда true
    public static boolean oddNumber(int x){
       int y=0;
       while(x!=0){
           if((y=x%2)!=0){
               x/=10;
           }else{
              return false;
           }
       }
      return true;
    }
    //определяем количество четных цифр в результирующей сумме
    public static int quantity(long sum){
       int count=0;
       int buf=0;
       
       while(sum!=0){
          buf=(int)sum%2;
          sum/=10;
          if(buf==0){
             count++;
          }
       }
       return count;
    }
}
