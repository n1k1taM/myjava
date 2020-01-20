package by.etc.introdaction.basics;
/**
  Найти сумму квадратов первых ста чисел.
 */
public class Cycle3 {
    public static void main(String[] args) {
       
        int result=0;
        for(int i=1; i<=100; i++){
            int square=i*i;
            result+=square;
        }
        System.out.print(result);
        
    }
    
}
