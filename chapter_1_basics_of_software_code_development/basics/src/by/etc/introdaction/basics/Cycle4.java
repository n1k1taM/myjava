package by.etc.introdaction.basics;

import java.math.BigInteger;
/**
  Составить программу нахождения произведения квадратов первых двухсот чисел.
 */
public class Cycle4 {

    public static void main(String[] args) {
         BigInteger result=BigInteger.valueOf(1);
        for(int i=1; i<=200; i++){
            result=result.multiply(BigInteger.valueOf(i*i));
        }
        System.out.print(result);
    }
    
}
