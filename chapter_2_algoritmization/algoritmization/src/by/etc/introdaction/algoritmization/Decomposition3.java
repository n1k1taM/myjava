package by.etc.introdaction.algoritmization;

import java.util.Scanner;

/**
Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.
 */
public class Decomposition3 {

    public static void main(String[] args) {
       
        double side=0;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите длину стороны правильного шестиугольника:");
        while(sc.hasNextDouble() == false){
              sc.next();
              System.out.print("Введите длину стороны правильного шестиугольника:");
        }
        side = Integer.parseInt(sc.next());
        
        if(side>=0){
           System.out.println(square(side));
        }else{
             System.out.println("Вы ввели отрицательное число");
        }
        
        
    }
    
    //Площадь правильного шестиугольника равна площади равностороннего треугольника умноженной на шесть.
    public static double square(double side_){
      //(3*(3^(1/2))/2)*a^2
        return 2.598*side_*side_;
       
    }
    
}
