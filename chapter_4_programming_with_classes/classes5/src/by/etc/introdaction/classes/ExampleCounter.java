package by.etc.introdaction.classes;

import java.util.Scanner;

public class ExampleCounter {

    public static void main(String[] args){
        Counter counter1=new Counter();
        Scanner sc;
        int max;
        int min;
        int current;

        System.out.println("Текущее значение: "+counter1.getCurrentValue()+"; Минимальное значение: "+
                counter1.getMinValue()+"; Максимальное значение: "+counter1.getMaxValue());

        System.out.println( counter1.decreseCurrentValue());
        System.out.println( counter1.decreseCurrentValue());
        System.out.println( counter1.decreseCurrentValue());
        System.out.println( counter1.decreseCurrentValue());
        System.out.println("Текущее значение: "+counter1.getCurrentValue());

        counter1.decreseCurrentValue();
        counter1.decreseCurrentValue();
        System.out.println( counter1.increseCurrentValue());
        System.out.println( counter1.getCurrentValue());

        sc=new Scanner(System.in);
        System.out.println("Enter the max value");
        while(sc.hasNextInt()==false){
            sc.next();
            System.out.println("Enter the max value");
        }
        max=sc.nextInt();
        System.out.println("Enter the min value");
        while(sc.hasNextInt()==false){
            sc.next();
            System.out.println("Enter the min value");
        }
        min=sc.nextInt();
        Counter counter2=new Counter(max-min, min, max);
        System.out.println("Текущее значение: "+counter2.getCurrentValue()+"; Минимальное значение: "+
                counter2.getMinValue()+"; Максимальное значение: "+counter2.getMaxValue());


    }

}
